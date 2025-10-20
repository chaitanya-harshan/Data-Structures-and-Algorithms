package graphs.topoSort;

import java.util.*;

public class _06_find_eventual_safe_states {
    // not effecient but using Khan's method.. u need to know this
    // Original Graph:
    // Unsafe_Feeder_Path -> [CYCLE] -> Safe_Escape_Path -> Terminal Node

    // Reversed Graph:
    // Unsafe_Feeder_Path <- [CYCLE] <- Safe_Escape_Path <- Terminal Node

    // The philosophy is not just about finding what's "safe" vs. "in a cycle." It's about how the reversal
    // fundamentally changes the relationship between paths that feed into a cycle versus paths that exit a cycle.
    // --> The Unsafe Core: Nodes that are part of a cycle OR on a path that leads directly into a cycle. 
    // These can never be safe.
    // --> The Escape Path: Nodes that are on a path coming out of a cycle, which eventually leads to a 
    // terminal node. These nodes are safe.
    // --> The Independent Path: Nodes that have no connection to a cycle and lead to a terminal node. 
    // These are also safe.
    // ----- The challenge is separating Group 1 from Groups 2 and 3.
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] adjRev = new ArrayList[n];
        for (int i=0; i<n; i++) adjRev[i] = new ArrayList<>();

        int[] inDegree = new int[n];
        for (int i=0; i<n; i++) {
            for (int nei: graph[i]) adjRev[nei].add(i);
            inDegree[i] = graph[i].length;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n; i++) if (inDegree[i] == 0) q.offer(i);
        List<Integer> safe = new ArrayList<>();

        while (!q.isEmpty()) {
            int rev_terminal = q.poll();
            safe.add(rev_terminal);

            for (int nei: adjRev[rev_terminal]) {
                if (--inDegree[nei] == 0) q.offer(nei);
            }
        }
        Collections.sort(safe);
        return safe;
    }


    //===============================================================================================================================
    // gemini/striver -- similar to mine from below but clean
    public List<Integer> eventualSafeNodes_dfs1(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // using color instead of (path & visited)

        for (int i=0; i<n; i++) {
            if (color[i] == 0) dfs(i, graph, color); 
        }

        List<Integer> res = new ArrayList<>();
        for (int i=0; i<n; i++) if (color[i] != 1) res.add(i);
        return res;
    }

    private boolean dfs(int i, int[][] graph, int[] color) {
        color[i] = 1;

        for (int nei: graph[i]) {
            if (color[nei] == 1) return true;
            if (color[nei] == 2) continue;
            if (dfs(nei, graph, color)) return true;
        }
        color[i] = 2;
        return false;
    }
    //_____________________________________________________________________________________________________________________________
    // my method -- similar to above but less clean
    public List<Integer> eventualSafeNodes_dfs2(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];

        for (int i=0; i<n; i++) {
            if (!visited[i]) dfs(i, graph, visited, path); 
        }

        List<Integer> res = new ArrayList<>();
        for (int i=0; i<n; i++) if (!path[i]) res.add(i);
        return res;
    }

    private boolean dfs(int i, int[][] graph, boolean[] visited, boolean[] path) {
        visited[i] = true;
        path[i] = true;

        for (int nei: graph[i]) {
            if (!path[nei]) {
                if (visited[nei]) continue;
                if (dfs(nei, graph, visited, path)) return true;
            }
            else return true;
        }
        path[i] = false;
        return false;
    }
}

/*
 * URL: https://leetcode.com/problems/find-eventual-safe-states/description/

802. Find Eventual Safe States

There is a directed graph of n nodes with each node labeled from 0 to n - 1. 
The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array 
of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
A node is a terminal node if there are no outgoing edges. 
A node is a safe node if every possible path starting from that node leads to a terminal node 
(or another safe node).
Return an array containing all the safe nodes of the graph. 
The answer should be sorted in ascending order.

 
Example 1:
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
Example 2:
Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.

 
Constraints:

	n == graph.length
	1 <= n <= 104
	0 <= graph[i].length <= n
	0 <= graph[i][j] <= n - 1
	graph[i] is sorted in a strictly increasing order.
	The graph may contain self-loops.
	The number of edges in the graph will be in the range [1, 4 * 104].
 */