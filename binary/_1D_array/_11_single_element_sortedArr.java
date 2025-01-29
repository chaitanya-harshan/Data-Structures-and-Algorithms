package binary._1D_array;

public class _11_single_element_sortedArr {
    
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (nums[1] != nums[0]) return nums[0];
        if (nums[n-2] != nums[n-1]) return nums[n-1];

        int low = 1, high = n-2;
        while (low <= high) {
            int mid = (low+high)/2;
            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }
            else if ((mid%2 == 0 && nums[mid] == nums[mid+1]) ||
            (mid % 2 == 1 && nums[mid-1] == nums[mid])) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return -1;
    }
}
