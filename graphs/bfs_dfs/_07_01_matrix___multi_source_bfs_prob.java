package graphs.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class _07_01_matrix___multi_source_bfs_prob {
    // instead of find distance from any random nodes, we reverse the question and 
    // start from target element and go away from it in steps and the no.of steps to reach 
    // will the cur node will be the distance b/w cur and target
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};

        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            distance++;

            for (int k=0; k<size; k++) {
                int row = q.peek()[0];
                int col = q.poll()[1];

                for (int i=0; i<4; i++) {
                    int r = row + dr[i];
                    int c = col + dc[i];
                    if (r < 0 || r >=m || c < 0 || c >= n) continue;

                    if (!visited[r][c]) {
                        mat[r][c] = distance;
                        visited[r][c] = true;
                        q.offer(new int[]{r, c});
                    }
                }
            }
        }
        return mat;
    }
}

/*
 * URL: https://leetcode.com/problems/01-matrix/description/

542. 01 Matrix

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two cells sharing a common edge is 1.

 
Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]

 
Constraints:

	m == mat.length
	n == mat[i].length
	1 <= m, n <= 104
	1 <= m * n <= 104
	mat[i][j] is either 0 or 1.
	There is at least one 0 in mat.
	Note: This question is the same as 1765: https://leetcode.com/problems/map-of-highest-peak/
 */