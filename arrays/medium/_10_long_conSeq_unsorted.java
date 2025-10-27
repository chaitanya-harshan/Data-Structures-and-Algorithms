package arrays.medium;

import java.util.HashSet;

public class _10_long_conSeq_unsorted {
    
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i: nums) set.add(i);

        int max = 0;
        for (int i: set) { // use set cause nums has duplicates .... Test cases were updated
            if (!set.contains(i-1)) {
                int cnt = 0;
                while (set.contains(i+cnt)) cnt++;
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}

/*
 * 128. Longest Consecutive Sequence
https://leetcode.com/problems/longest-consecutive-sequence/description/

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */