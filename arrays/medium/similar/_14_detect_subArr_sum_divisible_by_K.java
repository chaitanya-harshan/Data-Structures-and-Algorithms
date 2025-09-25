package arrays.medium.similar;

import java.util.HashMap;

public class _14_detect_subArr_sum_divisible_by_K {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;
        int sum = 0;
        HashMap<Integer, Integer> remainders = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            int r = sum % k;
            if (r == 0 && i >= 1) return true;
            if (remainders.containsKey(r)) {
                if (i-remainders.get(r) >= 2) return true;
            }
            else remainders.put(r, i);
        }
        return false;
    }


    public boolean checkSubarraySum1(int[] nums, int k) {
        if (nums.length < 2) return false;
        int sum = nums[0] + nums[1];
        if (sum % k == 0) return true;

        HashMap<Integer, Integer> remainders = new HashMap<>();
        remainders.put(nums[0] % k, 0);
        remainders.put(nums[0]+nums[1] % k, 1);
        for (int i=2; i<nums.length; i++) {
            sum += nums[i];
            int r = sum % k;

            if (r == 0) return true;
            if (remainders.containsKey(r)) {
                if (i-remainders.get(r) >= 2) return true;
            }
            else remainders.put(r, i);
        }
        return false;
    }
}
