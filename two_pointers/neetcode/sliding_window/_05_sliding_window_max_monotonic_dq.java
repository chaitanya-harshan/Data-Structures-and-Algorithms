package two_pointers.neetcode.sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;

public class _05_sliding_window_max_monotonic_dq {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[n-k+1];
        int l = 0;

        for (int r=0; r<n; r++) {
            if (!q.isEmpty() && q.peekLast() <= r-k) q.pollLast();
            while (!q.isEmpty() && nums[q.peek()] < nums[r]) {
                q.pop();
            }
            q.push(r);

            if (r >= k-1) {
                res[l++] = nums[q.peekLast()];
            }
        }
        return res;
    }



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