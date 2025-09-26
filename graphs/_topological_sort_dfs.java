package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class _topological_sort_dfs {
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        // 1. Construct the adjacency list from the list of edges.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
        for (ArrayList<Integer> edge : edges) {
            // For an edge [u, v], add v to the adjacency list of u.
            adj.get(edge.get(0)).add(edge.get(1));
        }

        // --- The rest of your logic is mostly correct, just needs to use 'adj' ---

        boolean[] visited = new boolean[v];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                // 2. Pass the newly created 'adj' list to the DFS function.
                dfs(adj, visited, st, i);
            }
        }

        // Pop from the stack to get the topological order.
        ArrayList<Integer> topo = new ArrayList<>();
        while (!st.isEmpty()) {
            topo.add(st.pop());
        }
        return topo;
    }

    // 3. Update the DFS function to accept and use the adjacency list 'adj'.
    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st, int node) {
        visited[node] = true;

        // Iterate through the neighbors of the current node using the adjacency list.
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfs(adj, visited, st, nei);
            }
        }
        // After visiting all neighbors, push the current node to the stack.
        st.push(node);
    }
}
