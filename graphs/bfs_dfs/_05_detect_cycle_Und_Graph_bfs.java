package graphs.bfs_dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _05_detect_cycle_Und_Graph_bfs {
    public boolean isCycle(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];
        for (int i=0; i<V; i++) adj[i] = new ArrayList<>();
        for (int[] e: edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        boolean[] visited = new boolean[V];
        
        for (int i=0; i<V; i++) {
            if (!visited[i] && bfs(i, adj, visited)) return true;
        }
        return false;
    }
    
    boolean bfs(int i, List<Integer>[] adj, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, -1}); // node, parent
        
        while (!q.isEmpty()) {
            int node = q.peek()[0];
            int parent = q.poll()[1];
            visited[node] = true;
            
            for (int nei: adj[node]) {
                if (nei == parent) continue;
                if (visited[nei]) return true;
                q.offer(new int[]{nei, node});
            }
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