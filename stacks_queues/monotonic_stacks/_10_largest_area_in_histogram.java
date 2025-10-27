package stacks_queues.monotonic_stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class _10_largest_area_in_histogram {

    // easier less effecient method:
    // find NSE & PSE and for index 'i' maxAre = max(heights[i]*nse[i]-pse[i]-1)

    // 2nd method
    // in single pass without using both nse and pse
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        int maxArea = 0;

        for (int i=0; i<n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int cur = st.pop();
                int pse = st.isEmpty() ? -1 : st.peek();
                int width = i-pse-1;
                maxArea = Math.max(maxArea, heights[cur] * width);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int cur = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            int width = n-pse-1;
            maxArea = Math.max(maxArea, heights[cur] * width);
        }
        return maxArea;
    }
}
/*
 * URL: https://leetcode.com/problems/largest-rectangle-in-histogram/description/

84. Largest Rectangle in Histogram

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 
Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:
Input: heights = [2,4]
Output: 4

 
Constraints:

	1 <= heights.length <= 105
	0 <= heights[i] <= 104
 */