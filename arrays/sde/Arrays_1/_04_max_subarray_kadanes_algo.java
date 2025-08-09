package arrays.sde.Arrays_1;

public class _04_max_subarray_kadanes_algo {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i= 0; i<nums.length; i++) {
            sum += nums[i];
            if (sum > max) max = sum;// this needs to be top of sum < 0 => sum = 0 eg: nums = [-1]
            if (sum < 0) sum = 0;
        }
        return max;
    }
}

/*

https://leetcode.com/problems/maximum-subarray/description/

 * 53. Maximum Subarray
Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6


 */
