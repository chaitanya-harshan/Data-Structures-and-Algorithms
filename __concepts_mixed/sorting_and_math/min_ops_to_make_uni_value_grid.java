package __concepts_mixed.sorting_and_math;

import java.util.Arrays;

public class min_ops_to_make_uni_value_grid {

    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int[] nums = new int[n*m];

        // Checking if it's even possible.
        // all the reminders with X should be the same. 
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] % x != grid[0][0] % x) return -1;
                nums[i*m+j] = grid[i][j];
            }
        }

        Arrays.sort(nums);
        int prefix = 0;
        int total = Arrays.stream(nums).sum();
        int min = Integer.MAX_VALUE;;

        for (int i=0; i<m*n; i++) {
            int ref = nums[i];
            int left_cost = (i*ref - prefix) / x;
            int right_cost = (total - prefix - (m*n-i)*ref) / x;

            prefix += nums[i];
            min = Math.min(min, left_cost+right_cost);
        }
        return min;
    }
}

/*
 * URL: https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/

2033. Minimum Operations to Make a Uni-Value Grid

You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.

A uni-value grid is a grid where all the elements of it are equal.

Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.

 
Example 1:

Input: grid = [[2,4],[6,8]], x = 2
Output: 4
Explanation: We can make every element equal to 4 by doing the following: 
- Add x to 2 once.
- Subtract x from 6 once.
- Subtract x from 8 twice.
A total of 4 operations were used.

Example 2:

Input: grid = [[1,5],[2,3]], x = 1
Output: 5
Explanation: We can make every element equal to 3.

Example 3:

Input: grid = [[1,2],[3,4]], x = 2
Output: -1
Explanation: It is impossible to make every element equal.

 
Constraints:

	m == grid.length
	n == grid[i].length
	1 <= m, n <= 105
	1 <= m * n <= 105
	1 <= x, grid[i][j] <= 104
 */