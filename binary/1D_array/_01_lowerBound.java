package binary._1D_array;

public class _01_lowerBound {
    
    public static void main(String[] args) {
        int[] arr = {3, 5,7, 8,8,8, 15, 19};
        // int lowerBound = search(arr, 9);
        int lowerBound = lowerBoundindex(arr, 8);
        System.out.println(lowerBound);
        System.out.println(lowerBoundindex(arr, 6));
    }

    static int lowerBoundindex(int[] nums, int target) {
        int n = nums.length;
        // int index = n;
        int low = 0, high = n-1;

        // while (low <= high) {
        //     int mid = (low + high)/2;
        //     if (nums[mid] >= target) {
        //         index = mid;
        //         high = mid -1;
        //     }
        //     else low = mid+1;
        // }
        // return index;
        while (low <= high) {
            int mid = (low + high )>> 1;
            if (nums[mid] >= target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }


    static  int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    static int binarySearch(int[] nums,int low,int high,int target) {
        if (low > high) return nums.length;
        if (nums[high] < target) return high+1;
        if (nums[low] > target) return low;

        int mid = (low + high)/2;

        if (nums[mid] == target) {
            if ( nums[mid-1] != target) return mid;
            else return binarySearch(nums, low, mid-1, target);
        }
        else if (target > nums[mid]) return binarySearch(nums, mid+1, high, target);
        else return binarySearch(nums, low, mid-1, target);
    }
}
