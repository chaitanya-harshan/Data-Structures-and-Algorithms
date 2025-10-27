// Given an integer array arr, find the contiguous subarray (containing at least one number) which
// has the largest sum and returns its sum and prints the subarray.

package arrays.medium;

public class _05_Print_maxSubArr {
    public static void main(String[] args) {
        int[] arr = {2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

    static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE; // or nums[0]
        int l = 0, r = 1; //??? shouldnt r = 0

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) l = i;

            sum += nums[i];

            if (sum > max) {
                max = sum;
                r = i;
            }
            if (sum < 0) sum = 0;
        }
        for (int i = l; i <= r; i++) {
            System.out.print(nums[i]+" ");
        }
        return max;
    }
}

/*Given an integer array nums, find the subarray
 with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6. */