package stacks_queues.monotonic_stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class _06_sum_of_mins_of_subArr {
    int MOD = (int)1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        int[] nse = find_NSE(arr);
        int[] psee = find_PSEE(arr);
        int sumOfMins = 0;

        for (int i=0; i<arr.length; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;

            long subArrays_cnt = (long)left * right;
            int curSum = (int)( (subArrays_cnt * arr[i]) % MOD );
            sumOfMins = (sumOfMins + curSum) % MOD;
        }
        return sumOfMins;
    }

    public int[] find_NSE(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] nse = new int[n];

        for (int i=n-1; i>=0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])   st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
    // prev smaller or equal element
    public int[] find_PSEE(int[] arr) {
        int n = arr.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] psee = new int[n];

        for (int i=0; i<n; i++) {
            // only '>' not '>=' so that we can get the same element index left of it
            while (!st.isEmpty() && arr[st.peek()] > arr[i])   st.pop();
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }
}

/*
 * URL: https://leetcode.com/problems/sum-of-subarray-minimums/description/

907. Sum of Subarray Minimums

Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 
Example 1:
Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:
Input: arr = [11,81,94,43,3]
Output: 444

 
Constraints:

	1 <= arr.length <= 3 * 104
	1 <= arr[i] <= 3 * 104
 */