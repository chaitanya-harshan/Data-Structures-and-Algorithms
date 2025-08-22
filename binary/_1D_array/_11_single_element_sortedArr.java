package binary._1D_array;

public class _11_single_element_sortedArr {
    
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        // edge cases necessary
        if (nums[0] != nums[1]) return nums[0]; // so we don't go -1
        if (nums[n-2] != nums[n-1]) return nums[n-1]; // so we can keep h = n-2 and reduce 
        // complexity but then we have to check for the last number

        int l = 1, h = n-2;
        while (l <= h) {
            int m = (l+h)/2;
            if (nums[m] != nums[m-1] && nums[m] != nums[m+1]) {
                return nums[m];
            }
            else if ((m%2 == 0 && nums[m] == nums[m+1]) ||
            (m % 2 == 1 && nums[m-1] == nums[m])) {
                l = m + 1;
            }
            else h = m - 1;
        }
        return -1;
    }
}

/*
 * URL: https://leetcode.com/problems/single-element-in-a-sorted-array/description/

540. Single Element in a Sorted Array

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
Return the single element that appears only once.
Your solution must run in O(log n) time and O(1) space.

 
Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10

 
Constraints:

	1 <= nums.length <= 105
	0 <= nums[i] <= 105
 */