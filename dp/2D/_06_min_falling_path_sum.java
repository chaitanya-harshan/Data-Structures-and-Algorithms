import java.util.Arrays;

public class _06_min_falling_path_sum {
    
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] prev = new int[n];

        for (int i=m-1; i>=0; i--) {
            int[] dp = new int[n];
            for (int j=0; j<n; j++) {
                
                dp[j] = prev[j]; // default non zero vlaue
                for (int k=-1; k<2; k++) {
                    if (j+k < 0 || j+k > n-1) continue;
                    dp[j] = Math.min(dp[j], prev[j+k]);
                }
                dp[j] += matrix[i][j];
            }
            prev = dp;
        }

        return Arrays.stream(prev).min().getAsInt();
    }
}

/*
 * 931. Minimum Falling Path Sum
 * https://leetcode.com/problems/minimum-falling-path-sum/description/
 * 
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

Example 1:


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100

 */