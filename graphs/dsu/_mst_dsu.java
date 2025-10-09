package graphs.dsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _mst_dsu {
    public int spanningTree(int V, int[][] edges) {
        // Step 1: Sort all edges in non-decreasing order of their weight.
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

        DSU dsu = new DSU(V);

        // This will store the edges of our resulting Minimum Spanning Tree.
        // We will represent the tree as an adjacency list.
        List<List<int[]>> mst = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            mst.add(new ArrayList<>());
        }

        int mstWeight = 0;
        int edgesCount = 0;

        // Step 2: Iterate through all sorted edges.
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            // Check if including this edge creates a cycle.
            // If u and v have different parents, they are in different sets,
            // so adding an edge between them will not form a cycle.
            if (dsu.find(u) != dsu.find(v)) {
                // Step 3: If no cycle, include this edge.
                dsu.union(u, v);
                mstWeight += weight;

                // Add the edge to our MST representation.
                // Since it's an undirected graph, add it for both vertices.
                mst.get(u).add(new int[]{v, weight});
                mst.get(v).add(new int[]{u, weight});

                // An MST will always have V-1 edges. We can stop once we have them.
                edgesCount++;
                if (edgesCount == V - 1) {
                    break;
                }
            }
        }
        return mstWeight;
    }
}


class DSU {
    int[] parent;
    int[] size;
    int sets;

    public DSU(int n) {
        this.sets = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);

        if (pi == pj) return;

        if (size[pi] < size[pj]) {
            parent[pi] = pj;
            size[pj] += size[pi];
        } else {
            parent[pj] = pi;
            size[pi] += size[pj];
        }

        sets--;
    }
}