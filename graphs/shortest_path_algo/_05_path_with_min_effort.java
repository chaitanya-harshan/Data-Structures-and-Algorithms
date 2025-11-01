package graphs.shortest_path_algo;

import java.util.*;

public class _05_path_with_min_effort {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        int[][] effort = new int[m][n];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;
        
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.offer(new int[]{ 0, 0, effort[0][0] }); // {x,y, route effort}

        while (!pq.isEmpty()) {
            int x = pq.peek()[0];
            int y = pq.peek()[1];
            int eff = pq.poll()[2];

            for (int d=0; d<4; d++) {
                int r = x + dr[d];
                int c = y + dc[d];
                if (r < 0 || r >= m || c < 0 || c >= n) continue;

                int delta = Math.abs(heights[r][c] - heights[x][y]);
                int curMaxEff = Math.max(eff, delta);

                if (curMaxEff < effort[r][c]) {
                    effort[r][c] = curMaxEff;
                    pq.offer(new int[]{r,c, effort[r][c]});
                }
            }
        }
        return effort[m-1][n-1];
    }
}

/*
 * URL: https://leetcode.com/problems/path-with-minimum-effort/description/

1631. Path With Minimum Effort

You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, 
where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

 
Example 1:
Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
Example 2:
Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
Example 3:
Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.

 
Constraints:

	rows == heights.length
	columns == heights[i].length
	1 <= rows, columns <= 100
	1 <= heights[i][j] <= 106
 */