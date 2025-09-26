package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class _05_rotting_oranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int fresh = 0;
        // if (fresh == 0) return 0; // redundant but inc eff

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) q.offer(new int[]{i,j});
            }
        }

        int[] rc = {-1,0,1,0};
        int[] cc = {0,-1,0,1};

        while (!q.isEmpty()) {
            int len = q.size();
            for (int k=0; k<len; k++) {
                int row = q.peek()[0];
                int col = q.poll()[1];

                for (int i=0; i<4; i++) {
                    int r = row + rc[i];
                    int c = col + cc[i];
                    if (r < 0 || r >= n || c < 0 || c >= m) continue;

                    if (grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.offer(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            if (!q.isEmpty()) time++;
        }
        return (fresh == 0) ? time : -1;
    }
}

/*
 * URL: https://leetcode.com/problems/rotting-oranges/description/

994. Rotting Oranges

You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 
Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

 
Constraints:

	m == grid.length
	n == grid[i].length
	1 <= m, n <= 10
	grid[i][j] is 0, 1, or 2.
 */