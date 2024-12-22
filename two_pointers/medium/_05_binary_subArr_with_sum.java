package two_pointers_sliding_window.medium;

// similar to that weird string problem
public class _05_binary_subArr_with_sum {

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0};
        System.out.println(numSubarraysWithSum(nums, 0));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return subArrSumLessOrEqThan(nums, goal) - subArrSumLessOrEqThan(nums, goal-1);
    }

    static int subArrSumLessOrEqThan(int[] nums, int goal) {
        if (goal < 0) return 0;
        int l = 0;
        int cnt = 0;
        int sum = 0;

        for (int r=0; r<nums.length; r++) {
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
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