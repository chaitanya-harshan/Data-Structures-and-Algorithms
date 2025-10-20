package arrays.medium;

public class __min_size_subArr_sum_GE_k {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int sum = 0;
        int minLen = nums.length+1;

        for (int r=0; r<nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                minLen = Math.min(minLen, r-l+1);
                sum -= nums[l++];
            }
        }
        return minLen == nums.length+1 ? 0 : minLen;
    }
}

/*
 * URL: https://leetcode.com/problems/minimum-size-subarray-sum/description/

209. Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, return the minimal length of a  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 
Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

 
Constraints:

	1 <= target <= 109
	1 <= nums.length <= 105
	1 <= nums[i] <= 104
	Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */