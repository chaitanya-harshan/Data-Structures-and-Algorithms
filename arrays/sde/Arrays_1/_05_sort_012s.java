public class _05_sort_012s {
    
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length-1;

        int i = 0;
        while (i <= two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            }
            else if (nums[i] == 2) {
                swap(nums, i, two);
                two--;
                // if it's 2 we stll need to check for the swaped num again so no i++
            }
            else i++;
        }
    }

    static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}


// https://leetcode.com/problems/sort-colors/


/*
 * 75 . Sort Colors
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 
 */