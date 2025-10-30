package two_pointers_sliding_window.medium;

// similar to that weird string problem

import java.util.HashMap;

public class _05_binary_subArr_with_sum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0, sum = 0;

        for (int i : nums) {
            sum += i;
            if (sum == goal) cnt++;
            if (map.containsKey(sum - goal)) cnt += map.get(sum-goal);
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return cnt;
    }

    public int numSubarraysWithSum1(int[] nums, int goal) {
        return subArrSumLessOrEqual(nums, goal) - subArrSumLessOrEqual(nums, goal-1);
    }

    private int subArrSumLessOrEqual(int[] nums, int goal) {
        int sum = 0, cnt = 0;
        int l = 0;

        for (int r=0; r<nums.length; r++) {
            sum += nums[r];

            while (l < r && sum > goal) {
                sum -= nums[l++];
            }

            if (sum <= goal) cnt += r-l+1;
        }
        return cnt;
    }
}

/*
https://leetcode.com/problems/binary-subarrays-with-sum/description/
https://www.youtube.com/watch?v=XnMdNUkX6VM - striver explains better
 * 930. Binary Subarrays With Sum
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length
 */