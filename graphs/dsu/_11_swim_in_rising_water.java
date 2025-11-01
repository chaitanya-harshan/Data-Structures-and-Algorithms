package graphs.dsu;

import java.util.PriorityQueue;

public class _11_swim_in_rising_water {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.offer(new int[]{ 0, 0, grid[0][0] });

        // pq always make sure the smallerMax path is taken out first so any other path is more than the 
        // current and therefore we never touch them by checking its not visited.
        // visited also helps to not loop
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            int curMax = cur[2];

            if (i == n-1 && j == n-1) return curMax;
            visited[i][j] = true;

            for (int d=0; d<4; d++) {
                int r = i + dr[d];
                int c = j + dc[d];
                if (r < 0 || r >= n || c < 0 || c >= n || visited[r][c]) continue;

                // visited[r][c] = true; // this works too and actually this is better for this problem
                int maxElevation = Math.max(curMax, grid[r][c]);
                pq.offer(new int[]{r,c, maxElevation});
            }
        }
        return -1;
    }
}

/*
 * URL: https://leetcode.com/problems/swim-in-rising-water/description/

778. Swim in Rising Water

You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
It starts raining, and water gradually rises over time. At time t, the water level is t, meaning any cell with elevation less than equal to t is submerged or reachable.
You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
Return the minimum time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

 
Example 1:
Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:
Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation: The final route is shown.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.

 
Constraints:

	n == grid.length
	n == grid[i].length
	1 <= n <= 50
	0 <= grid[i][j] < n2
	Each value grid[i][j] is unique.
 */