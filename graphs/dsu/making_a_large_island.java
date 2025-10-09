package graphs.dsu;

import java.util.HashSet;

public class making_a_large_island {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU uf = new DSU(n*n);
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) continue;
                for (int d=0; d<4; d++) {
                    int r = i + dr[d], c = j + dc[d];

                    if (isValid(r,c,n) && grid[r][c] == 1) uf.union(i*n+j, r*n+c);
                }
            }
        }

        int maxSize = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) continue;
                HashSet<Integer> set = new HashSet<>();

                for (int d=0; d<4; d++) {
                    int r = i + dr[d], c = j + dc[d];
                    if (isValid(r,c,n) && grid[r][c] == 1) {
                        set.add(uf.find(r*n+c));
                    }
                }

                int size = 1;
                for (int nei: set) size += uf.size[nei];
                maxSize = Math.max(maxSize, size);
            }
        }
        maxSize = Math.max(maxSize, uf.size[0]); // incase all are 1's
        return maxSize;
    }

    private boolean isValid(int i, int j, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n) return false;
        return true;
    } 

}

class DSU {
    int[] parent;
    int[] size;
    int sets;

    public DSU(int n) {
        this.sets = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);

        if (pi == pj) return;

        if (size[pi] < size[pj]) {
            parent[pi] = pj;
            size[pj] += size[pi];
        } else {
            parent[pj] = pi;
            size[pi] += size[pj];
        }

        sets--;
    }
}

/*
 * URL: https://leetcode.com/problems/making-a-large-island/description/

827. Making A Large Island

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