package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _khans_algo {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i=0; i<V; i++) adj[i] = new ArrayList<>();
        
        int[] indegree = new int[V];
        
        for (int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<V; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        ArrayList<Integer> topo = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            topo.add(cur);
            
            for (int nei: adj[cur]) {
                indegree[nei]--;
                if (indegree[nei] == 0) q.offer(nei);
            }
        }
        
        return topo;
    }
}
