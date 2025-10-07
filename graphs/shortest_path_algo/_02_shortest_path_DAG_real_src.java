package graphs.shortest_path_algo;

import java.util.*;

public class _02_shortest_path_DAG_real_src {
    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
        List<Pair>[] adj = new ArrayList[n];
        for (int i=0; i<n; i++) adj[i] = new ArrayList<>();
        for (int[] e: edges) adj[e[0]].add(new Pair(e[1], e[2]));
        
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<n; i++) {
            if (!visited[i]) topo_dfs(i, adj, visited, st);
        }

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[st.peek()] = 0;

        while (!st.empty()) {
            int cur = st.pop();
            int d = dis[cur];

            for (Pair nei: adj[cur]) {
                int v = nei.v, wt = nei.wt;
                if (d + wt < dis[v]) dis[v] = d + wt;
            }
        }
        for (int i=0; i<n; i++) if (dis[i] == Integer.MAX_VALUE) dis[i] = -1;
        return dis;
    }

    static void topo_dfs(int i, List<Pair>[] adj, boolean[] visited, Stack<Integer> st) {
        visited[i] = true;

        for (Pair nei: adj[i]) {
            int v = nei.v;
            if (!visited[v]) topo_dfs(v, adj, visited, st);
        }
        st.push(i);
    }
}

class Pair {
    int v;
    int wt;
    Pair (int v, int wt) {this.v = v; this.wt = wt;}
}

/*
 * You are given a directed acyclic graph of 'N' vertices(0 to 'N' - 1) and 'M' weighted edges.
Return an array that stores the distance of the shortest path from ``top node[inDegree = 0]`` 
to all vertices, and if it is impossible to reach any vertex, then assign -1 as distance.

For Example:
'N' = 3, 'M' = 3, 'edges' = [0, 1, 2], [1, 2, 3], [0, 2, 6]].

Distance (0 to 0) = 0.
Distance (0 to 1) = 2.
Distance (0 to 2) = 0->1 + 1->2 = 2+3 = 5.
So our answer is [0, 2, 5].
 */