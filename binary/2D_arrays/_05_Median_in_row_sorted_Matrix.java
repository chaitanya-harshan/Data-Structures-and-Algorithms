package binary._2D_arrays;

public class _05_Median_in_row_sorted_Matrix {
    public static int findMedian(int matrix[][], int R, int C) {
        // Write your code here
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < R; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][C-1]);
        }

        int median = R*C/2;
        while (low <= high) {
            int mid = (low+high)/2;
            int numbersBefore_Inc_Mid = numbers(matrix, R, C, mid);
            if(numbersBefore_Inc_Mid <= median) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    static int numbers(int[][] matrix, int R, int C, int num) {
        int count = 0;
        for (int i = 0; i < R; i++) {
            count += upperBound(matrix[i], C, num);
        }
        return count;
    }

    static int upperBound(int[] row, int C, int num) {
        int low = 0, high = C-1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (row[mid] <= num) low = mid + 1;
            else high = mid - 1;
        }
    return low;
    }
}
