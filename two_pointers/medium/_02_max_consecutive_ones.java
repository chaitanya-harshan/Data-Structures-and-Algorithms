package two_pointers.medium;

public class _02_max_consecutive_ones {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;

        int l = 0;
        for (int r=0; r<n; r++) {
            if (nums[r] == 0) {
                if (k > 0) k--;
                else {
                    while (nums[l] == 1) l++;
                    l++;
                    k++; // now u've got k
                    k--; // now u can use that k
                    // ∴ u can completely ignore k
                }
            }

            max = Math.max(max, r-l+1);
        }
        return max;
    }
}

/*
 * URL: https://leetcode.com/problems/max-consecutive-ones-iii/description/

1004. Max Consecutive Ones III

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 
Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

 
Constraints:

	1 <= nums.length <= 105
	nums[i] is either 0 or 1.
	0 <= k <= nums.length
 */