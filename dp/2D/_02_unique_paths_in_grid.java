public class _02_unique_paths_in_grid {
    public int uniquePaths(int m, int n) {
        // tabulation using space optimization
        int[] prev = new int[n];

        for (int i=m-1; i>=0; i--) {
            int[] row = new int[n];
            row[n-1] = 1;
            for (int j=n-2; j>=0; j--) {
                row[j] = row[j+1] + prev[j];
            }
            prev = row;
        }
        return prev[0];

        // Math: Factorial => NCr

        int N = m-1 + n-1;
        int r = m-1;
        if (N-r < r) r = N-r; // nCr == nC(n-r)
        double result = 1;
        for (int i = 1; i <= r; i++) {
            // result *= ((double)(N-r+i) / i);
            // result = (double)(N-r+i) / i;
            result = result * (N-r+i)/i;
        }
        return (int)result;
    }
}

/*
 * URL: https://leetcode.com/problems/unique-paths/description/

62. Unique Paths

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

 
Example 1:
Input: m = 3, n = 7
Output: 28
Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

 
Constraints:

	1 <= m, n <= 100
 */