package two_pointers.medium;

import java.util.HashMap;

public class _06_count_nice_subArr__k_odd_nums {

    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0, odd = 0;

        for (int i : nums) {
            odd += i % 2;
            if (odd == k) cnt++;
            if (map.containsKey(odd - k)) cnt += map.get(odd-k);
            map.put(odd, map.getOrDefault(odd,0) + 1);
        }
        return cnt;
    }


    public int numberOfSubarrays1(int[] nums, int k) {
        return subArrLessOrEqual(nums, k) - subArrLessOrEqual(nums, k-1);
    }

    private int subArrLessOrEqual(int[] nums, int k) {
        int l = 0;
        int cnt = 0, odd = 0;

        for (int r=0; r<nums.length; r++) {
            odd += nums[r] % 2;

            while (l < r && odd > k) {
                odd -= nums[l++] % 2;
            }

            if (odd <= k) cnt += r-l+1;
        }
        return cnt;
    }
}

/*
https://leetcode.com/problems/count-number-of-nice-subarrays/description/ 
 * 1248. Count Number of Nice Subarrays
Given an array of integers nums and an integer k. A continuous subarray is called nice if there 
are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 

Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
 */