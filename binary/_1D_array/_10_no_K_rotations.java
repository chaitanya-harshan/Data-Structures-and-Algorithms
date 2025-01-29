package binary._1D_array;

/**
 * _10_K_rotations
 */
public class _10_no_K_rotations {

    public static void main(String[] args) {
        int[] arr1 = {4,5,6,7,1,2,3};
        // int[] arr1 = {11,13,15,17};
        int[] arr = {1};
        System.out.println(rotations(arr1));
    }

    static int rotations(int[] nums) {
        int low = 0, high = nums.length-1;
        int min = Integer.MAX_VALUE;
        int index = 0;

        while (low <= high) {
            int mid = (low+high)/2;
            if( nums[low] <= nums[high]){  // in <= '=' is for when [1] element 
                if (nums[low] < min) {
                    min = nums[low];
                    index = low;
                }
                break;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] < min) {
                    min = nums[low];
                    index = low;
                }
                low = mid + 1;
            }
            else {
                if (nums[mid] < min) {
                    min = nums[mid];
                    index = mid;
                }
                high = mid-1;
            }
        }
        return index;
    }
}
