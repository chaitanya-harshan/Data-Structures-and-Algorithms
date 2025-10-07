package graphs.topoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _02_khans_algo_topo_sort {
    // ----------- Khan's Algo ------------
    public ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        List<Integer>[] adj = new ArrayList[v];
        for (int i=0; i<v; i++) adj[i] = new ArrayList<>();
        int[] inDegree = new int[v]; // inDegree array
        for (List<Integer> ed: edges) {
            adj[ed.get(0)].add(ed.get(1));
            inDegree[ed.get(1)]++; 
            // ***** arrow-head has dependency on tail.
            //  we have to assume this to do topoSort
            // heighest node has 0 depedencies
            // topo-sort is about no dependency -> most dependency
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<v; i++) if (inDegree[i] == 0) q.offer(i);
        ArrayList<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int nei: adj[node]) {
                if (--inDegree[nei] == 0) q.offer(nei);
            }
        }
        return topo;
        // topo.size() != v ---> cycle is present;
    }
}

/*
https://www.naukri.com/code360/problems/topological-sort_982938
https://www.geeksforgeeks.org/problems/topological-sort/1

 * Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list 
 * of edges[][], where each entry edges[i] = [u, v] denotes a directed edge u -> v. 
 * Return the topological sort for the given graph.

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that 
for every directed edge u -> v, vertex u comes before v in the ordering.
Note: As there are multiple Topological orders possible, you may return any of them. If your returned 
Topological sort is correct then the output will be true else false.
 */