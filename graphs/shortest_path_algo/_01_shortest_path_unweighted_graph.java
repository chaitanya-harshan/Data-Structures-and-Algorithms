package graphs.shortest_path_algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _01_shortest_path_unweighted_graph {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            int d = dist[cur] + 1;
            
            for (int nei: adj.get(cur)) {
                if (d < dist[nei]) {
                    dist[nei] = d;
                    q.offer(nei);
                }
            }
        }
        for (int i=0; i<n; i++) if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        return dist;
    }
}

/*
https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

 * You are given an adjacency list, adj of Undirected Graph having unit weight of the edges, 
 * find the shortest path from src to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.
 */