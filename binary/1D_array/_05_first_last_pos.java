package binary._1D_array;

import java.util.Arrays;

public class _05_first_last_pos {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int[] ans = searchRange(arr, 4);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(BettersearchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(BettersearchRange(new int[]{1,1,1,2,2,3,3}, 3)));
    }


    //  BETTER VERSION using direct binary search instead of lower Bound, upper Bound
    public static int[] BettersearchRange(int[] nums, int target) {
        int fp = firstIndex(nums, target);
        // int lp = lastIndex(nums, target); // calling it hear will not decrese the O(n) to log(n) 
        // when target doesnt exist as it will call last index function also when it doesn't have to

        if (fp == -1){
            return new int[]{-1,-1};
        }
        else return new int[]{fp, lastIndex(nums, target)};
    }

    static int firstIndex(int[] nums, int target) {
        int n = nums.length;
        int first = -1;
        int low = 0, high = n-1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] == target) {
                high = mid-1;
                first = mid;
            }
            else if (nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return first;
    }

    static int lastIndex(int[] nums, int target) {
        int n = nums.length;
        int last = -1;
        int low = 0, high = n-1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] == target) {
                low = mid+1;
                last = mid;
            }
            else if (nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return last;
    }


    // using lower Bound & upper Bound
    public static int[] searchRange(int[] nums, int target) {
        int fp = lowerBoundindex(nums, target);
        int lp = upperBoundindex(nums, target);

        if (fp == nums.length || nums[fp] != target){
            return new int[]{-1,-1};
        }
        else return new int[]{fp, lp-1};
    }

    static int lowerBoundindex(int[] nums, int target) {
        int n = nums.length;
        int index = n;
        int low = 0, high = n-1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] >= target) {
                index = mid;
                high = mid -1;
            }
            else low = mid+1;
        }
        return index;
    }

    static int upperBoundindex(int[] nums, int target) {
        int n = nums.length;
        int index = n;
        int low = 0, high = n-1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] > target) {
                index = mid;
                high = mid -1;
            }
            else low = mid+1;
        }
        return index;
    }
}
