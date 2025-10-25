package arrays.easy;

public class _11_maxConsequitive1s {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 1) return nums[0];

        int maxCount = 0;
        if (nums[0] == 1) maxCount = 1;
        
        for (int i=1; i<nums.length; i++) {
            if (maxCount == 0 && nums[i] ==  1) maxCount = 1;

            int count = 0;
            while ( i<nums.length && nums[i] == 1 && nums[i-1] == nums[i]) {
                count++;
                i++;
                if (count+1 > maxCount) maxCount = count + 1;
            }
        }
        return maxCount;
    }


    // better way----------------------------------------------------------***************************

    public int findMaxConsecutiveOnes2(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) count++;
            else count = 0;

            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}

/*
 * URL: https://leetcode.com/problems/max-consecutive-ones/description/

485. Max Consecutive Ones

Given a binary array nums, return the maximum number of consecutive 1's in the array.

 
Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2

 
Constraints:

	1 <= nums.length <= 105
	nums[i] is either 0 or 1.
 */