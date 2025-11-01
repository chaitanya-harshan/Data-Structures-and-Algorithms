package graphs.bfs_dfs;

public class _09_number_of_enclaves {
    // we start from all the border connected landCells and traverse the connected nodes to those and 
    // turn them into 2. Now we know the reaming 1's are all surrounded landCells.
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int j=0; j<n; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) dfs(grid, visited, 0,j);
            if (grid[m-1][j] == 1 && !visited[m-1][j]) dfs(grid, visited, m-1,j);
        }
        for (int i=1; i<m-1; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) dfs(grid, visited, i,0);
            if (grid[i][n-1] == 1 && !visited[i][n-1]) dfs(grid, visited, i,n-1);
        }

        int landCells = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) landCells++;
            }
        }
        return landCells;
    }

    void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length, n = grid[0].length;
        visited[i][j] = true;
        grid[i][j] = 2;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for (int d=0; d<4; d++) {
            int r = i + dr[d];
            int c = j + dc[d];

            if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0 || visited[r][c]) continue;
            dfs(grid, visited, r,c);
        }
    }
}

/*
 * URL: https://leetcode.com/problems/number-of-enclaves/description/

1020. Number of Enclaves

You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.


Example 1:
Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
Example 2:
Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.

 
Constraints:

	m == grid.length
	n == grid[i].length
	1 <= m, n <= 500
	grid[i][j] is either 0 or 1.
 */