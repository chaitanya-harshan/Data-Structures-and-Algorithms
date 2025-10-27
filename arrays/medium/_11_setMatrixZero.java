package arrays.medium;

import java.util.Arrays;

public class _11_setMatrixZero {

    public static void main(String[] args) {
        // int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        
        int[][] arr1 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        // setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
        setZeroes(arr1);
        System.out.println(Arrays.deepToString(arr1));
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean colZero = false;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {

                    matrix[i][0] = 0;

                    if (j == 0) colZero = true;
                    else matrix[0][j] = 0;
                }
            }
        }


        for (int j=1; j<n; j++) {
            if (matrix[0][j] == 0) {
                for (int i=0; i<m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i=0; i<m; i++) 
            if (matrix[i][0] == 0) Arrays.fill(matrix[i], 0);
        
        if (colZero) 
            for (int i=0; i<m; i++) matrix[i][0] = 0;
    }
}


/*
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
 */