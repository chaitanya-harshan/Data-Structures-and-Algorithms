
/**
 * _04_house_robber_I
 */
public class _04_house_robber_I {

    public int rob(int[] nums) {
        int n = nums.length;
        int nxt = 0, nNxt = 0;
        int cur = 0;

        for (int i = n - 1; i >= 0; i--) {
            int noSkip = nums[i] + nNxt;
            int skip = nxt;
            cur = Math.max(skip, noSkip);

            nNxt = nxt;
            nxt = cur;
        }

        return cur;
    }

    // if (nums.length == 1) return nums[0];
    // if (nums.length == 2) return Math.max(nums[0], nums[1]);
    // int prev = nums[0];
    // int current = Math.max(prev, nums[1]);
    // int prev = 0, current = 0;
    // for (int i = 0; i<nums.length; i++) {
    //     int temp = current;
    //     current = Math.max(nums[i] + prev, temp);
    //     prev = temp;
    // }
    // return current;
}
}

/*
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/description/
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you 
from robbing each of them is that adjacent houses have security systems connected and 
it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 */
