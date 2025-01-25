package binary._1D_array;

import java.util.Arrays;

public class _04_floor_ceil {

    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int[] arr1 = {3,4,4,7,8,10};
        int[] ans = getFloorAndCeil(arr, arr.length, 2);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] getFloorAndCeil(int[] nums, int n, int x) {
        int[] ans = new int[2];
        ans[0] = getFloor(nums, n, x);
        ans[1] = getCeil(nums, n, x);
        return ans;
    }

    public static int getFloor(int[] nums, int n, int x) {
        int floor = -1;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= x) {
                floor = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return floor;
    }

    public static int getCeil(int[] nums, int n, int x) {
        int ceil = -1;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= x) {
                ceil = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ceil;
    }
}
