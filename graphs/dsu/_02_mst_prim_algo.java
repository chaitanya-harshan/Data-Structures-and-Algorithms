package graphs.dsu;

import java.util.*;

public class _02_mst_prim_algo {
    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int V) {
		ArrayList<int[]>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        for (List<Integer> e: edges) {
            adj[e.get(0)].add(new int[]{e.get(1), e.get(2)});
            adj[e.get(1)].add(new int[]{e.get(0), e.get(2)});
        }

		boolean[] visited = new boolean[V];
		int mstWeight = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0,0}); // node, weight

		while(!pq.isEmpty()) {
			int cur = pq.peek()[0];
			int wt = pq.poll()[1];

			if (visited[cur]) continue;
			// the elements added to pq stay there until they get their turn
			// in the mean time that node might be visited when traversed from the node 
			// which was lower in the pq 

			visited[cur] = true;
			mstWeight += wt;

			for (int[] nei: adj[cur]) {
				// if (!visited[nei[0]]) {
					pq.offer(nei);
				// }
			}
		}
		return mstWeight;
	}
}

/*
https://www.naukri.com/code360/problems/minimum-spanning-tree_631769?leftPanelTabValue=PROBLEM

 * You are given an undirected, connected and weighted graph G(V, E), consisting of V number of vertices (numbered from 0 to V-1) and E number of edges.

Find and print the total weight of the Minimum Spanning Tree (MST) using Kruskal's algorithm.

By definition, a minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
2 <= V <= 10^5
1 <= E <= 3 * 10^5
0 <= X < N
0 <= Y < N
1 <= W <= 10^4

where V and E represent the number of vertices and edges respectively.
X and Y represent the vertices between which there is an edge.
W is the weight of the edge.

Time limit: 1sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output 1 :
9
Explanation for Sample Input 1:
The edge (2,3) having weight 8 will be excluded from the MST. The total weight of the MST then will be 1 + 3 + 5 = 9.
Sample Input 2:
4 4
1 2 6
2 3 2
1 3 2
1 0 2
Sample Output 2:
6
 */