package __concepts.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class number_of_ways_to_arrive_at_destination {
    // I forgot about the question and I used 'distance' instead of 'time', but regardless, it's the same process. 
    static class Edge {
        int node;
        long distance;
        
        Edge(int node, long distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static final int MOD = (int)Math.pow(10,9)+7;

    public int countPaths(int n, int[][] roads) {
        List<Edge>[] graph = new ArrayList[n];
        // Edge1 -> next node,  distance b/w [cur] & [nxt] node
        for (int i=0; i<n; i++) graph[i] = new ArrayList<>();
        for (int[] road: roads) {
            graph[road[0]].add(new Edge(road[1], road[2]));
            graph[road[1]].add(new Edge(road[0], road[2]));
        }

        int[] ways = new int[n];
        long[] minDis = new long[n];
        Arrays.fill(minDis, Long.MAX_VALUE);
        ways[0] = 1;
        minDis[0] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> Long.compare(a.distance, b.distance));
        // ****** Different Edge *******
        // Edge2 -> cur node, total_min_distance from [start] to [Cur] node.
        pq.offer(new Edge(0,0));

        while (!pq.isEmpty()) {
            int cur = pq.peek().node; // current node
            long MDC = pq.poll().distance; // [MDC] = min distance to cur_node

            for (Edge neig: graph[cur]) {
                int nN = neig.node;
                long nD = neig.distance;
                if (MDC + nD < minDis[nN]) {
                    minDis[nN] = MDC + nD;
                    ways[nN] = ways[cur];
                    pq.offer(new Edge(nN, minDis[nN]));
                }
                else if (MDC + nD == minDis[nN]) {
                    ways[nN] = (ways[nN] + ways[cur]) % MOD;
                }
            }
        }

        return ways[n-1];
    }
}

/*
 * 1976. Number of Ways to Arrive at Destination
https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

 

Example 1:


Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
Example 2:

Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 

Constraints:

1 <= n <= 200
n - 1 <= roads.length <= n * (n - 1) / 2
roads[i].length == 3
0 <= ui, vi <= n - 1
1 <= timei <= 109
ui != vi
There is at most one road connecting any two intersections.
You can reach any intersection from any other intersection.
 */