package graphs.shortest_path_algo;

import java.util.*;

public class _03_print_shortest_path_Dijkstra {
    // https://youtu.be/rp1SMw7HSO8?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn -- striver
    // this problem doesn't exist
    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> edges, int V, int E, int s){
		List<Node>[] adj = new ArrayList[V+1];
		for (int i=1; i<=V; i++) adj[i] = new ArrayList<>();
		for (List<Integer> e: edges) {
			adj[e.get(0)].add(new Node(e.get(1), e.get(2)));
			adj[e.get(1)].add(new Node(e.get(0), e.get(2)));
		}

		int[] parent = new int[V+1];
        for (int i=0; i<=V; i++) parent[i] = i;
		int[] dist = new int[V+1];
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
                    parent[v] = cur;
				}
			}
		}
		ArrayList<Integer> res = new ArrayList<>();
        int tail = V;
        while (parent[tail] != tail) {
            res.add(tail);
            tail = parent[tail];
        }
        res.add(1);
        Collections.reverse(res);
        return res;
	}
}

class Node {
	int v; int wt;
	Node(int v, int wt) {this.v = v; this.wt = wt;}
}
