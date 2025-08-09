package arrays.sde.Arrays_3;

public class __search_2d_arr_II {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        // starting from [0,m] and going down and left
        // if num > targ -> (col--) as the whole cols right of it & rows below are > targ including the curr col & row 
        // if num < targ -> (row++) as the cols left & rows above are < targ including current ones
        int row = 0; 
        int col = m-1;

        while (row < n && col >= 0) {
            int num = matrix[row][col];
            if (num == target) return true;
            else if (num > target) col--;
            else row++;
        }
        return false;
    }
}

/*
https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 * 240. Search a 2D Matrix II
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

1   4   7   11  15   ---> increasing
2   5   8   12  19      |
3   6   9   16  22      |
10  13  14  17  24      v increasing
18  21  23  26  30
 
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false


 */