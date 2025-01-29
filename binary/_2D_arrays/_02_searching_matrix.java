/*
 * You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
 */
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
