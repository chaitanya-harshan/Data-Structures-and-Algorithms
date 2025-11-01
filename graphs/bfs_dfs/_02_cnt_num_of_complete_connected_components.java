package graphs.bfs_dfs;

import java.util.ArrayList;
import java.util.List;

public class _02_cnt_num_of_complete_connected_components {
    // Lessons: 
    // 1) copy of primitive types is passed, not reference like for obts. So u can't just pass 
    //    int values to methods and hope the values will change.

    // 2) for N nodes there can be N(N-1)/2 unique pairs -> each has N-1 connections

    // 3) unique cnt of edges taken for connected component from adjacent list is 
    //    [total edge count]/2; because it will contains same edge twice from the 2 nodes (n1--n2).
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i=0; i<adj.length; i++) adj[i] = new ArrayList<>();
        for (int[] e: edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                int[] cnt = new int[2]; // [nodeCnt, edgeCnt]
                dfs(i, adj, visited, cnt);

                if (cnt[0]*(cnt[0]-1)/2 == cnt[1]/2) // nc*(nc-1)/2 == edgeCnt/2;
                    components++;
            }
        }
        return components;
    }

    void dfs(int node, List<Integer>[] adj, boolean[] visited, int[] cnt) {
        visited[node] = true;
        cnt[0]++; // nodeCnt
        cnt[1] += adj[node].size(); // edgeCnt

        for (int i: adj[node]) {
            if (!visited[i]) dfs(i, adj, visited, cnt);
        }
    }

    // another mthod is just let dfs return the connected component's nodeslist and you can iterate 
    // and make sure all the nodes have (n-1) edges only in adjacency list. 
}

/*
 * URL: https://leetcode.com/problems/count-the-number-of-complete-components/description/

2685. Count the Number of Complete Components

You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. 
You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an 
undirected edge connecting vertices ai and bi.
Return the number of complete connected components of the graph.
A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
A connected component is said to be complete if there exists an edge between every pair of its vertices.

 
Example 1:
Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
Output: 3
Explanation: From the picture above, one can see that all of the components of this graph are complete.
Example 2:
Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
Output: 1
Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.

 
Constraints:

	1 <= n <= 50
	0 <= edges.length <= n * (n - 1) / 2
	edges[i].length == 2
	0 <= ai, bi <= n - 1
	ai != bi
	There are no repeated edges.
 */