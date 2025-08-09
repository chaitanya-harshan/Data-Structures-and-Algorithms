package arrays.sde.Arrays_2;

/**
 * 8. Rotate Image
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 
 */

 // Procedure:-    Transpose the whole nxn & then reverse every row
public class _01_rotate_matrix {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose
        for (int i=0; i< n; i++) {
            for (int j = i; j< n; j++) {
                swap(matrix, i,j, j,i);
            }
        }
        // reverse
        for (int i=0; i<n; i++) {
            for (int j=0; j<n/2; j++) {
                swap(matrix, i,j, i,n-1-j);
            }
        }
    }

    static void swap(int[][] matrix, int a, int b, int x, int y) {
        int temp = matrix[a][b];
        matrix[a][b] = matrix[x][y];
        matrix[x][y] = temp;
    }
}