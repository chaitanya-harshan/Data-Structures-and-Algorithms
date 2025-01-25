/*
 * You have been given a non-empty grid ‘mat’ with 'n' rows and 'm' columns consisting of only 0s and 1s. All the rows are sorted in ascending order.

Your task is to find the index of the row with the maximum number of ones.

Note: If two rows have the same number of ones, consider the one with a smaller index. If there's no row with at least 1 one, return -1.


 */

package binary._2D_arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class _01_row_with_max1s {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        // matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        // matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        // matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        int n = 3, m = 3;
        System.out.println("The row with the maximum number of 1's is: "+ rowMaxOnes(matrix, n, m));
    }

    public static int rowMaxOnes(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int rowIndex = -1;
        int maxOnes = 0;
        for (int i = 0; i < n; i++) {
            int ones = m - lowerBound(matrix.get(i), m);
            if (ones > maxOnes) {
                maxOnes = ones;
                rowIndex = i;
            }
        }
        return rowIndex;
    }

    static int lowerBound(ArrayList<Integer> row, int n) {
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (row.get(mid) == 1) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
