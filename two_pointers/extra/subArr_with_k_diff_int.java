package two_pointers_sliding_window.extra;

import java.util.HashMap;

public class subArr_with_k_diff_int {
    // 3 pointers
    // https://www.youtube.com/watch?v=etI6HqWVa8U
    public int subarraysWithKDistinct(int[] nums, int k) {
        int l = 0, m = 0, cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r<nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);

            while (map.size() > k) {
                map.put(nums[m], map.get(nums[m])-1 );
                if (map.get(nums[m]) == 0) map.remove(nums[m]);
                m++;
                l = m;
            }

            while (map.get(nums[m]) > 1) {
                map.put(nums[m], map.get(nums[m])-1 );
                m++;
            }

            if (map.size() == k) cnt += m-l+1;
        }
        return cnt;
    }


    // public int subarraysWithKDistinct(int[] nums, int k) {
    //     return greatOrEqual(nums, k) - greatOrEqual(nums, k-1);
    // }

    // public static int greatOrEqual(int[] nums, int k) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int count = 0;
    //     int l = 0;

    //     for (int r = 0; r < nums.length; r++) {
    //         map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

    //         while (map.size() > k) {
    //             map.put(nums[l], map.get(nums[l])-1 );
    //             if (map.get(nums[l]) == 0) map.remove(nums[l]);
    //             l++;
    //         }

    //         if (map.size() <= k) count += r-l+1;      
    //     }
    //     return count;
    // }
}


/*
https://leetcode.com/problems/subarrays-with-k-different-integers/description/
 * 992. Subarrays with K Different Integers 
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length
 */