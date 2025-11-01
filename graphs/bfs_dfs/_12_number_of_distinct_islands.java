package graphs.bfs_dfs;

import java.util.*;

public class _12_number_of_distinct_islands {
    public static int distinctIsland(int [][] arr, int n, int m) {
		boolean[][] visited = new boolean[n][m];
		HashSet<List<String>> islands = new HashSet<>();
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					List<String> path = new ArrayList<>();
                    dfs(arr, visited, path, i,j, i,j);
                    islands.add(path);
				}
			}
		}
        return islands.size();
	}

	static void dfs(int[][] arr, boolean[][] visited, List<String> path, int i, int j, int x, int y) {
        int n = arr.length, m = arr[0].length;
		visited[i][j] = true;
		path.add(Integer.toString(i-x) + " " + Integer.toString(j-y));

		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, -1, 0, 1};
		
        for (int d=0; d<4; d++) {
            int r = i+dr[d];
            int c = j+dc[d];

            if (r < 0 || r >= n || c < 0 || c >= m || arr[r][c] == 0 || visited[r][c]) {
                continue;
            }
            dfs(arr, visited, path, r,c, x,y);
        }
	}
}

/*
https://www.naukri.com/code360/problems/distinct-islands_630460

 * You are given a two-dimensional array/list of integers consisting of 0s and 1s. 
 * In the list, 1 represents land and 0 represents water.

The task is to find the number of distinct islands where a group of connected 1s
(horizontally or vertically) forms an island.

Note:
Two islands are considered to be the same if and only if one island is equal to another(not rotated or reflected) i.e if we can translate one island on another without rotating or reflecting then it would be considered as the same islands. 
For example:
1 1 0
0 0 1
0 0 1

In this example, we have two islands and they would be considered as distinct islands as we can not translate them on one another even if they have the same no of 1's.
For example :
1 1 0 0 0 
1 1 0 0 0
0 0 0 1 1
0 0 0 1 1

In this example, we have two islands and they are the same as we can translate one island onto another island, so our answer should be 1.
Detailed explanation ( Input/output format, Notes, Images )
Constraints
 0 <= N <= 1000
 0 <= M <= 1000
 0 <= elements of array <= 1
 */
