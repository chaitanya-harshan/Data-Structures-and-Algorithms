package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class _is_graph_bipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int i=0; i<n; i++) {
            if (color[i] == 0 && !bfs(graph, color, i)) return false;
        }
        return true;
    }

    boolean bfs(int[][] graph, int[] color, int i) {
        color[i] = -1;

        Queue<Integer> q = new LinkedList();
        q.offer(i);

        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int nei: graph[cur]) {
                if (color[nei] == 0) {
                    color[nei] = -color[cur];
                    q.offer(nei);
                }
                else if (color[nei] == color[cur]) return false;
            }
        }
        return true;
    }

    //------------------------------------------------------------------------------------------------
    // we have to pass the color as the variable for the neighbour
    public boolean isBipartite1(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0: uncolored, 1 & -1: two different colors

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                // If the node is uncolored, start DFS from it.
                // We start by coloring it with color 1.
                if (!dfs1(graph, color, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs1(int[][] graph, int[] color, int node, int c) {
        // Color the current node
        color[node] = c;

        // Traverse its neighbors
        for (int neighbor : graph[node]) {
            if (color[neighbor] == 0) {
                // If neighbor is uncolored, recursively call DFS with the opposite color
                if (!dfs1(graph, color, neighbor, -c)) {
                    return false;
                }
            } else if (color[neighbor] == color[node]) {
                // If neighbor has the same color, we have a conflict
                return false;
            }
        }
        
        // If no conflicts were found in this path, return true
        return true;
    }
}

/*
 * URL: https://leetcode.com/problems/is-graph-bipartite/description/

785. Is Graph Bipartite?

There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
Return true if and only if it is bipartite.

 
Example 1:
Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
Example 2:
Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.

 
Constraints:

	graph.length == n
	1 <= n <= 100
	0 <= graph[u].length < n
	0 <= graph[u][i] <= n - 1
	graph[u] does not contain u.
	All the values of graph[u] are unique.
	If graph[u] contains v, then graph[v] contains u.
 */