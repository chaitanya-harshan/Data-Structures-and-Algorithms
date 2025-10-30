package recursion.lec3Hard;

// This isn't a dfs problem.... it's a iterative backtracking problem iterating through the nodes
// from 1 to n and trying to color them with m colors
public class _06_M_nodes_coloring {
    static int[][] matrix;
    static int[] colors;
    
    public static String graphColoring(int [][]mat, int m) {
        matrix = mat;
        colors = new int[matrix.length];
        
        if (not_dfs(0, m)) return "YES";
        else return "NO";
    }
    
    static boolean not_dfs(int node, int m) {
        if (node == matrix.length) return true;
        
        for (int c=1; c<=m; c++) {
            if (isValid(node, c)) {
                colors[node] = c;
                if (not_dfs(node+1, m)) return true;
                colors[node] = 0;
            }
        }
        return false;
    }
    
    static boolean isValid(int node, int col) {
        for (int i=0; i<matrix.length; i++) {
            if (matrix[node][i] == 1 && colors[i] == col) return false;
        }
        return true;
    }
}

// https://youtu.be/wuVwUK25Rfc
// https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1

/*
 *  M-Coloring Problem
https://www.naukri.com/code360/problems/m-coloring-problem_981273


You are given an undirected graph as an adjacency matrix consisting of 'v' vertices and an integer 'm'.

You need to return 'YES' if you can color the graph using at most 'm' colors so that no two adjacent 
vertices are the same. Else, return 'NO'.



For example:
Input:
If the given adjacency matrix is:
[0 1 0]
[1 0 1]
[0 1 0] and 'm' = 3.

Output: YES

Explanation:
The given adjacency matrix tells us that 1 is connected to 2 and 2 is connected to 3. We can use three different colors and color all three nodes.
Hence we return true.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3 2
0 1 0
1 0 1
0 1 0
Sample Output 1:
YES
Explanation of Input 1:
The adjacency matrix tells us that 1 is connected to 2, and 2 is connected to 3. We can see that a minimum of 2 colors would be needed to color the graph. So it is possible to color the graph in this case.
Sample Input 2:
3 1
0 1 0
1 0 1
0 1 0
Sample Output 2
NO
Constraints:
1 ≤ v ≤ 20
1 ≤ m ≤ v

Time Limit: 1 sec 
 */