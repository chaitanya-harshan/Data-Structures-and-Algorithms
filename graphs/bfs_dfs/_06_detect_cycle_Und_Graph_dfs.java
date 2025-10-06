package graphs.bfs_dfs;

import java.util.ArrayList;
import java.util.List;

public class _06_detect_cycle_Und_Graph_dfs {
    public boolean isCycle(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];
        for (int i=0; i<V; i++) adj[i] = new ArrayList<>();
        for (int[] e: edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        boolean[] visited = new boolean[V];
        
        for (int i=0; i<V; i++) {
            if (!visited[i] && dfs(i, adj, visited, -1)) return true;
        }
        return false;
    }
    
    boolean dfs(int i, List<Integer>[] adj, boolean[] visited, int parent) {
        visited[i] = true;
        
        for (int nei: adj[i]) {
            if (nei == parent) continue;
            if (visited[nei]) return true;
            if (dfs(nei, adj, visited, i)) return true;
        }
        return false;
    }
}

/*
 * Undirected Graph Cycle
https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][], 
where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether 
the graph contains a cycle or not. The graph can have multiple component.
 */