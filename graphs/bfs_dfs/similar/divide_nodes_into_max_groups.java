package graphs.bfs_dfs.similar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class divide_nodes_into_max_groups {
    public int magnificentSets(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n+1];
        for (int i=1; i<=n; i++) adj[i] = new ArrayList<>();
        for (int[] e: edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int[] color = new int[n+1];
        int groups = 0;

        for (int i=1; i<=n; i++) {
            if (color[i] == 0) {
                List<Integer> nodes = new ArrayList<>();
                if (!isBipartiteAndNodes(i, adj, color, nodes)) return -1;

                int maxDepth = 0;
                for (int node: nodes) {
                    int depth = depth(node, adj);
                    maxDepth = Math.max(maxDepth, depth);
                }
                groups += maxDepth;
            }
        }
        return groups;
    }

    int depth(int i, List<Integer>[] adj) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        HashMap<Integer, Boolean> visited = new HashMap<>();
        visited.put(i, true);

        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int j=0; j<size; j++) {
                int node = q.poll();
                for (int nei: adj[node]) {
                    if (!visited.containsKey(nei)) {
                        visited.put(nei, true);
                        q.offer(nei);
                    }
                }
            }
            depth++;
        }
        return depth;
    }

    boolean isBipartiteAndNodes(int i, List<Integer>[] adj, int[] color, List<Integer> nodes) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        color[i] = -1;
        nodes.add(i);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int nei: adj[node]) {
                if (color[nei] == 0) {
                    color[nei] = -color[node];
                    q.offer(nei);
                    nodes.add(nei);
                }
                else if (color[nei] == color[node]) return false;
            }
        }
        return true;
    }
}

/*
 * URL: https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/description/

2493. Divide Nodes Into the Maximum Number of Groups

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