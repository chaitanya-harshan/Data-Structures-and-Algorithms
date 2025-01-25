package binary._1D_array;

/**
 * _07_search_rotated
 */
public class _07_search_rotated {

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        while (low <= high) {
            int mid = (low+ high)/2;
            if (nums[mid] == target) return mid;
            else if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target <= nums[mid]) high = mid-1;
                else low = mid + 1;
            }
            else if (target >= nums[mid] && target <= nums[high]) low = mid +1;
            else high = mid - 1;
        }
        return -1;
    }
}