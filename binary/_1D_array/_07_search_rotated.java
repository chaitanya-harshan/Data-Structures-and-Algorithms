package binary._1D_array;

/**
 * _07_search_rotated
 */
public class _07_search_rotated {

    public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = l+h >> 1;
            if (nums[m] == target) return m;
            
            if (nums[m] >= nums[l]) {
                if (target >= nums[l] && target <= nums[m]) h = m-1;
                else l = m+1;
            }
            else {
                if ( target >= nums[m] && target <= nums[h]) l = m+1;
                else h = m-1;
            }
        }
        return -1;
    }
}

/*
 * URL: https://leetcode.com/problems/search-in-rotated-sorted-array/description/

33. Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

 
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:
Input: nums = [1], target = 0
Output: -1

 
Constraints:

	1 <= nums.length <= 5000
	-104 <= nums[i] <= 104
	All values of nums are unique.
	nums is an ascending array that is possibly rotated.
	-104 <= target <= 104
 */