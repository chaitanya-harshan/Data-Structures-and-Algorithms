package arrays.sde.Arrays_3;

import java.util.Arrays;

public class _05_unique_paths {
    public int uniquePaths(int m, int n) {
        // basically finding the total number of ways we can arrange n things -> n!
        // RRRRRRDD -> 8 moves
        // total number of diff ways -> 8! / (6!*2!) cause we have 6 same things (R) 
        // and 2 same things (D)
        // *this formula looks like crap ass nCr which is the main reason for confusion
        int N = m-1 + n-1;
        int r = m-1;
        double result = 1;
        for (int i = 1; i <= r; i++) {
            // result *= ((double)(N-r+i) / i); won't worl
            // result = (double)(N-r+i) / i; won't work 
            result = result * (N-r+i)/i;
        }
        return (int)result;
    }

    public int dynamicProgramming(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[m-1], 1);
        for (int i=0; i<m; i++) {
            dp[i][n-1] = 1;
        }
        for (int i=m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}

/*
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/description/
 * 
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Input: m = 3, n = 7
Output: 28

Input: m = 3, n = 2
Output: 3

O|_|_|_|_|_|_|
_|_|_|_|_|_|_|
_|_|_|_|_|_|X|

 */