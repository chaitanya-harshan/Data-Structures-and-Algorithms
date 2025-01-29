package binary._1D_array;

public class _09_min_in_rotated {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low+high)/2;
            // with distinct values only
            // if duplicates are there then use need to trim the low &end (low++,high--)continue
            if( nums[low] <= nums[high]){  // in <= '=' is for when [1] element 
                min = Math.min(min,nums[low]);
                break;
            }

            if (nums[low] <= nums[mid]) {
                min = Math.min(min, nums[low]);
                low = mid + 1;
            }
            else {
                min = Math.min(min,nums[mid]);
                high = mid-1;
            }
        }
        return min;
    }
}
