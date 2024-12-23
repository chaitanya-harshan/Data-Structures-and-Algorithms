package two_pointers.neetcode.sliding_window;

import java.util.Deque;
import java.util.LinkedList;

public class _05_sliding_window_max_monotonic_dq {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];

        // Deque stores indices, maintaining decreasing order of values
        Deque<Integer> q = new LinkedList<>();
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            // Remove indices that are outside current window
            while (!q.isEmpty() && q.peekFirst() <= r-k) q.removeFirst();

            // Remove all elements from back of deque that are smaller than current element
            // This maintains monotonic decreasing order - largest elements at front
            // We don't need smaller elements since they can never be the max
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) q.removeLast();

            // Add current index to back of deque
            // After removing smaller elements, this maintains decreasing order
            q.addLast(r);

            // When we have a full window, record the maximum (front of deque)
            if (r >= k-1) {
                res[l] = nums[q.peekFirst()];
                l++;
            }
        }
        return res;



        // Has time complexity of (log n) for add, poll so therefore it's 
        // ineffecient for larger data sets.

        // int n = nums.length;
        // int[] res = new int[n-k+1];

        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        // for (int i=0; i<k; i++) pq.offer(nums[i]);
        // res[0] = pq.peek();

        // int l = 0;
        // for (int r=k; r<n; r++) {
        //     pq.remove(nums[l]);
        //     l++;
        //     pq.offer(nums[r]);
        //     res[l] = pq.peek();
        // }
        // return res;
    }
}

/*
 * 239. Sliding Window Maximum
https://leetcode.com/problems/sliding-window-maximum/description/

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */