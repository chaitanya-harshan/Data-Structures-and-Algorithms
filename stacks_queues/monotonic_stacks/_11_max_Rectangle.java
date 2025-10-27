package stacks_queues.monotonic_stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class _11_max_Rectangle {
    // using the max Rectangle in Histogram & applying it for every row of the matrix
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] heights = new int[n][m];
        for (int j=0; j<m; j++) {
            int sum = 0;
            for (int i=0; i<n; i++) {
                if (matrix[i][j] == '1') sum++;
                else sum = 0;
                heights[i][j] = sum;
            }
        }

        int maxArea = 0;
        for (int[] row: heights) {
            maxArea = Math.max(maxArea, largestHistogram(row));
        }
        return maxArea;
    }

    private int largestHistogram(int[] heights) {
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
 * URL: https://leetcode.com/problems/maximal-rectangle/description/

85. Maximal Rectangle

Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 
Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:
Input: matrix = [["0"]]
Output: 0
Example 3:
Input: matrix = [["1"]]
Output: 1

 
Constraints:

	rows == matrix.length
	cols == matrix[i].length
	1 <= rows, cols <= 200
	matrix[i][j] is '0' or '1'.
 */