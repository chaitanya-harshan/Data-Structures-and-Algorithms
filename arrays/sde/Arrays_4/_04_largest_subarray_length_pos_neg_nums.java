package arrays.sde.Arrays_4;

import java.util.HashMap;

public class _04_largest_subarray_length_pos_neg_nums {
    
    public static int maxLen(int arr[], int n) {
        int target = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;
        int maxLen = 0;
        
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
            // sum == target ?
            if (sum == target) {
                maxLen = Math.max(maxLen, i+1);
            }
            // sum-target exists?
            else if (map.containsKey(sum-target)) {
                maxLen = Math.max(maxLen, i-map.get(sum-target));
            }
            
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return maxLen;
    }
}

/*
https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

 * Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Examples:

Input: arr[] = {15,-2,2,-8,1,7,10,23}, n = 8
Output: 5
 */
