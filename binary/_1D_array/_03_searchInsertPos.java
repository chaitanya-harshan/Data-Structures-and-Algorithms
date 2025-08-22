package binary._1D_array;

public class _03_searchInsertPos {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        // int index = search(arr, 9);
        int index = searchInsert(arr, 9);
        System.out.println(index);

        System.out.println(searchInsertbad(new int[]{1,2}, 0));
    }

    // better way
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;
        // int index = n;
        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] >= target) {
                // index = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        // return index;
        return low;
    }

    public static int searchInsertbad(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid+1;
            else high = mid-1;
        }
        if (nums[mid] < target) return mid+1;
        else return mid;
    }
}

/*
 * URL: https://leetcode.com/problems/search-insert-position/description/

35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 
Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

 
Constraints:

	1 <= nums.length <= 104
	-104 <= nums[i] <= 104
	nums contains distinct values sorted in ascending order.
	-104 <= target <= 104
 */