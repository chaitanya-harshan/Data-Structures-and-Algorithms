package arrays.medium.similar;

import java.util.HashMap;

public class _14_subArr_sum_cnt_divisible_by_K {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> reaminders = new HashMap<>();
        int sum = 0;
        int cnt = 0;

        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            // int r = sum < 0 ? (sum % k)+k : (sum % k); 
            // WRONG for case: s = -k -> r should be 0 but it'll become k;

            int r = (sum % k) < 0 ? (sum % k)+k : (sum % k);
            // int r = ((sum % k) + k) % k;       // above statement combined.

            if (r == 0) cnt++;
            if (reaminders.containsKey(r)) cnt += reaminders.get(r);
            reaminders.put(r, reaminders.getOrDefault(r,0) + 1);
        }
        return cnt;
    }
}

// 4 9 9 7 4 5
// 4 4 4 2 4 0
// 4-4 2-1
// 0 1 3 3 6 7

/*
 * URL: https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

974. Subarray Sums Divisible by K

Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
A subarray is a contiguous part of an array.

 
Example 1:
Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Example 2:
Input: nums = [5], k = 9
Output: 0

 
Constraints:

	1 <= nums.length <= 3 * 104
	-104 <= nums[i] <= 104
	2 <= k <= 104
 */