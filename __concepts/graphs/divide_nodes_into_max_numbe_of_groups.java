package __concepts.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class divide_nodes_into_max_numbe_of_groups {
    public int magnificentSets(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i=0; i<=n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1];
            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        int res = 0;
        boolean[] used = new boolean[n+1];
        for (int i=1; i<=n; i++) {
            if (used[i]) continue;
            HashSet<Integer> connected_nodes = bfs_nodes(i, graph, used, n);

            int max_cnt = 0;
            for (int node : connected_nodes) {
                int cnt = bfs_groups_cnt(node, graph, n);
                if (cnt == -1) return -1;
                max_cnt = Math.max(max_cnt, cnt);
            }
            res += max_cnt;
        }
        return res;
    }

    private static int bfs_groups_cnt(int head, ArrayList<Integer>[] graph, int n) {
        int[] depth = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(head);
        depth[head] = 1;
        int maxDepth = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : graph[cur]) {
                if (depth[nei] != 0) {
                    if (depth[nei] == depth[cur]) return -1;
                    else continue;
                }
                depth[nei] = depth[cur] + 1;
                q.offer(nei);
            }
            maxDepth = Math.max(maxDepth, depth[cur]);
        }
        return maxDepth;
    }

    private static HashSet<Integer> bfs_nodes(int head, ArrayList<Integer>[] graph, boolean[] used, int n) {
        boolean[] visited = new boolean[n+1];
        visited[head] = true;
        used[head] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(head);
        HashSet<Integer> set = new HashSet<>();
        set.add(head);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : graph[cur]) {
                if (visited[nei] == true) continue; // we already know this is bipartite 
                visited[nei] = true;
                q.offer(nei);
                set.add(nei);
                used[nei] = true;
            }
        }
        return set;
    }
}
