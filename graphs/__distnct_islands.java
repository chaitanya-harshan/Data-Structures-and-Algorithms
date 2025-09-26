package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class __distnct_islands {
    public int distinctIsland(int [][] arr, int n, int m) {
		boolean[][] visited = new boolean[n][m];
        HashSet<List<String>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    List<String> path = new ArrayList<>();
                    dfs(arr, visited, path, i, j, i,j, n, m);
                    set.add(path);
                }
            }
        }
        return set.size();
	}

    void dfs(int[][] arr, boolean[][] visited, List<String> path, int i, int j, int x, int y, int n, int m) {
        visited[i][j] = true;
        path.add(Integer.toString(i-x) +" "+ Integer.toString(j-y));
        
        int[] rc = {-1,0,1,0};
        int[] cc = {0,1,0,-1};
        
        for (int d=0; d<4; d++) {
            int r = i + rc[d];
            int c = j + cc[d];

            if (r < 0 || r >= n || c < 0 || c >= m || visited[r][c] || arr[r][c] == 0) continue;
            dfs(arr, visited, path, r,c,x,y,n,m);
        }
    }
}

/*
https://www.naukri.com/code360/problems/distinct-islands_630460

 * You are given a two-dimensional array/list of integers consisting of 0s and 1s. In the list, 1 represents land and 0 represents water.

The task is to find the number of distinct islands where a group of connected 1s(horizontally or vertically) forms an island.

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

Time Limit: 1 sec
Sample Input 1:
 4
 5
 1 1 0 1 1
 1 0 0 0 0
 0 0 0 0 1
 1 1 0 1 1
Sample Output 1:
 3
Explanation For Sample Input 1:
Distinct islands in the example above are: 

1st -> at the top left corner; 

2nd -> at the top right corner  

3rd -> at the bottom right corner. 

We ignore the island at the bottom left corner since it is identical to the top right corner.
Sample Input 2:
3
2
1 0
0 1
1 1
Sample Output 2:
2
 */