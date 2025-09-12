package dp.subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _03_partition_into_two_sets_min_abs_diff {
    
    // Leetcode 2035: Partition Array Into Two Arrays to Minimize Sum Difference
    // The idea is to split nums into two groups of n/2 elements each, minimizing the absolute difference of their sums.
    // why? because else O(n) will exceed time limit
    // we basically split, generate subsets for each, then see if there exists a value in right such that the values in left + right is as close to total/2 as possible
    // we can take 0 from left and n from right, 1 from left and n-1 from right, 2 from left and n-2 from right and so on
    // for each value in left, we can do a binary search in right to find the closest value to total/2 - left_value
    // TC: O(2^(n/2) * log(2^(n/2))) = O(n * 2^(n/2))
    // SC: O(2^(n/2))

    // this is the actual problem (nums contains -ve numbers which is the complication)
    public int minimumDifference(int[] nums) {
        int l = nums.length;
        int n = l/2;
        List<Set<Integer>> left = generateSubsets(Arrays.copyOfRange(nums, 0, n));
        List<Set<Integer>> right = generateSubsets(Arrays.copyOfRange(nums, n, l));
        int total = Arrays.stream(nums).sum();
        int minDiff = Integer.MAX_VALUE;

        for (int k=0; k<=n; k++) {
            List<Integer> right_sorted = new ArrayList<>(right.get(n-k));
            Collections.sort(right_sorted);

            for (int left_num: left.get(k)) {
                int remainder = total/2 - left_num;
                int i = Collections.binarySearch(right_sorted, remainder);

                if (i < 0) i = -i -1;

                if (i < right_sorted.size()) {
                    int partition_sum = left_num + right_sorted.get(i);
                    minDiff = Math.min(minDiff, Math.abs(total - 2*partition_sum));
                }
                if (i-1 >= 0) {
                    int partition_sum = left_num + right_sorted.get(i-1);
                    minDiff = Math.min(minDiff, Math.abs(total - 2*partition_sum));
                }
            }
        }
        return minDiff;
    }

    List<Set<Integer>> generateSubsets(int[] nums) {
        int n = nums.length;
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new HashSet<>());
        }
        dp.get(0).add(0);

        for (int num: nums) {
            for (int k=n; k>0; k--) {
                for (int element: dp.get(k-1)) {
                    dp.get(k).add(element + num);
                }
            } 
        }
        return dp;
    }

    /*
     * URL: https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/description/

2035. Partition Array Into Two Arrays to Minimize Sum Difference

You are given an integer array nums of 2 * n integers. You need to partition nums into two arrays of length n to minimize the absolute difference of the sums of the arrays. To partition nums, put each element of nums into one of the two arrays.
Return the minimum possible absolute difference.

 
Example 1:
Input: nums = [3,9,7,3]
Output: 2
Explanation: One optimal partition is: [3,9] and [7,3].
The absolute difference between the sums of the arrays is abs((3 + 9) - (7 + 3)) = 2.
Example 2:
Input: nums = [-36,36]
Output: 72
Explanation: One optimal partition is: [-36] and [36].
The absolute difference between the sums of the arrays is abs((-36) - (36)) = 72.
Example 3:
Input: nums = [2,-1,0,4,-2,-9]
Output: 0
Explanation: One optimal partition is: [2,4,-9] and [-1,0,-2].
The absolute difference between the sums of the arrays is abs((2 + 4 + -9) - (-1 + 0 + -2)) = 0.

 
Constraints:

	1 <= n <= 15
	nums.length == 2 * n
	-107 <= nums[i] <= 107
     */






     
//_______________________________________________________________________________________________________________________________________________________________________


    // naukri problem---- easy cause nums contains only +ve numbers
    // https://www.naukri.com/code360/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494
    public static int minimumDifference1(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int n = nums.length;

        boolean[] prev = new boolean[total + 1];

        for (int i = n-1; i >= 0; i--) {
            boolean[] dp = new boolean[total + 1];
            int num = nums[i];

            for (int j=1; j<=total; j++) {
                if (j == num || prev[j]) {
                    dp[j] = true;
                } else if (j > num && prev[j - num]) {
                    dp[j] = true;
                } 
            }
            prev = dp;
        }

        int minDiff = Integer.MAX_VALUE;
        for (int k=0; k<=total; k++) {
            if (prev[k]) {
                minDiff = Math.min(minDiff, Math.abs(total - 2*k));
            }
        }
        return minDiff;
    }
}
