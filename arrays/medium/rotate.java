package arrays.medium;

import java.util.Arrays;

public class rotate {
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        // rotateMatrix(matrix);
        rotate1(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

    }

    // better method
    static void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for (int[] row : matrix) {
            for (int i = 0; i < row.length/2; i++) {
                int temp = row[i];
                row[i] = row[row.length-1-i];
                row[row.length-1-i] = temp;
            }
        }
    }

    // takes too much time thinking about it for the finding the indexes
    static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i < n/2; i++) {
            for (int j=i; j < n-1-i; j++) {

                int temp = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = temp;
            }
        }
    }

}

//                     (i,j)

//                 #  #  #  #  #
//                 #  #  #  #  #    (j, n-1-i)
//   (n-1-j, i)    #  #  #  #  #
//                 #  #  #  #  #
//                 #  #  #  #  #

//                 (n-1-i, n-1-j)