package arrays.sde.Arrays_2;

public class _04_find_duplicate {
    
    public int findDuplicate(int[] nums) {
        // thinking the values as pointers
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow != fast);
        slow = 0;
        // when both are pointing to the same index then it stops, as it means both are same
        // slow, fast = 2 for eg 1
        // when slow & fast fall on both the duplicate & Original element only then 
        // they both can refer to the same element
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}

// LL loop method.  keywords to help remember: tortioise rabbit

// https://leetcode.com/problems/find-the-duplicate-number/

/*
 * 87. Find the Duplicate Number
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Input: nums = [1,3,4,2,2]
Output: 2

Input: nums = [3,1,3,4,2]
Output: 3

Input: nums = [3,3,3,3,3]
Output: 3
 */
