package graphs.bfs_dfs.similar;

import java.util.Arrays;
import java.util.List;

// https://gemini.google.com/app/e7de6e4c848f8d5f ****************
public class graph_coloring {

    /**
     * Colors an undirected graph using a greedy algorithm.
     *
     * @param adj The adjacency list representation of the graph.
     * @param V   The number of vertices in the graph.
     * @return The total number of colors used for this coloring.
     */
    public static int colorGraph(List<List<Integer>> adj, int V) {
        // This array will store the color assigned to each vertex.
        // -1 means the vertex is not yet colored.
        int[] result = new int[V];
        Arrays.fill(result, -1);

        // Assign the first color (0) to the first vertex.
        result[0] = 0;

        // A temporary array to store the available colors for a vertex.
        // If available[c] is true, then color c is available.
        boolean[] available = new boolean[V];
        Arrays.fill(available, true);

        // Iterate through the remaining V-1 vertices and assign them colors.
        for (int u = 1; u < V; u++) {
            // Check all neighbors of the current vertex `u` and mark their colors as unavailable.
            for (int neighbor : adj.get(u)) {
                // If the neighbor has been colored
                if (result[neighbor] != -1) {
                    available[result[neighbor]] = false;
                }
            }

            // Find the first available color (the smallest integer).
            int cr;
            for (cr = 0; cr < V; cr++) {
                if (available[cr]) {
                    break; // Found the first available color
                }
            }

            // Assign the found color to the current vertex `u`.
            result[u] = cr;

            // Reset the available array for the next iteration.
            Arrays.fill(available, true);
        }

        // Print the color assigned to each vertex
        System.out.println("Vertex color assignments:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " ---> Color " + result[i]);
        }

        // The number of colors required is one more than the maximum color index used.
        int maxColor = 0;
        for (int color : result) {
            if (color > maxColor) {
                maxColor = color;
            }
        }
        return maxColor + 1;
    }
}
