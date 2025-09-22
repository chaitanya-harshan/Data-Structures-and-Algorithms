package arrays.medium.similar;

public class _07_wiggle_subsequence {
    // if [a,b,c,d] & b<a  c<b [d>c but d<b]
    // you couldn't find c > b so you go next and u check for d and d_prev which is c.
    // you don't need to check d with b.
    // then it just means you're taking aDcUd instead of aDb...

    // greedy
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;

        int i = 1;
        // skipping the == elements in the begining so that we don't have a prevDiff == 0
        while (i<n && nums[i] == nums[i-1]) i++;
        if (i == n) return 1;
        int prevDiff = nums[i] - nums[i-1];

        int wiggle = 2;
        // counting the number of alternations
        for (int j=i+1; j<n; j++) {
            int diff = nums[j] - nums[j-1];
            if ((prevDiff > 0 && diff < 0) || (prevDiff < 0 && diff > 0)) {
                wiggle++;
                prevDiff = diff;
            }
        }
        return wiggle;
    }

    // this is 1D dp with dependency on the immediate previous neighbour only
    public int wiggleMaxLength_DP(int[] nums) {
        int n = nums.length;
        int P = 1;
        int N = 1;
        boolean pos = true;
        boolean neg = true;
        // int pi = 0, ni = 0;

        for (int i=1; i<n; i++) {
            if ((pos && nums[i] > nums[i-1]) || (!pos && nums[i] < nums[i-1])) {
                P++;
                pos = !pos;
                // pi = i;
            }
            if ((neg && nums[i] < nums[i-1]) || (!neg && nums[i] > nums[i-1])) {
                N++;
                neg = !neg;
                // ni = i;
            }
        }
        return Math.max(P, N);
    }
}

/*
 * URL: https://leetcode.com/problems/wiggle-subsequence/description/

376. Wiggle Subsequence

A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.
For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) alternate between positive and negative.
In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences. The first is not because its first two differences are positive, and the second is not because its last difference is zero.
A subsequence is obtained by deleting some elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.
Given an integer array nums, return the length of the longest wiggle subsequence of nums.

 
Example 1:
Input: nums = [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence with differences (6, -3, 5, -7, 3).
Example 2:
Input: nums = [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length.
One is [1, 17, 10, 13, 10, 16, 8] with differences (16, -7, 3, -3, 6, -8).
Example 3:
Input: nums = [1,2,3,4,5,6,7,8,9]
Output: 2

 
Constraints:

	1 <= nums.length <= 1000
	0 <= nums[i] <= 1000
	Follow up: Could you solve this in O(n) time?
 */