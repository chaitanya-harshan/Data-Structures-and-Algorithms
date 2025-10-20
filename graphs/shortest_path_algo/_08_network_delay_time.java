package graphs.shortest_path_algo;

import java.util.*;

public class _08_network_delay_time {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n+1];
        for (int i=1; i<=n; i++) adj[i] = new ArrayList<>();
        for (int[] t: times) adj[t[0]].add(new int[]{t[1], t[2]});

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        // dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0}); // node, wt

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int wt = cur[1];

            for (int[] nei: adj[node]) {
                int neiNode = nei[0];
                int time = nei[1];

                if (wt + time < dist[neiNode]) {
                    dist[neiNode] = wt + time;
                    pq.offer(new int[]{neiNode, wt + time});
                }
            }
        }

        // int max = Arrays.stream(dist).max().getAsInt();
        int max = 0;
        for (int i=1; i<=n; i++) max = Math.max(max, dist[i]);
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}

/*
 * URL: https://leetcode.com/problems/network-delay-time/description/

743. Network Delay Time

You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 
Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:
Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:
Input: times = [[1,2,1]], n = 2, k = 2
Output: -1

 
Constraints:

	1 <= k <= n <= 100
	1 <= times.length <= 6000
	times[i].length == 3
	1 <= ui, vi <= n
	ui != vi
	0 <= wi <= 100
	All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 */