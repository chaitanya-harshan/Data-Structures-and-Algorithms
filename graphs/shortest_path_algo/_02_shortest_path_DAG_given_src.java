package graphs.shortest_path_algo;

import java.util.*;

public class _02_shortest_path_DAG_given_src {
    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
        List<Pair>[] adj = new ArrayList[n];
        for (int i=0; i<n; i++) adj[i] = new ArrayList<>();
        for (int[] e: edges) adj[e[0]].add(new Pair(e[1], e[2]));
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            int d = dist[cur];
            
            for (Pair nei: adj[cur]) {
                int v = nei.v, wt = nei.wt;
                if (d + wt < dist[v]) {
                    dist[v] = d + wt;
                    q.offer(v);
                }
            }
        }
        for (int i=0; i<n; i++) if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        return dist;
    }
}

class Pair {
    int v;
    int wt;
    Pair (int v, int wt) {this.v = v; this.wt = wt;}
}

/*
https://www.naukri.com/code360/problems/shortest-path-in-dag_8381897

 * You are given a directed acyclic graph of 'N' vertices(0 to 'N' - 1) and 'M' weighted edges.
Return an array that stores the distance of the shortest path from ``src_node(0)`` 
to all vertices, and if it is impossible to reach any vertex, then assign -1 as distance.

For Example:
'N' = 3, 'M' = 3, 'edges' = [0, 1, 2], [1, 2, 3], [0, 2, 6]].

Distance (0 to 0) = 0.
Distance (0 to 1) = 2.
Distance (0 to 2) = 0->1 + 1->2 = 2+3 = 5.
So our answer is [0, 2, 5].
 */
