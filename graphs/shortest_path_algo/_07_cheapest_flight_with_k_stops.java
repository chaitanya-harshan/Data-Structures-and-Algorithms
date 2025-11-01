package graphs.shortest_path_algo;

import java.util.*;

public class _07_cheapest_flight_with_k_stops {
    // variaiton of Bellman-Ford. this is a bfs traversal of steps
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Flight>[] adj = new ArrayList[n];
        for (int i=0; i<n; i++) adj[i] = new ArrayList<>();
        for (int[] f: flights) adj[f[0]].add(new Flight(f[1], f[2]));

        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        // costs[src] = 0; // not needed as u put 0 cost as starting in the pq or queue

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2]-b[2]));
        // sometimes we need to use a costlier path to reach less costlier path in the future in k limit.
        // so we need to try out all possibilities and not just the low cost paths.
        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{src, 0, 0}); // node, edge_wt, k

        while (!pq.isEmpty()) {
            int cur = pq.peek()[0];
            int wt = pq.peek()[1];
            int cf = pq.poll()[2];

            if (cf > k) continue;

            for (Flight nei: adj[cur]) {
                int neiNode = nei.flight;
                int price = nei.price;

                if (wt + price < costs[neiNode]) {
                    costs[neiNode] = wt + price;
                    pq.offer(new int[]{neiNode, costs[neiNode], cf+1});
                }
            }
        }

        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }

    //
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
        List<Flight>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] f : flights) adj[f[0]].add(new Flight(f[1], f[2]));

        // stops[node] = minimum number of stops we've used to reach node so far
        // if we later reach node with more stops than stops[node], skip it.
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        // stops[src] = 0;

        // PQ items: {costSoFar, node, stopsSoFar}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0, 0});

        while (!pq.isEmpty()) {
            int cur = pq.peek()[0];
            int wt = pq.peek()[1];
            int cf = pq.poll()[2];

            if (cur == dst) return wt;  // this can't be inside the for loop
            if (cf > K) continue;

            stops[cur] = cf; // this has to be here... idk man ask gpt
            // use this case:   0-1-3; 0-2-3
            // flights:
            // 0 -> 1 : 9
            // 0 -> 2 : 10
            // 1 -> 3 : 8
            // 2 -> 3 : 1

            // u get issue when p2 cf is == p1 then p2 will be rejected even if p2 cost is less.
            // if you're wondering how the hell can p2 be lesser cost... do that example
            // does this happen only when p1 == p2????
            // Short answer: it’s not only when the two paths have equal length — the bug happens whenever an 
            // earlier (possibly more expensive) path sets stops[v] to some value S, and a later (cheaper) path 
            // reaches v with stops >= S. In that case the later (cheaper) path will be blocked.

            // If the later cheaper path uses fewer stops (i.e. strictly less than S) then it will pass the cf+1 < 
            // stops[v] check and will not be blocked. So a shorter path is safe; an equal-length or longer-later 
            // path is the risky case.

            // I think the point is we have to try out all possibilities and if we change the steps[] in the 
            // for loop then we'd block future paths which cost less (how less cost in future paths??? do 
            //  that example) because of that if (cf + 1 < steps[node]) therefore we offer them first to pq
            // and only prune them when k limit is crossed.

            for (Flight nei : adj[cur]) {
                int node = nei.flight;
                int price = wt + nei.price;

                if (cf + 1 <= stops[node]) { // == not needed
                    // stops[node] = cf + 1; // can't be here inside for loop
                    pq.offer(new int[]{node, price, cf + 1});
                }
            }
        }
        return -1;
    }
}

class Flight {
    int flight, price;
    Flight(int f, int p) { flight = f; price = p; }
}

/*
 * URL: https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

787. Cheapest Flights Within K Stops

There are n cities connected by some number of flights. You are given an array flights where 
flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

 
Example 1:
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
Example 2:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
Example 3:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.

 
Constraints:

	1 <= n <= 100
	0 <= flights.length <= (n * (n - 1) / 2)
	flights[i].length == 3
	0 <= fromi, toi < n
	fromi != toi
	1 <= pricei <= 104
	There will not be any multiple flights between two cities.
	0 <= src, dst, k < n
	src != dst
 */
