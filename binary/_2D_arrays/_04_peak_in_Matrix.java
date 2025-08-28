package binary._2D_arrays;

/**
 * _04_peak_in_Matrix
 */
public class _04_peak_in_Matrix {

    public static int[] findPeakGrid(int[][] mat) {
        // first remember the findPeak Element in 1D array
        // then apply binary search on columns
        int low = 0, high = mat[0].length - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            int row = findPeak(mat, mid);

            int left = (mid-1 >= 0) ? mat[row][mid-1] : -1;
            int right = (mid+1 < mat[0].length) ? mat[row][mid+1] : -1;
            
            int element = mat[row][mid];
            if (element > left && element > right) {
                return new int[] {row,mid};
            }
            else if (left > element) high = mid - 1;
            else low = mid + 1;
        }
        return new int[] {-1,-1};
    }

    static int findPeak(int[][] mat, int col) {
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i<mat.length; i++) {
            if (mat[i][col] > max) {
                max = mat[i][col];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

/*
 * URL: https://leetcode.com/problems/find-a-peak-element-ii/description/

1901. Find a Peak Element II

A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

 
Example 1:
Input: mat = [[1,4],[3,2]]
Output: [0,1]
Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
Example 2:
Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
Output: [1,1]
Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.

 
Constraints:

	m == mat.length
	n == mat[i].length
	1 <= m, n <= 500
	1 <= mat[i][j] <= 105
	No two adjacent cells are equal.
 */