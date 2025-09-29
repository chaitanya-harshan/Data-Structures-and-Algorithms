package arrays.medium.similar;

public class _04_kadanes_for_circular_arr {
    //The total_sum is simply the sum of all elements in the array.
    // The sum of the wrapped subarray is total_sum - (sum of the excluded middle part).
    // To maximize the wrapped sum, you must subtract the smallest possible sum from the total sum.
    // The smallest possible sum for any contiguous subarray is, by definition, the min_subarray_sum.
    // Therefore, the maximum wrapped sum is equal to total_sum - min_subarray_sum
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = 0, minSum = 0;
        // ____________________________________________________________________________________
        // int globalMax = Integer.MAX_VALUE;
        int globalMax = nums[0]; // explanation for max below but same for min also
        // for case where all are -ve, we can't choose empty subArr
        // so we can't say max = 0 because that would make max = 0 which is not true.
        // max should be the least -ve number
        // -- if nums[0] is '0' then even if the rest are -ve we would still have a subArr [0] 
        // ---------------------------------------------------------------------
        // int globalMin = Integer.MAX_VALUE;
        int globalMin = nums[0];
        // ____________________________________________________________________________________
        int tot = 0;

        for (int i=0; i<nums.length; i++) {
            tot += nums[i];
            // max SubArr sum --- (least -ve if all are -ve)
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            globalMax = Math.max(globalMax, maxSum);
            // min SubArr sum 
            minSum = Math.min(minSum + nums[i], nums[i]);
            globalMin = Math.min(globalMin, minSum);
        }
        
        // Edge Case: If all numbers are negative, the min subarray is the whole array.
        // In this case, `totalSum - globalMin` would be 0. 
        // The answer must be the largest of the negative numbers (`globalMax`).
        if (tot == globalMin) {
            return globalMax;
        }

        // The answer is the larger of the two cases:
        // 1. The standard max subarray sum (globalMax)
        // 2. The wrapped subarray sum (totalSum - globalMin)
        return Math.max(globalMax, tot - globalMin);
    }
}

/*
 * URL: https://leetcode.com/problems/maximum-sum-circular-subarray/description/

918. Maximum Sum Circular Subarray

Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

 
Example 1:
Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:
Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:
Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.

 
Constraints:

	n == nums.length
	1 <= n <= 3 * 104
	-3 * 104 <= nums[i] <= 3 * 104
 */