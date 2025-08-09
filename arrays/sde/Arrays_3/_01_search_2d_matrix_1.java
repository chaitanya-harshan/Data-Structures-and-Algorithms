package arrays.sde.Arrays_3;

public class _01_search_2d_matrix_1 {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = m*n - 1;
        while (low <= high) {
            int mid = (low+high) >> 1;
            int num = matrix[mid/n][mid % n];
            if (num == target) return true;
            else if (num > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}

/*
https://leetcode.com/problems/search-a-2d-matrix/description/
 * 74. Search a 2D Matrix
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

1   3    5   7
10  11  16  20
23  30  34  60

we can write it as [1,3,5,7,   10,11,16,20,   23,30,34,60] and still be sorted. and do a 
1d binary search.

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 */
