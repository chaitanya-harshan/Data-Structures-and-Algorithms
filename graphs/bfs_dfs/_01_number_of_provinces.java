package graphs.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class _01_number_of_provinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU uf = new DSU(n);

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (isConnected[i][j] == 1) uf.union(i,j);
            }
        }
        return uf.sets;
    }

    class DSU {
        int[] parent;
        int[] size;
        int sets;

        DSU(int n) {
            sets = n;
            parent = new int[n];
            size = new int[n];
            for (int i=0; i<n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int i) {
            if (parent[i] == i) return i;
            else return parent[i] = find(parent[i]);
        }

        boolean union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi == pj) return false;

            if (size[pi] < size[pj]) {
                parent[pi] = pj;
                size[pj] += size[pi];
            }
            else {
                parent[pj] = pi;
                size[pi] += size[pj];
            }

            sets--;
            return true;
        }
    }
}

// DFS / BFS ===========================================================================================
class Solution1 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(i, isConnected, visited);
                // bfs(i, isConnected, visited);
            }
        }
        return provinces;
    }

    void dfs(int node, int[][] isConnected, boolean[] visited) {
        visited[node] = true;

        for (int i=0; i<isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) dfs(i, isConnected, visited);
        }
    }

    // -------------------------------------------------------------------------------------
    void bfs(int node, int[][] isConnected, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            int i = q.poll();
            visited[i] = true;

            for (int j=0; j<isConnected.length; j++) {
                if (isConnected[i][j] == 1 && !visited[j]) q.offer(j);
            }
        }
    }
}

/*
 * URL: https://leetcode.com/problems/number-of-provinces/description/

547. Number of Provinces

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.

 
Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3

 
Constraints:

	1 <= n <= 200
	n == isConnected.length
	n == isConnected[i].length
	isConnected[i][j] is 1 or 0.
	isConnected[i][i] == 1
	isConnected[i][j] == isConnected[j][i]
 */