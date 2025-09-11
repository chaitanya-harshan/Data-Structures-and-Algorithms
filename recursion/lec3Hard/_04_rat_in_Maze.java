package recursion.lec3Hard;

import java.util.ArrayList;

public class _04_rat_in_Maze {

    // DLRU
    int[][] maze;
    boolean[][] available;
    ArrayList<String> res = new ArrayList<>();
    int m,n;
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        int m = maze.length, n = maze[0].length;
        this.maze = maze;
        this.available = new boolean[m][n];
        this.m = m;
        this.n = n;
        
        dfs(0,0,"");
        return res;
    }
    
    void dfs(int r, int c, String path) {
        if (r<0 || r>=m || c<0 || c>=n) return;
        if (r == m-1 && c == n-1) {
            res.add(new String(path));
            return;
        }
        if (maze[r][c] == 0) return;
        if (available[r][c]) return;
        
        available[r][c] = true;
        dfs(r+1,c,path+'D');
        dfs(r,c-1,path+'L');
        dfs(r,c+1,path+'R');
        dfs(r-1,c,path+'U');
        available[r][c] = false;
    }
}

/*
https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
https://youtu.be/bLGZhJlt4y0

Rat in a Maze Problem - I
Consider a rat placed at position (0, 0) in an n x n square matrix mat[][]. The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

The matrix contains only two possible values:

0: A blocked cell through which the rat cannot travel.
1: A free cell that the rat can pass through.
Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
If no path exists, return an empty list.

Note: Return the final result vector in lexicographically smallest order.

Examples:

Input: mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
Input: mat[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists as the destination cell is blocked.
Input: mat = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
Output: ["DDRR", "RRDD"]
Explanation: The rat has two possible paths to reach the destination: 1. "DDRR" 2. "RRDD", These are returned in lexicographically sorted order.


Constraints:
2 ≤ mat.size() ≤ 5
0 ≤ mat[i][j] ≤ 1

Expected Complexities
Time Complexity: O(4 ^ (n * n))
Auxiliary Space: O(n * n)
 */
