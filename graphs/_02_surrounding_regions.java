package graphs;

public class _02_surrounding_regions {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i=0; i<m; i++) {
            if (board[0][i] == 'O') dfs(board, visited, 0,i,n,m);
            if (board[n-1][i] == 'O') dfs(board, visited, n-1,i,n,m);
        }
        for (int i=1; i<n-1; i++) {
            if (board[i][0] == 'O') dfs(board, visited, i,0,n,m);
            if (board[i][m-1] == 'O') dfs(board, visited, i,m-1,n,m);
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    void dfs(char[][] board, boolean[][] visited, int i, int j, int n, int m) {
        visited[i][j] = true;
        board[i][j] = 'T';

        int[] rc = {-1,0,1,0};
        int[] cc = {0,1,0,-1};

        for (int d=0; d<4; d++) {
            int r = i + rc[d];
            int c = j + cc[d];

            if (r < 0 || r >= n || c < 0 || c >= m || board[r][c] == 'X' || visited[r][c]) continue;
            dfs(board, visited, r,c,n,m);
        }
    }
}

/*
 * URL: https://leetcode.com/problems/surrounded-regions/description/

130. Surrounded Regions

You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

 
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