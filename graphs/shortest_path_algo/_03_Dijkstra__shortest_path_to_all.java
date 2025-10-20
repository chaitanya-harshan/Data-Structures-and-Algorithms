package graphs.shortest_path_algo;

import java.util.*;

public class _03_Dijkstra__shortest_path_to_all {
    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> edges, int V, int E, int s){
		List<Node>[] adj = new ArrayList[V];
		for (int i=0; i<V; i++) adj[i] = new ArrayList<>();
		for (List<Integer> e: edges) {
			adj[e.get(0)].add(new Node(e.get(1), e.get(2)));
			adj[e.get(1)].add(new Node(e.get(0), e.get(2)));
		}

		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
		pq.offer(new Node(s, 0));

		while (!pq.isEmpty()) {
			int d = pq.peek().wt;
			int cur = pq.poll().v;

			for (Node nei: adj[cur]) {
				int v = nei.v, wt = nei.wt;
				if (d + wt < dist[v]) {
					dist[v] = d + wt;
					pq.offer(new Node(v, dist[v]));
				}
			}
		}
		// ArrayList<Integer> res = new ArrayList<>(Arrays.asList(dist));
		ArrayList<Integer> res = new ArrayList<>();
		for (int i: dist) res.add(i);
		return res;
	}
}

class Node {
	int v; int wt;
	Node(int v, int wt) {this.v = v; this.wt = wt;}
}


/*
https://www.naukri.com/code360/problems/dijkstra-s-shortest-path_920469

 * You have been given an undirected graph of ‘V’ vertices (labeled 0,1,..., V-1) and ‘E’ edges. 
 * Each edge connecting two nodes (‘X’,’Y’) will have a weight denoting the distance 
 * between node ‘X’ and node ‘Y’.

Your task is to find the shortest path distance from the source node, 
which is the node labeled as 0, to all vertices given in the graph.
 */