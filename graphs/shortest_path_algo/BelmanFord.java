package graphs.shortest_path_algo;

public class BelmanFord {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        
        for (int i=0; i<V-1; i++) {
            for (int[] e: edges) {
                int u = e[0];
                int v = e[1];
                int wt = e[2];
                
                if (dist[u] != 1e8 && dist[u]+wt < dist[v]) {
                    dist[v] = dist[u]+wt;
                }
            }
        }
        
        // nth relaxation
        for (int[] e: edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
                
            if (dist[u] != 1e8 && dist[u]+wt < dist[v]) {
                return new int[]{-1};
            }
        }
        return dist;
    }
}
