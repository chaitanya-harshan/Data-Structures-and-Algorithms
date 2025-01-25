package arrays.sums & subArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;

            int low = i+1, high = nums.length-1;

            while (low < high) { // low != high casue they need to represent diff nums and we can't use same num twice
                int sum = nums[i] + nums[low] + nums[high];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    // low shouldnt cross high becasue we know above high the sum will always be higher 
                    // as this is a sorted array. we can use (low < nums.length-1 && ) to make sure it's in bounds
                    // but using low < high is more eff casue like explained above we dont need to check beyond high
                    // low != high because we can use same num twice
                    while (low < high && nums[low] == nums [low-1]) low++;
                } 
                else if (sum > 0) high--;
                else low++;
            }
        }
        return result;
    }
}

/*
https://www.youtube.com/watch?v=jzZsG8n2R9A neetcode
 * 5. 3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */