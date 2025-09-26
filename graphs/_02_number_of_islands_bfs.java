package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class _02_number_of_islands_bfs {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int islands = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islands++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return islands;
    }

    void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        int[] rc = {-1,0,1,0};
        int[] cc = {0,1,0,-1};

        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{i,j});

        while (!q.isEmpty()) {
            int row = q.peek()[0];
            int col = q.poll()[1];

            for (int d=0; d<4; d++) {
                int r = row + rc[d];
                int c = col + cc[d];

                if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == '0') continue;
                if (!visited[r][c]) {
                    q.offer(new int[]{r,c});
                    visited[r][c] = true;
                }
            }
        }
    }
}

/*
 * URL: https://leetcode.com/problems/number-of-islands/description/

200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 
Example 1:
Input: grid = [
["1","1","1","1","0"],
["1","1","0","1","0"],
["1","1","0","0","0"],
["0","0","0","0","0"]
]
Output: 1
Example 2:
Input: grid = [
["1","1","0","0","0"],
["1","1","0","0","0"],
["0","0","1","0","0"],
["0","0","0","1","1"]
]
Output: 3

 
Constraints:

	m == grid.length
	n == grid[i].length
	1 <= m, n <= 300
	grid[i][j] is '0' or '1'.
 */