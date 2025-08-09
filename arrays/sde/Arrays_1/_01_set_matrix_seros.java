package arrays.sde.Arrays_1;

public class _01_set_matrix_seros {
    
    public void setZeroes(int[][] matrix) {

        int col = 1;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) matrix[0][j] = 0;
                    else col = 0;
                }
            }
        }
        for (int j = 1; j<matrix[0].length; j++) {
            // if (j == 0) continue;
            if (matrix[0][j] == 0) {
                for (int i = 0; i<matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i<matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j<matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (col == 0) {
            for (int i = 0; i<matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        return;
    }
}

/*
https://leetcode.com/problems/set-matrix-zeroes/description/

 * 73. Set Matrix Zeroes
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

i/p

1 1 1
1 0 1
1 1 1

o/p

1 0 1
0 0 0
1 0 1
*/