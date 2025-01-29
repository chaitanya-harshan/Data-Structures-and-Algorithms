/*
 * algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 */
package binary._2D_arrays;

public class _03_search_matrix_sorted_rows_columns {
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15},{2, 5, 8, 12, 19},{3, 6, 9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(matrix, 8));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0, column = m-1;
        while (row < n && column >= 0) {
            if (matrix[row][column] == target) return true;
            else if (matrix[row][column] < target) row++;
            else column--;
        }
        return false;
    }
}
