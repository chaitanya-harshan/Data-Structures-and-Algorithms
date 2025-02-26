package dp.subsequences;

import java.util.Arrays;
import java.util.HashSet;

public class _02_can_partition_equal_subset_sum {

    // **** This is same as the subset sum with target with sum/2 (1st problem in dp>subsequences)
    // this process is much simpler without having to create a 2d dp of [nums.length][target+1]
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        // int[] nums = {3, 34, 4, 12, 5, 2};
        System.out.println(canPartition(nums));
    }
    
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int target = sum/2;

        HashSet<Integer> dp = new HashSet<>();
        dp.add(0);
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> tempdp = new HashSet<>(dp);
            for (Integer it : tempdp) {
                if (it + nums[i] == target) return true; 
                dp.add(it + nums[i]);
            }
        }
        return false;
    }
}

/*
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 */