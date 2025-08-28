package binary._1D_array;

public class _08_search_rotated_duplicates {
    
    public boolean search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = l+h >> 1;
            if (nums[m] == target) return true;
            
            // if only l == m && m != h, we can know that the target if it exists, must be in the right half
            // but we already have a check for that => if [target < l] 
            if (nums[l] == nums[m] && nums[m] == nums[h]) {
                l++;
                h--;
                // If you are wondering why not just remove the whole side of the array 
                // between low and mid, then let me remind you that you haven't yet known
                // if you are in the part of the array where the [mid > low] or in [mid < low].
            }
            else if (nums[m] >= nums[l]) {
                if (target >= nums[l] && target <= nums[m]) h = m-1;
                else l = m+1;
            }
            else {
                if (target >= nums[m] && target <= nums[h]) l = m+1;
                else h = m-1;
            }
        }
        return false;
    }
}
// just watch the neetcode video for this one

/*
 * URL: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

81. Search in Rotated Sorted Array II

There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
You must decrease the overall operation steps as much as possible.

 
Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false

 
Constraints:

	1 <= nums.length <= 5000
	-104 <= nums[i] <= 104
	nums is guaranteed to be rotated at some pivot.
	-104 <= target <= 104
	Follow up: This problem is similar to Search in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?
 */