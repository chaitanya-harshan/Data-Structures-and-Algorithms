package _extras.arrays.easy;

class _07_moveZeroes {
    public void _07_moveZeroes(int[] nums) {
        int i = 0;
        for (int j=0; j<nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        while(i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
}

/*
 * URL: https://leetcode.com/problems/move-zeroes/description/

283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the 
non-zero elements.
Note that you must do this in-place without making a copy of the array.

 
Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:
Input: nums = [0]
Output: [0]

 
Constraints:

	1 <= nums.length <= 104
	-231 <= nums[i] <= 231 - 1
	Follow up: Could you minimize the total number of operations done?
 */