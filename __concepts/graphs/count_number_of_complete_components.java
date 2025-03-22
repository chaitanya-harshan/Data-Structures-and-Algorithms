package __concepts.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class count_number_of_complete_components {

    HashSet<Integer> visited = new HashSet<>();

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i=0; i<n; i++) graph[i] = new ArrayList<>();
        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int res = 0;
        for (int i=0; i<n; i++) {
            if (visited.contains(i)) continue;
            List<Integer> comp_nodes = dfs(i, graph, new ArrayList<>());
            boolean flag = true;
            for (int nei: comp_nodes) {
                if (graph[nei].size() != comp_nodes.size()-1) {
                    flag = false;
                    break;
                }
            }
            if (flag) res++;
        }
        return res;
    }

    public List<Integer> dfs(int i, List<Integer>[] graph, List<Integer> comp_nodes) {
        if (visited.contains(i)) return new ArrayList<>();
        visited.add(i);
        comp_nodes.add(i);

        for (int j: graph[i]) dfs(j, graph, comp_nodes);
        return comp_nodes;
    }
}

/*
When you call DFS on a vertex that's already been visited, your DFS function returns an empty list. Then you do this check:

for (int nei: comp_nodes) {
    if (graph[nei].size() != comp_nodes.size()-1) flag = false;
}

Because comp_nodes is empty, the loop body never executes. This means flag remains true, and you later increment res even though no new component was discovered. 
In other words, an empty list doesn't trigger any check to set flag to false, so the code mistakenly counts it as a complete component.
To avoid this, you should check if a vertex is visited before calling DFS. That way, you only perform the DFS (and subsequent completeness check) on unvisited vertices.
*/



//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


/*
 * 2685. Count the Number of Complete Components
https://leetcode.com/problems/count-the-number-of-complete-components/description/

You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

Return the number of complete connected components of the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

A connected component is said to be complete if there exists an edge between every pair of its vertices.

 

Example 1:



Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
Output: 3
Explanation: From the picture above, one can see that all of the components of this graph are complete.
Example 2:



Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
Output: 1
Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.
 

Constraints:

1 <= n <= 50
0 <= edges.length <= n * (n - 1) / 2
edges[i].length == 2
0 <= ai, bi <= n - 1
ai != bi
There are no repeated edges.
 */