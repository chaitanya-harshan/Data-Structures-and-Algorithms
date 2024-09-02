package arrays.sde.Arrays_3;

import java.util.ArrayList;
import java.util.List;

public class _04_majority_n_by_3 {
    
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0, c2 = 0;
        int E1 = Integer.MIN_VALUE, E2 = Integer.MIN_VALUE;

        for (int i=0; i<nums.length; i++) {
            if (c1 == 0 && nums[i] != E2) {
                E1 = nums[i];
                c1++;
            } 
            else if (c2 == 0 && nums[i] != E1) {
                E2 = nums[i];
                c2++;
            }
            else if (nums[i] == E1) c1++;
            else if (nums[i] == E2) c2++;
            else {
                c1--;
                c2--;
            }
        }

        List<Integer> list = new ArrayList<>();
        c1 = 0; c2 = 0;
        for (int num: nums) {
            if (num == E1) c1++;
            if (num == E2) c2++;
        }
        if (c1 >= nums.length/3 + 1) list.add(E1);
        if (c2 >= nums.length/3 + 1) list.add(E2);
        return list;
    }
}

/*
https://leetcode.com/problems/majority-element-ii/description/
https://youtu.be/vwZj1K0e9U8

 * 229. Majority Element II
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Input: nums = [3,2,3]
Output: [3]

Input: nums = [1]
Output: [1]

Input: nums = [1,2]
Output: [1,2]
 */