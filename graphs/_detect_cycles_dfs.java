package graphs;

import java.util.ArrayList;

public class _detect_cycles_dfs {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        // This loop handles disconnected components of the graph
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // If the DFS traversal from an unvisited node finds a cycle, return true
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }

        // If no cycles are found after checking all components, return false
        return false;
    }

    boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        // Mark the current node as visited
        visited[node] = true;

        // Explore all neighbors of the current node
        for (int neighbor : adj.get(node)) {
            // If the neighbor has not been visited, recursively call DFS on it
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true; // Cycle detected in the recursive call
                }
            }
            // If the neighbor is visited AND it's not the parent of the current node,
            // then we have found a back edge, which means there is a cycle.
            else if (neighbor != parent) {
                return true;
            }
        }

        // No cycle found from this node's path
        return false;
    }
}
