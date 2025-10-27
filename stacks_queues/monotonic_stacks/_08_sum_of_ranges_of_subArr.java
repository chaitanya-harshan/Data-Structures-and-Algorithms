package stacks_queues.monotonic_stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class _08_sum_of_ranges_of_subArr {
    // *************************** IMPORTANT *******************
    // sum of Largest ele from All SubArr     -    sum of Smallest ele from All SubArr
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] NGE = find_NGE(nums);
        int[] NSE = find_NSE(nums);
        int[] PGEE = find_PGEE(nums);
        int[] PSEE = find_PSEE(nums);
        long sumOfMins = 0;
        long sumOfMaxs = 0;

        for (int i=0; i<n; i++) {
            int left = i - PSEE[i];
            int right = NSE[i] - i;
            int subArrCnt = left * right;
            sumOfMins += (long)subArrCnt * nums[i];
        }

        for (int i=0; i<n; i++) {
            int left = i - PGEE[i];
            int right = NGE[i] - i;
            int subArrCnt = left * right;
            sumOfMaxs += (long)subArrCnt * nums[i];
        }

        return sumOfMaxs - sumOfMins;
    }

    private int[] find_NGE(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] NGE = new int[n];

        for (int i=n-1; i>=0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            NGE[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return NGE;
    }
    private int[] find_NSE(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] NSE = new int[n];

        for (int i=n-1; i>=0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            NSE[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return NSE;
    }

    private int[] find_PGEE(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] PGEE = new int[n];

        for (int i=0; i<n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) st.pop();
            PGEE[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return PGEE;
    }
    private int[] find_PSEE(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] PSEE = new int[n];

        for (int i=0; i<n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            PSEE[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return PSEE;
    }
}

/*
 * URL: https://leetcode.com/problems/sum-of-subarray-ranges/description/

2104. Sum of Subarray Ranges

You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.
Return the sum of all subarray ranges of nums.
A subarray is a contiguous non-empty sequence of elements within an array.

 
Example 1:
Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:
Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:
Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.

 
Constraints:

	1 <= nums.length <= 1000
	-109 <= nums[i] <= 109
	Follow-up: Could you find a solution with O(n) time complexity?
 */