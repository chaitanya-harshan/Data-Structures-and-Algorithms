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

/*
 * 2493. Divide Nodes Into the Maximum Number of Groups
https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/description/
https://youtu.be/Gn0ADjje8Rg

You are given a positive integer n representing the number of nodes in an undirected graph. The nodes are labeled from 1 to n.

You are also given a 2D integer array edges, where edges[i] = [ai, bi] indicates that there is a bidirectional edge between nodes ai and bi. Notice that the given graph may be disconnected.

Divide the nodes of the graph into m groups (1-indexed) such that:

Each node in the graph belongs to exactly one group.
For every pair of nodes in the graph that are connected by an edge [ai, bi], if ai belongs to the group with index x, and bi belongs to the group with index y, then |y - x| = 1.
Return the maximum number of groups (i.e., maximum m) into which you can divide the nodes. Return -1 if it is impossible to group the nodes with the given conditions.

 

Example 1:


Input: n = 6, edges = [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]
Output: 4
Explanation: As shown in the image we:
- Add node 5 to the first group.
- Add node 1 to the second group.
- Add nodes 2 and 4 to the third group.
- Add nodes 3 and 6 to the fourth group.
We can see that every edge is satisfied.
It can be shown that that if we create a fifth group and move any node from the third or fourth group to it, at least on of the edges will not be satisfied.
Example 2:

Input: n = 3, edges = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: If we add node 1 to the first group, node 2 to the second group, and node 3 to the third group to satisfy the first two edges, we can see that the third edge will not be satisfied.
It can be shown that no grouping is possible.
 

Constraints:

1 <= n <= 500
1 <= edges.length <= 104
edges[i].length == 2
1 <= ai, bi <= n
ai != bi
There is at most one edge between any pair of vertices.
 */