package arrays.medium;

import java.util.HashMap;

public class __EXTRA_subArr_k_distinct_num {
    
    public int subarraysWithKDistinct(int[] nums, int k) {
        return greatOrEqual(nums, k) - greatOrEqual(nums, k+1);
    }

    public static int greatOrEqual(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        if (n < k) return 0;
        
        int count = 0;
        int j = 0;
        for (int left = 0; left < n; left++) {
            while (j < n && map.size() < k) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                j++;
            }
            if (map.size() == k) count += n-j+1;

            map.put(nums[left], map.get(nums[left])-1);
            if (map.get(nums[left]) == 0) map.remove(nums[left]);           
        }
        return count;
    }
    // This is a helper function for the problem "Subarrays with K Different Integers"
    // Leetcode Link: https://leetcode.com/problems/subarrays-with-k-different-integers/
    // It calculates the number of subarrays with at most K distinct integers.
    public int subarraysWithAtMostKDistinct(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }

    // This is the main function for the problem "Subarrays with K Different Integers"
    // Leetcode Link: https://leetcode.com/problems/subarrays-with-k-different-integers/
    // It calculates the number of subarrays with exactly K distinct integers.
    // The approach is to use the principle of inclusion-exclusion:
    // exactly K distinct = (at most K distinct) - (at most K-1 distinct)
    public int subarraysWithKDistinctOptimal(int[] nums, int k) {
        return subarraysWithAtMostKDistinct(nums, k) - subarraysWithAtMostKDistinct(nums, k - 1);
    }

}
