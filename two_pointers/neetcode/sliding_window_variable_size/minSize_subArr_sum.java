package two_pointers.neetcode.sliding_window_variable_size;

public class minSize_subArr_sum {
    
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, sum = 0, len = nums.length+1;

        for (int r = 0; r<nums.length; r++) {
            sum += nums[r];
            while (sum >=  target) {
                len = Math.min(len, r-l+1);
                sum -= nums[l];
                l++;
            }
        }
        return len != nums.length+1 ? len : 0;
    }
}

/*
 * 209. Minimum Size Subarray Sum
https://leetcode.com/problems/minimum-size-subarray-sum/description/

Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

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
 */