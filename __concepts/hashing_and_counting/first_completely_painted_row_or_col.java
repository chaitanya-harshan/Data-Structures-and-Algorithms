package _concepts.hashing_and_counting;

public class first_completely_painted_row_or_col {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];

        int[][] position = new int[n*m + 1][2];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int element_idx = mat[i][j];
                position[element_idx][0] = i;
                position[element_idx][1] = j;
            }
        }

        for (int i=0; i<arr.length; i++) {
            int row_idx = position[arr[i]][0];
            rows[row_idx]++;
            if (rows[row_idx] == n) return i;

            int col_idx = position[arr[i]][1];
            cols[col_idx]++;
            if (cols[col_idx] == m) return i;
        }
        return -1;
    }
}

/*
 * 2661. First Completely Painted Row or Column
https://leetcode.com/problems/first-completely-painted-row-or-column/description/

You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n].

Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].

Return the smallest index i at which either a row or a column will be completely painted in mat.

 

Example 1:

image explanation for example 1
Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
Output: 2
Explanation: The moves are shown in order, and both the first row and second column of the matrix become fully painted at arr[2].
Example 2:

image explanation for example 2
Input: arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
Output: 3
Explanation: The second column becomes fully painted at arr[3].
 

Constraints:

m == mat.length
n = mat[i].length
arr.length == m * n
1 <= m, n <= 105
1 <= m * n <= 105
1 <= arr[i], mat[r][c] <= m * n
All the integers of arr are unique.
All the integers of mat are unique.
 */