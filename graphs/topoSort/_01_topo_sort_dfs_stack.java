package graphs.topoSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _01_topo_sort_dfs_stack {
    public ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        List<Integer>[] adj = new ArrayList[v];
        for (int i=0; i<v; i++) adj[i] = new ArrayList<>();
        for (ArrayList<Integer> ed : edges) adj[ed.get(0)].add(ed.get(1));

        boolean[] visited = new boolean[v];
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<v; i++) {
            if (!visited[i]) dfs(i, adj, visited, st);
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while (!st.empty()) topo.add(st.pop());
        return topo;
    }

    private void dfs(int i, List<Integer>[] adj, boolean[] visited, Stack<Integer> st) {
        visited[i] = true;

        for (int nei: adj[i]) {
            if (!visited[nei]) dfs(nei, adj, visited, st);
        }
        st.push(i);
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