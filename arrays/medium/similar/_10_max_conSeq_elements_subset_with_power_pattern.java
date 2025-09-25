package arrays.medium.similar;

import java.util.HashMap;

public class _10_max_conSeq_elements_subset_with_power_pattern {
    // I used dp to optimize a little but you don't need to at all
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int i: nums) f.put(i, f.getOrDefault(i, 0) + 1);

        int max = 1;
        int ones = f.getOrDefault(1,0);
        if (ones % 2 == 1) max = ones;
        else max = (ones-1 > 0) ? ones-1 : 1;

        HashMap<Integer, Integer> dp = new HashMap<>();

        for (int key: f.keySet()) {
            if (key == 1) continue;
            if (dp.containsKey(key)) {
                max = Math.max(max, dp.get(key));
                continue;
            }

            int num = key;
            int curLen = 0;

            while (num <= 1_000_000_000 && f.containsKey(num)) {
                int freq = f.get(num);
                if (freq >= 2) curLen += 2;
                else {
                    curLen += 1;
                    break;
                }
                num *= num;
            }
            // case where we didn't find the next element so we broke from the while loop, so we 
            // haven't gotten the middle (cnt = 1) element so our length is even as of now in this case
            if (curLen % 2 == 0) curLen--;
            dp.put(key, curLen);

            max = Math.max(max, curLen);
        }
        return max;
    }
}

/*
 * URL: https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/description/

3020. Find the Maximum Number of Elements in Subset

You are given an array of positive integers nums.
You need to select a  of nums which satisfies the following condition:
You can place the selected elements in a 0-indexed array such that it follows the pattern: [x, x2, x4, ..., xk/2, xk, xk/2, ..., x4, x2, x] (Note that k can be be any non-negative power of 2). For example, [2, 4, 16, 4, 2] and [3, 9, 3] follow the pattern while [2, 4, 8, 4, 2] does not.
Return the maximum number of elements in a subset that satisfies these conditions.

 
Example 1:
Input: nums = [5,4,1,2,2]
Output: 3
Explanation: We can select the subset {4,2,2}, which can be placed in the array as [2,4,2] which follows the pattern and 22 == 4. Hence the answer is 3.
Example 2:
Input: nums = [1,3,2,4]
Output: 1
Explanation: We can select the subset {1}, which can be placed in the array as [1] which follows the pattern. Hence the answer is 1. Note that we could have also selected the subsets {2}, {3}, or {4}, there may be multiple subsets which provide the same answer.

 
Constraints:

	2 <= nums.length <= 105
	1 <= nums[i] <= 109
 */