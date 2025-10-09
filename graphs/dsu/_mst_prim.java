package graphs.dsu;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _mst_prim {
    public int spanningTree(int V, int[][] edges) {
        ArrayList<int[]>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        for (int[] e: edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], e[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0,0}); // node, weight
        boolean[] visited = new boolean[V];
        int mstWeight = 0;

        while (!pq.isEmpty()) {
            int cur = pq.peek()[0];
            int wt = pq.poll()[1];

            if (visited[cur]) continue; // this check is for when a edge is added but also added a less wt edges after so this first edge will stay and the less wt edge path consume other nodes and when we come back to the first edge it's probably already consumed so we always check for if its visited.
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
