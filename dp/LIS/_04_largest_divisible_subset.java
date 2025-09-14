package dp.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _04_largest_divisible_subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        // Step 1: Sort the array. This is crucial for the logic. 
        // As it removes the burden to decide a%b or b%a
        Arrays.sort(nums);

        // --- FIRST PASS: Calculate lengths and store path (Right-to-Left) ---
        // Similar to LIS, but here we check divisibility instead of increasing order.


        // dp[i] - size of the largest divisible subset STARTING with nums[i].
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // next_index[i] stores the index of the next element in the largest divisible
        // subset that starts at i. This is equivalent to your 'nxt' array in LIS.
        int[] next_index = new int[n];
        Arrays.fill(next_index, -1);

        // Variables to track the start of the overall largest subset found so far.
        int max_size = 1;
        int start_index = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // If nums[j] is divisible by nums[i], it can be the next element
                // in a subset starting with nums[i].
                if (nums[j] % nums[i] == 0) {
                    if (1 + dp[j] > dp[i]) {
                        dp[i] = 1 + dp[j];  
                        next_index[i] = j;  
                        // Record the path: the element after i is at index j.
                    }
                }
            }
            // update our trackers for bigger length subset found.
            if (dp[i] > max_size) {
                max_size = dp[i];
                start_index = i;
            }
        }

        // --- SECOND PASS: Reconstruct the result from the path ---

        List<Integer> result = new ArrayList<>();
        int i = start_index; // Start from the beginning of the longest subset.

        // Backtrack using the next_index path until we reach the end (-1).
        while (i != -1) {
            result.add(nums[i]);
            i = next_index[i]; // Move to the next element in the recorded path.
        }
        return result;
    }

    public List<Integer> largestDivisibleSubset1(int[] nums) {
        Arrays.sort(nums); // removes the burden to decide a%b or b%a
        int n = nums.length;

        List<Integer>[] dp = new ArrayList[n];
        int maxSubsetSize = 1;
        int max_ss_idx = 0;

        for (int i=n-1; i>=0; i--) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);

            int max = 1, maxIdx = -1;
            for (int j=i+1; j<n; j++) {
                if (nums[j] % nums[i] == 0) {
                    if (1+dp[j].size() > max) {
                        max = 1+dp[j].size();
                        maxIdx = j;
                    }
                }
            }
            if (maxIdx != -1) list.addAll(dp[maxIdx]);
            dp[i] = list;
            if (dp[i].size() > maxSubsetSize) {
                maxSubsetSize = dp[i].size();
                max_ss_idx = i;
            }
        }
        return dp[max_ss_idx];
    }
}

/*
 * URL: https://leetcode.com/problems/largest-divisible-subset/description/

368. Largest Divisible Subset

Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 
Example 1:
Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:
Input: nums = [1,2,4,8]
Output: [1,2,4,8]

 
Constraints:

	1 <= nums.length <= 1000
	1 <= nums[i] <= 2 * 109
	All the integers in nums are unique.
 */