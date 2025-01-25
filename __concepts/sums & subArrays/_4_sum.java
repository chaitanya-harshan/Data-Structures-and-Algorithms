package arrays.sums & subArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// first need to know 2 sum II and 3 sum.
public class _4_sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int k = 4;
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<nums.length-(k-1); i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;

            for (int j=i+1; j<nums.length-(k-2); j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;

                int l = j+1; // low
                int h = nums.length-1; // high
                while (l < h) {
                    // either here or down in last else block where (sum == target)
                    // if (l > j+1 && nums[l] == nums[l-1]) {
                    //     l++;
                    //     continue;
                    // }

                    // since first we are adding all the nums and then putting it to sum, they might overflow 
                    // incase adding 2 nums will itself overflow
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[l] + (long)nums[h];
                    if (sum > target) h--; // target will automatically typecasted to long
                    else if (sum < target) l++;
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[h]) );
                        l++;
                        while (l < h && nums[l] == nums[l-1]) l++;
                    }
                }
            }
        }
        return result;

        // ******---GENERALIZED SOLUTION-----********

        // Arrays.sort(nums);
        // List<List<Integer>> result = new ArrayList<>();
        // ksum(result, new ArrayList<>(), nums, 4, 0, (long)target);
        // return result;
    }

    // using long for nums[i] and target 
    static void ksum(List<List<Integer>> result, List<Integer> quad, int[] nums, int k, int start, long target) {
        if (k == 2) {
            int low = start;
            int high = nums.length-1;

            while (low < high) {
                long twoSum = (long)nums[low] + (long)nums[high];
                if (twoSum < target) low++;
                else if (twoSum > target) high--;
                else {
                    quad.add(nums[low]);
                    quad.add(nums[high]);
                    result.add(new ArrayList<>(quad));
                    quad.removeLast();
                    quad.removeLast();
                    low++;
                    while (low < high && nums[low] == nums[low-1]) low++;
                }
            }
            return;
        }

        for (int i=start; i<nums.length-(k-1); i++) {
            if (i > start && nums[i] == nums[i-1]) continue; // not i>0 or i != 0. we need i != start and i > start
            quad.add(nums[i]);
            ksum(result, quad, nums, k-1, i+1, target-nums[i]);
            quad.removeLast();
        }
    }
}


/*
 * 8. 4Sum
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */