package graphs.dsu;

import java.util.Arrays;

public class _05_kruskal_mst_dsu {
    public static int kruskalsMST(int V, int[][] edges) {
        Arrays.sort(edges, (a,b) -> a[2] - b[2]);
        int mstWeight = 0;
        DSU uf = new DSU(V);
        
        for (int[] e: edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            if (uf.find(u) != uf.find(v)) {
                mstWeight += w;
                uf.union(u,v);
                
                if (uf.sets == 1) break;
            }
        }
        return mstWeight;
    }
}

class DSU {
    int[] parent;
    int[] size;
    int sets;
    
    DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    
    boolean union(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        
        if (pi == pj) return false;
        if (size[pj] > size[pi]) {
            parent[pi] = pj;
            size[pj] += size[pi];
        }
        else {
            parent[pj] = pi;
            size[pi] += size[pj];
        }
        
        sets--;
        return true;
    }
}

/*
https://www.geeksforgeeks.org/problems/minimum-spanning-tree-kruskals-algorithm/1

 * Minimum Spanning Tree - Kruskal's Algorithm
Difficulty: MediumAccuracy: 53.2%Submissions: 15K+Points: 4
Given a weighted, undirected, and connected graph with V vertices and E edges, the task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph using Kruskal's Algorithm. The graph is represented as an edge list edges[][], where edges[i] = [u, v, w] denotes an undirected edge between u and v with weight w.

Input: V = 3, E = 3, edges[][] = [[0, 1, 5], [1, 2, 3], [0, 2, 1]]

Output: 4
Explanation:

The Spanning Tree resulting in a weight of 4 is shown above.
Input: V = 2, E = 1, edges = [[0, 1, 5]]
  
Output: 5 
Explanation: Only one Spanning Tree is possible which has a weight of 5.
Constraints:
2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
The graph is connected and doesn't contain self-loops & multiple edges.
 */