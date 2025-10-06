package graphs.bfs_dfs.similar;

import java.util.HashMap;

public class longest_cycle_in_1d_graph {
    // Each node can have one outgoing edge. Therefore, it is imperative that all the 
    // cycles are independent and won't touch each other. 
    // Therefore, we would iterate through each node and try to find the length of cycle
    // passing through that node and then return max of those lengths
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];

        int maxCycleLength = -1;
        for (int i=0; i<n; i++) {
            if (visited[i] || edges[i] == -1) continue;
            int cycle = cycleLength(i, edges, visited, new HashMap<>(), 0);
            maxCycleLength = Math.max(maxCycleLength, cycle);
        }
        return maxCycleLength;
    }

    private int cycleLength(int i, int[] edges, boolean[] visited, HashMap<Integer, Integer> path, int step) {
        // It means this path touched another previously traversed cycle or another traversed 
        // non-cyclic path, it results in no new cycle or the end of the current path. 
        if (edges[i] == -1) return -1;

        if (path.containsKey(i)) {
            visited[i] = true;
            return step - path.get(i);
        }
        if (visited[i]) return -1;
        visited[i] = true;
        path.put(i, step);
        
        return cycleLength(edges[i], edges, visited, path, step+1); // -1 or cycle
    }
}

/*
 * URL: https://leetcode.com/problems/longest-cycle-in-a-graph/description/

2360. Longest Cycle in a Graph

You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.
The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i]. If there is no outgoing edge from node i, then edges[i] == -1.
Return the length of the longest cycle in the graph. If no cycle exists, return -1.
A cycle is a path that starts and ends at the same node.

 
Example 1:
Input: edges = [3,3,4,2,3]
Output: 3
Explanation: The longest cycle in the graph is the cycle: 2 -> 4 -> 3 -> 2.
The length of this cycle is 3, so 3 is returned.
Example 2:
Input: edges = [2,-1,3,1]
Output: -1
Explanation: There are no cycles in this graph.

 
Constraints:

	n == edges.length
	2 <= n <= 105
	-1 <= edges[i] < n
	edges[i] != i
 */