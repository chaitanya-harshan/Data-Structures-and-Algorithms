package binary._2D_arrays;

/**
 * _04_peak_in_Matrix
 */
public class _04_peak_in_Matrix {

    public static int[] findPeakGrid(int[][] mat) {
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