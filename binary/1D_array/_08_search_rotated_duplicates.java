package binary._1D_array;

public class _08_search_rotated_duplicates {
    
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] == target) return true;
            
            // for edge case- [3, 1, 2 , 3, 3, 3, 3]
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) high = mid -1;
                else low = mid +1;
            }
            else {
                if (target >= nums[mid] && target <= nums[high]) low = mid + 1;
                else high = mid -1;
            }
        }
        return false;
    }
}
