package arrays.sde.Arrays_2;

import java.util.Arrays;

public class _03_merge_sorted_arrays {
    
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, nums1.length-nums2.length, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1;
        while (m > 0 || n > 0) {
            if (m > 0 && n > 0 && nums1[m-1] >= nums2[n-1]) {
                nums1[k] = nums1[m-1];
                m--;
            }
            else if (m > 0 && n > 0 && nums2[n-1] > nums1[m-1]) {
                nums1[k] = nums2[n-1];
                n--;
            }
            else if (m > 0) {
                nums1[k] = nums1[m-1];
                m--;
            }
            else if (n > 0) {
                nums1[k] = nums2[n-1];
                n--;
            }

            k--;
        }

        // int[] ans = new int[m+n];
        // int i = 0, j = 0;
        // int k = 0;
        // while (i < m || j < n ) {
        //     if (i<m && j<n && nums1[i] <= nums2[j]) {
        //         ans[k] = nums1[i];
        //         i++;
        //     }
        //     else if (i<m && j<n && nums2[j] < nums1[i]) {
        //         ans[k] = nums2[j];
        //         j++;
        //     }
        //     else if (i < m) {
        //         ans[k] = nums1[i];
        //         i++;
        //     }
        //     else if (j < n) {
        //         ans[k] = nums2[j];
        //         j++;
        //     }
        //     k++;
        // }
        // for (i=0; i<m+n; i++) {
        //     nums1[i] = ans[i];
        // }
    }
}

// https://leetcode.com/problems/merge-sorted-array/
// https://www.youtube.com/watch?v=P1Ic85RarKY

// starting from index back to 0 and checking for max beteween nums1[i] & nums2[j] 
// this way you won't have problem with changing the values in nums1 as if k is below m then it means those values are alrady used.
// unlike when u start from 0 index then you'll have this issue of vlaues getting corrupted before they are used.

/*
 * 88. Merge Sorted Array
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, 
representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside 
the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
 */