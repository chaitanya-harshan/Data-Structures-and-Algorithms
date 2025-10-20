package graphs.shortest_path_algo;

import java.util.Arrays;

public class _11_Bellman_ford {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        
        // doing it n-1 times will result in the shortest - distances to all nodes
        // because for the worst case you need n-1 iterations to propagate form src to nth node
        // only nodes with wt's less than int_max can "true" the if-check of d[u] + wt < d[v]
        // and therefore propagate to the next nodes which in turn will propagate more
        for (int i=0; i<V-1; i++) {
            for (int[] e: edges) {
                int u = e[0];
                int v = e[1];
                int wt = e[2];
                
                if (dist[u] != 1e8) continue;
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        // nth relaxation to check for -ve weights
        // if there is a decrease that means there is -ve wt
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

/*
https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

 * Given an weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by a 2d array edges[][], where edges[i] = [u, v, w] represents a direct edge from node u to v having w edge weight. You are also given a source vertex src.

Your task is to compute the shortest distances from the source to all other vertices. If a vertex is unreachable from the source, its distance should be marked as 108. Additionally, if the graph contains a negative weight cycle, return [-1] to indicate that shortest paths cannot be reliably computed.

Examples:

Input: V = 5, edges[][] = [[1, 3, 2], [4, 3, -1], [2, 4, 1], [1, 2, 1], [0, 1, 5]], src = 0

Output: [0, 5, 6, 6, 7]
Explanation: Shortest Paths:
For 0 to 1 minimum distance will be 5. By following path 0 → 1
For 0 to 2 minimum distance will be 6. By following path 0 → 1  → 2
For 0 to 3 minimum distance will be 6. By following path 0 → 1  → 2 → 4 → 3 
For 0 to 4 minimum distance will be 7. By following path 0 → 1  → 2 → 4
Input: V = 4, edges[][] = [[0, 1, 4], [1, 2, -6], [2, 3, 5], [3, 1, -2]], src = 0

Output: [-1]
Explanation: The graph contains a negative weight cycle formed by the path 1 → 2 → 3 → 1, where the total weight of the cycle is negative.
Constraints:
1 ≤ V ≤ 100
1 ≤ E = edges.size() ≤ V*(V-1)
-1000 ≤ w ≤ 1000
0 ≤ src < V
 */