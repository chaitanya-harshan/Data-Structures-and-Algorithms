package arrays.medium;

public class _04_Kadanes_Algo__max_subArr_Sum {
    // ******* READ *************
    // Of course, Chaitanya. Here is a concise paragraph you can use for your code comments.
    // There are two common implementations of Kadane's algorithm. The primary difference lies 
    // in how they handle a running sum that becomes negative.
    // The "Reset to Zero" approach uses an if (sum < 0) sum = 0; check. For this method to 
    // work correctly with all-negative arrays, it has two critical dependencies: the global 
    // max must be initialized to Integer.MIN_VALUE, and the global max must be updated before
    // the sum is potentially reset. This order is crucial for capturing the least-negative value.

    // The "Extend or Start New" approach is more direct, using sum = Math.max(sum + i, i). 
    // This single line elegantly captures the core logic by deciding at each step whether 
    // it's better to extend the current subarray or to start a new one with the current element. 
    // It's often preferred as it's more intuitive and its logic isn't as dependent on the specific 
    // ordering of lines within the loop.

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0]; // for case where all are -ve, we can't choose empty subArr
        // so we can't say max = 0 because that would make max = 0 which is not true.
        // max should be the least -ve number
        // -- if nums[0] is '0' then even if the rest are -ve we would still have a subArr [0] 

        for (int i=0; i<nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i: nums) {
            sum += i;
            max = Math.max(sum, max);
            if (sum < 0) sum = 0;
        }
        return max;
    }
}

/*
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 * 
Given an integer array nums, find the 
subarray with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 */