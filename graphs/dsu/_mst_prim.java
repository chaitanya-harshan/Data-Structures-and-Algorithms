package graphs.dsu;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _mst_prim {
    public int spanningTree(int V, int[][] edges) {
        // Create adjacency list
        ArrayList<int[]>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        
        // Build adjacency list from edges array
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            
            adj[u].add(new int[]{v, weight});
            adj[v].add(new int[]{u, weight});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0,0}); // node, weight
        boolean[] visited = new boolean[V];
        int mstWeight = 0;

        while (!pq.isEmpty()) {
            int cur = pq.peek()[0];
            int wt = pq.poll()[1];

            if (visited[cur]) continue;
            visited[cur] = true;
            mstWeight += wt;

            for (int[] nei: adj[cur]) {
                if (!visited[nei[0]]) {
                    pq.offer(new int[]{nei[0], nei[1]});
                }
            }
        }
        return mstWeight;
    }
}
