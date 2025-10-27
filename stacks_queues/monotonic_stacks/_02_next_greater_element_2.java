package stacks_queues.monotonic_stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class _02_next_greater_element_2 {
    // double the array (logically) and put the array in the stack in monotonic order before
    // starting at i = n-1  to 0.
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        
        for (int i = 2*n -1; i >= 0; i--) {
            int num = nums[i % n];
            while (!st.isEmpty() && st.peek() <= num) st.pop();

            if (i < n) {
                nge[i % n] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(num);
        }
        return nge;
    }
}

/*
 * URL: https://leetcode.com/problems/next-greater-element-ii/description/

503. Next Greater Element II

Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

 
Example 1:
Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:
Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]

 
Constraints:

	1 <= nums.length <= 104
	-109 <= nums[i] <= 109
 */