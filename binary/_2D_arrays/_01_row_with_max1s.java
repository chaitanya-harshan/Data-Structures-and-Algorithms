package binary._2D_arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class _01_row_with_max1s {

    public int rowWithMax1s(int mat[][]) {
        int n = mat.length, m = mat[0].length;

        int idx = -1, max = 0;
        for (int i=0; i<n; i++) {
           int l = 0, h = m-1;
           while (l <= h) {
                int mid = l+h >> 1;
                if (mat[i][mid] < 1) l = mid+1;
                else h = mid-1;
           }
           if (m-l > max) {
            max = m-l;
            idx = i;
           }
        }
        return idx;
    }

    // naukri
    // public static int rowMaxOnes(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
    //     int rowIndex = -1;
    //     int maxOnes = 0;
    //     for (int i = 0; i < n; i++) {
    //         int ones = m - lowerBound(matrix.get(i), m);
    //         if (ones > maxOnes) {
    //             maxOnes = ones;
    //             rowIndex = i;
    //         }
    //     }
    //     return rowIndex;
    // }

    // static int lowerBound(ArrayList<Integer> row, int n) {
    //     int low = 0;
    //     int high = n-1;
    //     while (low <= high) {
    //         int mid = (low + high)/2;
    //         if (row.get(mid) == 1) high = mid - 1;
    //         else low = mid + 1;
    //     }
    //     return low;
    // }
}

/* (naukri problem has a issue with this problem)
https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1

 * Row with max 1s
You are given a 2D binary array arr[][] consisting of only 1s and 0s. Each row of the array is sorted in non-decreasing order. Your task is to find and return the index of the first row that contains the maximum number of 1s. If no such row exists, return -1.

Note:

The array follows 0-based indexing.
The number of rows and columns in the array are denoted by n and m respectively.
Examples:

Input: arr[][] = [[0,1,1,1], [0,0,1,1], [1,1,1,1], [0,0,0,0]]
Output: 2
Explanation: Row 2 contains the most number of 1s (4 1s). Hence, the output is 2.
Input: arr[][] = [[0,0], [1,1]]
Output: 1
Explanation: Row 1 contains the most number of 1s (2 1s). Hence, the output is 1.
Input: arr[][] = [[0,0], [0,0]]
Output: -1
Explanation: No row contains any 1s, so the output is -1.
Constraints:
1 ≤ arr.size(), arr[i].size() ≤ 103
0 ≤ arr[i][j] ≤ 1 
 */