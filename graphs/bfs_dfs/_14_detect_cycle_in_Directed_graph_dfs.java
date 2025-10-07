package graphs.bfs_dfs;

import java.util.ArrayList;
import java.util.List;

public class _14_detect_cycle_in_Directed_graph_dfs {

  // this is using DFS
  // BFS --- Khan's algo in topo sort
  public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
    List<Integer>[] adj = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
    for (List<Integer> e : edges) adj[e.get(0)].add(e.get(1));

    boolean[] visited = new boolean[n + 1];
    boolean[] path = new boolean[n + 1];

    for (int i = 1; i <= n; i++) {
      if (!visited[i] && dfs(i, adj, visited, path)) return true;
    }
    return false;
  }

  static boolean dfs(int i, List<Integer>[] adj, boolean[] visited, boolean[] path) {
    visited[i] = true;
    path[i] = true;

    for (int nei : adj[i]) {
      if (path[nei]) return true;
      if (!visited[nei] && dfs(nei, adj, visited, path)) {
        return true;
      }
    }
    path[i] = false;
    return false;
  }
}

/*
https://www.naukri.com/code360/problems/detect-cycle-in-a-directed-graph_1062626

 * You are given a directed graph having ‘N’ nodes. A matrix ‘EDGES’ of size M x 2 is given which represents the ‘M’ edges such that there is an edge directed from node EDGES[i][0] to node EDGES[i][1].

Find whether the graph contains a cycle or not, return true if a cycle is present in the given directed graph else return false.

For Example :
In the following directed graph has a cycle i.e. B->C->E->D->B.

Note :
1. The cycle must contain at least two nodes.
2. It is guaranteed that the given graph has no self-loops in the graph.
3. The graph may or may not be connected.
4. Nodes are numbered from 1 to N.
5. Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 ≤ T ≤ 5

2 <= N <= 100
1 <= M <= min(100,N(N-1)/2)
1 <= EDGES[i][0], EDGES[i][1] <= N

Where ‘T’ is the number of test cases.

Time Limit: 1 sec
Sample Input 1 :
1
5
6
1 2
4 1
2 4
3 4
5 2
1 3
Sample Output 1 :
true
Explanation For Input 1 :
The given graph contains cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1.
Sample Input 2 :
2
5
4
1 2
2 3
3 4
4 5
2
1
1 2
Sample Output 2 :
false
false
Explanation For Input 2 :
The given graphs don’t contain any cycle.

 */
