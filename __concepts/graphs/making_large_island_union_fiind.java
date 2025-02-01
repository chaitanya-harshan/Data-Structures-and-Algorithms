package __concepts.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class making_large_island_union_fiind {
    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] group = new int[n][n];
        Map<Integer, Integer> sizeMap = new HashMap<>();
        int grpID = 1;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0 || group[i][j] != 0) continue;
                sizeMap.put(grpID, bfs(i,j,grid,group, grpID++, n));
            }
        }

        int originalMax = 0;
        for (int size : sizeMap.values()) originalMax = Math.max(originalMax, size);
        if (originalMax == n*n) {
            return n*n;
        }

        int maxArea = 0;
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                if (grid[r][c] == 1) continue;

                int[] neiX = {r, r, r-1, r+1};
                int[] neiY = {c-1, c+1, c, c};
                HashSet<Integer> adj_cell_grp = new HashSet<>();
                int area = 1;

                for (int i=0; i<4; i++) {
                    int X = neiX[i], Y = neiY[i];
                    if (X<0 || X>=n || Y<0 || Y>=n || grid[X][Y] == 0) continue;
                    if (adj_cell_grp.contains(group[X][Y])) continue;

                    area += sizeMap.get(group[X][Y]);
                    adj_cell_grp.add(group[X][Y]);
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        // return originalMax == n*n ? originalMax : maxArea;
        return maxArea;
    }

    private static int bfs(int r, int c, int[][] grid, int[][] group, int grpID, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        group[r][c] = grpID;
        int size = 1;

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.poll()[1];

            int[] newX = {x, x, x-1, x+1};
            int[] newY = {y-1, y+1, y, y};

            for (int i=0; i<4; i++) {
                int X = newX[i], Y = newY[i];
                if (X<0 || X>=n || Y<0 || Y>=n || grid[X][Y] == 0 || group[X][Y] != 0) {
                    continue;
                }

                q.offer(new int[]{X,Y});
                group[X][Y] = grpID;
                size++;
            }
        }
        return size;
    }
}

/*
 * 827. Making A Large Island
https://leetcode.com/problems/making-a-large-island/
Watching Neetcode and striver didn't completely help me understand so i use R1 to solve this. but maybe thats becasue i was a noob in graph while doing this

You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

 

Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 500
grid[i][j] is either 0 or 1.
 */