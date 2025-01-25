package binary._1D_array;

public class _02_upperBound {
    
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9,9,9,15, 19};
        // int upperBound = search(arr, 9);
        int upperBound = upperBoundindex(arr, 9);
        System.out.println(_01_lowerBound.lowerBoundindex(arr, 9));
        System.out.println(upperBound);
        System.out.println(upperBoundindex(arr, 10));
    }

    static int upperBoundindex(int[] nums, int target) {
        int n = nums.length;
        int index = n;
        int low = 0, high = n-1;

        while (low <= high) {
            int mid = (low + high)/2;
            // if (nums[mid] > target) {
            //     index = mid;
            //     high = mid -1;
            // }
            // else low = mid+1;
            if (nums[mid] <= target) low = mid+1;
            else high = mid-1;
        }
        // return index;
        return low;
    }
}
