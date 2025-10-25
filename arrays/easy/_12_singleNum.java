package arrays.easy;

public class _12_singleNum {
    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2,5,5};
        singleNum(arr);
    }

    static int singleNum(int[] nums) {
        int xor = 0;
        for (int i=0; i<nums.length; i++) {
            xor = xor ^ nums[i];
            // String s1 = Integer.toBinaryString(nums[i]);
            // String s2 = Integer.toBinaryString(xor);
            // System.out.println(i+" - "+nums[i]+" "+xor+" "+s1+" "+s2);
        }
        return xor;
    }
}

/*
 * URL: https://leetcode.com/problems/single-number/description/

136. Single Number

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

 
Example 1:
Input: nums = [2,2,1]
Output: 1
Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
Example 3:
Input: nums = [1]
Output: 1

 
Constraints:

	1 <= nums.length <= 3 * 104
	-3 * 104 <= nums[i] <= 3 * 104
	Each element in the array appears twice except for one element which appears only once.
 */