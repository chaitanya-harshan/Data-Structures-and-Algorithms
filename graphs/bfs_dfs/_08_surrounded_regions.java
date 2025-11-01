package graphs.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class _08_surrounded_regions {
    // we start from all the border connected 'O' and traverse the connected nodes to those and 
    // turn them into 'T'. Now we know the reaming 'O' are surrounded.
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int j=0; j<n; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) dfs(board, visited, 0,j);
            if (board[m-1][j] == 'O' && !visited[m-1][j]) dfs(board, visited, m-1,j);
        }
        for (int i=1; i<m-1; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) dfs(board, visited, i,0);
            if (board[i][n-1] == 'O' && !visited[i][n-1]) dfs(board, visited, i,n-1);
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    void dfs(char[][] board, boolean[][] visited, int i, int j) {
        int m = board.length, n = board[0].length;
        visited[i][j] = true;
        board[i][j] = 'T';

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for (int d=0; d<4; d++) {
            int r = i + dr[d];
            int c = j + dc[d];

            if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O' || visited[r][c]) continue;
            dfs(board, visited, r,c);
        }
    }

    void bfs(char[][] board, boolean[][] visited, int i, int j) {
        int m = board.length, n = board[0].length;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        // IMMEDIATELY mark the starting cell as visited and process it.
        visited[i][j] = true;
        board[i][j] = 'T';
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0], col = curr[1];

            for (int d=0; d<4; d++) {
                int r = row + dr[d];
                int c = col + dc[d];
                
                if (r < 0 || r >= m || c < 0 || c >= n) continue;
                if (board[r][c] != 'O' || visited[r][c]) continue;
                
                q.offer(new int[]{r, c});
                // you need to mark it visited so that the next neighbour in next for-loop
                // iteration doesnt add the same node.
                visited[r][c] = true;
                board[r][c] = 'T';
            }
        }
    }
}

/*
 * URL: https://leetcode.com/problems/surrounded-regions/description/

130. Surrounded Regions

You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells 
and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. 
You do not need to return anything.

 
Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation:
In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.
Example 2:
Input: board = [["X"]]
Output: [["X"]]

 
Constraints:

	m == board.length
	n == board[i].length
	1 <= m, n <= 200
	board[i][j] is 'X' or 'O'.
 */