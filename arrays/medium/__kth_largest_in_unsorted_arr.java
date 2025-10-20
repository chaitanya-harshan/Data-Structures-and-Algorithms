package arrays.medium;

import java.util.PriorityQueue;

public class __kth_largest_in_unsorted_arr {
    // u can do it with min Heaps as well
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i: nums) {
            pq.offer(i);

            while (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }


    // using Quick Select
    //--------------------------------------------------------------------
    public int findKthLargest1(int[] nums, int k) {
        k = nums.length - k;

        return quickSelect(0, nums.length-1, nums, k);
    }

    int quickSelect(int l, int r, int[] nums, int k) {
        int pivot = nums[r];
        int pi = l; //partition_idx

        for (int i=l; i<=r; i++) {
            if (nums[i] <= pivot) {
                int temp = nums[pi];
                nums[pi] = nums[i];
                nums[i] = temp;
                pi++;
            }
        }
        pi--;

        if (k == pi) return nums[pi];
        else if (pi < k) return quickSelect(pi+1, r, nums, k);
        else return quickSelect(l, pi-1, nums, k);
    }
}

/*
 * URL: https://leetcode.com/problems/kth-largest-element-in-an-array/description/

215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?

 
Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

 
Constraints:

	1 <= k <= nums.length <= 105
	-104 <= nums[i] <= 104
 */