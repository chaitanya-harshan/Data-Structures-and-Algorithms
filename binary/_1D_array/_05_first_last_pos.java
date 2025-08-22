package binary._1D_array;

import java.util.Arrays;

public class _05_first_last_pos {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int[] ans = searchRange(arr, 4);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(BettersearchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(BettersearchRange(new int[]{1,1,1,2,2,3,3}, 3)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int fp = firstIndex(nums, target);

        if (fp == -1){
            return new int[]{-1,-1};
        }
        else return new int[]{fp, lastIndex(nums, target)};
    }

    static int firstIndex(int[] nums, int target) {
        int n = nums.length;
        int l = 0, h = n-1;
        while (l <= h) {
            int m = l+h >> 1;
            if (nums[m] >= target) h = m-1;
            else l = m+1;
        }
        if (l > n-1 || nums[l] != target) return -1;
        return l;
        // int n = nums.length;
        // int first = -1;
        // int low = 0, high = n-1;
        //
        // while (low <= high) {
        //     int mid = (low + high)/2;
        //     if (nums[mid] == target) {
        //         high = mid-1;
        //         first = mid;
        //     }
        //     else if (nums[mid] > target) high = mid-1;
        //     else low = mid+1;
        // }
        // return first;
    }

    static int lastIndex(int[] nums, int target) {
        int n = nums.length;
        int l = 0, h = n-1;
        while (l <= h) {
            int m = l+h >> 1;
            if (nums[m] <= target) l = m+1;
            else h = m-1;
        }
        // lastIndex is called only if firstIndex != -1 so we are sure target exist
        return h; 
        // int n = nums.length;
        // int last = -1;
        // int low = 0, high = n-1;

        // while (low <= high) {
        //     int mid = (low + high)/2;
        //     if (nums[mid] == target) {
        //         low = mid+1;
        //         last = mid;
        //     }
        //     else if (nums[mid] > target) high = mid-1;
        //     else low = mid+1;
        // }
        // return last;
    }

    //____________________________________________________________________________________________________________________________

    //  BETTER VERSION using direct binary search instead of lower Bound, upper Bound
    public static int[] BettersearchRange(int[] nums, int target) {
        int fp = firstIndex1(nums, target);
        // int lp = lastIndex(nums, target); // calling it hear will not decrese the O(n) to log(n) 
        // when target doesnt exist as it will call last index function also when it doesn't have to

        if (fp == -1){
            return new int[]{-1,-1};
        }
        else return new int[]{fp, lastIndex1(nums, target)};
    }

    static int firstIndex1(int[] nums, int target) {
        int n = nums.length;
        int first = -1;
        int low = 0, high = n-1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] == target) {
                high = mid-1;
                first = mid;
            }
            else if (nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return first;
    }

    static int lastIndex1(int[] nums, int target) {
        int n = nums.length;
        int last = -1;
        int low = 0, high = n-1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] == target) {
                low = mid+1;
                last = mid;
            }
            else if (nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return last;
    }
}

/*
 * URL: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 
Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

 
Constraints:

	0 <= nums.length <= 105
	-109 <= nums[i] <= 109
	nums is a non-decreasing array.
	-109 <= target <= 109
 */