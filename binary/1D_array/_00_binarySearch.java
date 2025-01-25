package binary._1D_array;

public class _00_binarySearch {

    public static void main(String[] args) {
        
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    static int binarySearch(int[] nums,int low,int high,int target) {
        if (low > high) return -1;

        int mid = (low + high)/2;
        if (nums[mid] == target) return mid;
        else if (target > nums[mid]) return binarySearch(nums, mid+1, high, target);
        else return binarySearch(nums, low, mid-1, target);
    }
}
