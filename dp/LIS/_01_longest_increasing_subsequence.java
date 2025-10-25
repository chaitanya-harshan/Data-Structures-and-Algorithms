package dp.LIS;

import java.util.Arrays;

public class _01_longest_increasing_subsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        // dp[i] will store the length of the longest increasing subsequence ending at index i.
        // Initialize all dp[i] to 1, as each element itself forms an LIS of length 1.
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int LIS = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            LIS = Math.max(LIS, dp[i]);
        }
        return LIS;
    }
}

/*
 * URL: https://leetcode.com/problems/longest-increasing-subsequence/description/

300. Longest Increasing Subsequence

Given an integer array nums, return the length of the longest strictly increasing subsequence.
``A subsequence is an array that can be derived from another array by deleting some or no 
elements without changing the order of the remaining elements.``

 
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