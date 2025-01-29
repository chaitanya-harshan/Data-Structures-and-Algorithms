package binary._1D_array;

public class _03_searchInsertPos {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        // int index = search(arr, 9);
        int index = searchInsert(arr, 9);
        System.out.println(index);

        System.out.println(searchInsertbad(new int[]{1,2}, 0));
    }

    // better way
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;
        int index = n;
        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] >= target) {
                index = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return index;
    }

    public static int searchInsertbad(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid+1;
            else high = mid-1;
        }
        if (nums[mid] < target) return mid+1;
        else return mid;
    }
}
