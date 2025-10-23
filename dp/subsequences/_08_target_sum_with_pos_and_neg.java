package dp.subsequences;

import java.util.Arrays;

public class _08_target_sum_with_pos_and_neg {
    // (?) Asked -> P-N = target
    // (=>) Given -> P+N = sum
    // 2P = target+sum
    // P = (target+sum)/2;
    // find number of way to get sum of P
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (Math.abs(target) > sum || (target+sum)%2 != 0) return 0;

        target = (sum + target) / 2;
        int[] prev = new int[target+1];
        prev[0] = 1;

        for (int i=n-1; i>=0; i--) {
            int[] dp = new int[target+1];
            int num = nums[i];

            for (int k=0; k<=target; k++) {
                int noTake = prev[k];
                int take = (num <= k) ? prev[k-num] : 0;
                dp[k] = take+noTake;
            }
            prev = dp;
        }
        return prev[target];
    }
}

/*
 * URL: https://leetcode.com/problems/target-sum/description/

494. Target Sum

You are given an integer array nums and an integer target.
You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer 
in nums and then concatenate all the integers.
For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build 
the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 
Example 1:
Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:
Input: nums = [1], target = 1
Output: 1

 
Constraints:

	1 <= nums.length <= 20
	0 <= nums[i] <= 1000
	0 <= sum(nums[i]) <= 1000
	-1000 <= target <= 1000
 */