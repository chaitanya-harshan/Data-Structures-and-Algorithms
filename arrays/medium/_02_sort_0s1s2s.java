package arrays.medium;

import java.util.Arrays;

public class _02_sort_0s1s2s {
    public static void main(String[] args) {
        int[] arr = {0,1,2,1,0,2,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortColors(int[] nums) {
        int n = nums.length;
        int z = 0, t = n-1;

        int i = 0;
        while (i <= t) {
            if (nums[i] == 0) {
                swap(i, z, nums);
                z++;
                i++;
            }
            else if (nums[i] == 2) {
                swap(i, t, nums);
                t--;
            }
            else i++;
        } 
    }

    static void swap (int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that 
 * objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * 
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
 */