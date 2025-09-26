package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _detect_cycles_bfs {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        // Loop to handle disconnected components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // If a cycle is found in any component, return true
                if (checkForCycleBFS(i, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkForCycleBFS(int startNode, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        // Queue stores pairs of {node, parent}
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{startNode, -1}); // Start with node and -1 as parent
        visited[startNode] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int node = current[0];
            int parent = current[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(new int[]{neighbor, node});
                } 
                // If neighbor is visited and is not the parent, a cycle exists
                else if (neighbor != parent) {
                    return true;
                }
            }
        }
        
        // No cycle found in this component
        return false;
    }
}
