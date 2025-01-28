package __concepts.graphs;

public class max_number_of_fish_in_grid {
    
    public int findMaxFish(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int res = 0;

        for (int r=0; r<n; r++) {
            for (int c=0; c<m; c++) {
                if (grid[r][c] == 0) continue;
                int fish = dfs(r,c, grid, visited, n,m);
                res = Math.max(res, fish);
            }
        }
        return res;
    }

    public static int dfs(int r, int c, int[][] grid, boolean[][] visited, int n, int m) {
        if (r<0 || r>=n || c<0 || c>=m || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true;
        int fish = grid[r][c];
        int [][] neighbours = {{r-1,c}, {r+1,c}, {r,c-1}, {r,c+1}};
        for (int[] pair : neighbours) {
            fish += dfs(pair[0], pair[1], grid, visited, n,m);
        }
        return fish;
    } 
}

/*
 * 2658. Maximum Number of Fish in a Grid
https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/description/

You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:

A land cell if grid[r][c] = 0, or
A water cell containing grid[r][c] fish, if grid[r][c] > 0.
A fisher can start at any water cell (r, c) and can do the following operations any number of times:

Catch all the fish at cell (r, c), or
Move to any adjacent water cell.
Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.

An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.

 

Example 1:


Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
Output: 7
Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move to cell (2,3) and collect 4 fish.
Example 2:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]
Output: 1
Explanation: The fisher can start at cells (0,0) or (3,3) and collect a single fish. 
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
0 <= grid[i][j] <= 10
 */