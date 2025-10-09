package graphs.shortest_path_algo;

public class Floyd_warshall {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        for (int k = 0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (dist[i][k] == 1e8 || dist[k][j] == 1e8) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
