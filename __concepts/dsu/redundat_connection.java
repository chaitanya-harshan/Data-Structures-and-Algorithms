package __concepts.dsu;

import java.util.Arrays;

public class redundat_connection {
    
    // You're not certain that order of edges given is correct so u can use DFS
    // we need to use DSU - Disjoint Set Union
    // https://www.youtube.com/watch?v=FXWRE67PLL0 - Neetcode 

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parents = new int[n+1];
        for (int i=0; i<=n; i++) parents[i] = i;
        int[] rank = new int[n+1];
        Arrays.fill(rank, 1);

        for (int i=0; i<n; i++) {
            int n1 = edges[i][0], n2 = edges[i][1];
            if (!union(n1,n2, parents, rank)) {
                return new int[]{n1,n2};
            }
        }
        return new int[]{-1,-1}; // dummy return
    }

    public static int find(int node, int[] parents) {
        if (node != parents[node]) {
            parents[node] = find(parents[node], parents);
        }
        return parents[node];
    }

    public static boolean union(int n1, int n2, int[] parents, int[] rank) {
        int p1 = find(n1, parents), p2 = find(n2, parents);
        if (p1 == p2) return false; 
        // cycle --> false

        if (rank[p1] > rank[p2]) {
            parents[p2] = p1;
            rank[p1] += rank[p2];
        }
        else {
            parents[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}

/*
 * 684. Redundant Connection
https://leetcode.com/problems/redundant-connection/description/

In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

 

Example 1:


Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:


Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]
 

Constraints:

n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ai < bi <= edges.length
ai != bi
There are no repeated edges.
The given graph is connected.
 */