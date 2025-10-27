/*
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _13_spiralMatrix {
    public static void main(String[] args) {
        // int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        // int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        System.out.println(spiralOrder(matrix));
    }

    public static  List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0;
        int left = 0;
        int bottom = matrix.length-1;
        int right = matrix[0].length-1;

        while (top <= bottom && left <= right) {
            for ( int j=left; j<= right; j++) {
                list.add(matrix[top][j]);
            }
            top++;
            if (top > bottom) break; // for when end is reached the while loop should stop else the 3rd loop will print 6 again
            // once top exceeds bottom it means end and it shouln't go further

            for (int i=top; i<= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if(right < left) break; // similarlay as above one right crosses left it should end.
            
            for (int j=right; j >= left; j--) {
                list.add(matrix[bottom][j]);
            }
            bottom--;

            // System.out.println(bottom+" "+left);
            for (int i=bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}

/*
 * URL: https://leetcode.com/problems/spiral-matrix/description/

54. Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.

 
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 
Constraints:

	m == matrix.length
	n == matrix[i].length
	1 <= m, n <= 10
	-100 <= matrix[i][j] <= 100
 */