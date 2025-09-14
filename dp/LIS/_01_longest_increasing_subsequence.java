package dp.LIS;

public class _01_longest_increasing_subsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int LIS = 1;
        int[] dp = new int[n];

        for (int i=n-1; i>=0; i--) {
            int max = 1;
            for (int j=i+1; j<n; j++) {
                if (nums[i] < nums[j]) {
                    max = Math.max(max, 1 + dp[j]);
                }
            }
            dp[i] = max;
            LIS = Math.max(LIS, max);
        }
        return LIS;
    }
}

/*
 * URL: https://leetcode.com/problems/longest-increasing-subsequence/description/

300. Longest Increasing Subsequence

Given an integer array nums, return the length of the longest strictly increasing .

 
Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1

 
Constraints:

	1 <= nums.length <= 2500
	-104 <= nums[i] <= 104
	Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */