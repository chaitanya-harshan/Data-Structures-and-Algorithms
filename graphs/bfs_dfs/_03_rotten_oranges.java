package graphs.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class _03_rotten_oranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int oranges = 0;
        // Adding rotten oranges to the Queue for starting points of infection
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) oranges++;
                else if (grid[i][j] == 2) q.offer(new int[]{i,j});
            }
        }

        int m = grid.length, n = grid[0].length;
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, -1, 0, 1};

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int k=0; k<size; k++) {
                int row = q.peek()[0];
                int col = q.poll()[1];

                for (int i=0; i<4; i++) {
                    int R = row + di[i];
                    int C = col + dj[i];
                    if (R < 0 || R >= m || C < 0 || C >= n) continue;

                    if (grid[R][C] == 1) {
                        grid[R][C] = 2;
                        q.offer(new int[]{R,C});
                        oranges--;
                    }
                }
            }
            if (!q.isEmpty()) time++; // only if we found somthing to infect
        }
        return (oranges == 0) ? time : -1;
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