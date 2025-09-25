package arrays.medium.similar;

import java.util.Arrays;

// *********** TRICKY PROBLEM ***************************
public class _14_min_ops_to_reduce_X_to_0 {
    // this is a sliding window problem trying to find the max length of target = tot-x
    // to minimize the length given to get x.
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int tot = Arrays.stream(nums).sum();
        int target = tot - x;
        if (target < 0) return -1;
        
        int targetLength = -1;
        int l = 0;
        int sum = 0;
        for (int r=0; r<n; r++) {
            sum += nums[r];
            while(sum > target) {
                sum -= nums[l++];
            }
            if (sum == target) targetLength = Math.max(targetLength, r-l+1);
        }

        return targetLength == -1 ? -1 : n - targetLength;
    }
}

/*
 * URL: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/description/

1658. Minimum Operations to Reduce X to Zero

You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

 
Example 1:
Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:
Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:
Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.

 
Constraints:

	1 <= nums.length <= 105
	1 <= nums[i] <= 104
	1 <= x <= 109
 */