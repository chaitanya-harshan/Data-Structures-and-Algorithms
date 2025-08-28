package binary._2D_arrays;

public class _02_searching_matrix {

    // Optimal version
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0, high = n*m - 1;
        while (low <= high) {
            int mid = (low +high)/2;

            int row = mid/m;
            int column = mid % m;

            int element = matrix[row][column];

            if (element == target) return true;
            else if (element > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
    
    // not optimal method
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int low = 0, high = rows-1;
        int row = 0;
        while (low <= high) {
            int mid =(low+high)/2;
            if (matrix[mid][0] <= target) {
                row = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }

        low = 0;
        high = columns-1;
        while (low <= high) {
            int mid = (low + high)/2;
            int element = matrix[row][mid];
            if (element == target) return true;
            else if (element > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}

/*
 * URL: https://leetcode.com/problems/search-a-2d-matrix/description/

74. Search a 2D Matrix

You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.

 
Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

 
Constraints:

	m == matrix.length
	n == matrix[i].length
	1 <= m, n <= 100
	-104 <= matrix[i][j], target <= 104
 */
