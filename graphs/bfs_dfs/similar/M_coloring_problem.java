package graphs.bfs_dfs.similar;

// This isn't a dfs problem.... it's a iterative backtracking problem iterating through the nodes
// from 1 to n and trying to color them with m colors
public class M_coloring_problem {
    public static String graphColoring(int[][] mat, int m) {
        int[] color = new int[mat.length];

        return tryColoring(0, mat, color, m) ? "YES" : "NO";
    }

    static boolean tryColoring(int node, int[][] mat, int[] color, int m) {
        if (node == mat.length) return true;

        for (int c = 1; c <= m; c++) {
            if (isValidColor(node, c, mat, color)) {
                color[node] = c;
                if (tryColoring(node+1, mat, color, m)) return true;
                color[node] = 0; // u can't ignore restting it. u have to
            }
        }
        return false;
    }

    static boolean isValidColor(int node, int c, int[][] mat, int[] color) {
        for (int i=0; i<mat.length; i++) {
            if (mat[node][i] == 1 && color[i] == c) return false;
        }
        return true;
    } 
}

/*
https://www.naukri.com/code360/problems/m-coloring-problem_981273

 * You are given an undirected graph as an adjacency matrix consisting of 'v' vertices and an 
 * integer 'm'.

You need to return 'YES' if you can color the graph using at most 'm' colors so that 
no two adjacent vertices are the same. Else, return 'NO'.
 */