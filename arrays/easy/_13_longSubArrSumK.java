package arrays.easy;
import java.util.HashMap;

public class _13_longSubArrSumK {
    public static void main(String[] args) {
        int[] arr = {2,3,0,0,-1,6,1,9};
        System.out.println(getLongestSubArr(arr, 10));
        int[] arr1 = {-1,1,1};
        System.out.println(getLongestSubArr(arr1, 1));
        // -----------
        System.out.println(getLongestSubArr1(arr, 10));
        System.out.println(getLongestSubArr1(arr1, 1));
        // ----------- **** important
        int[] arr2 = {-13,0,6,15,16,2,15,-12,17,-16,0,-3,19,-3,2,-9,-6}; // ans is 5 for k=15
        System.out.println(getLongestSubArr1(arr2, 15));// will give wrong ans as it has -ve numbers. gives = 1
        System.out.println(getLongestSubArr(arr2, 15)); // ans = 5 which is correct 
    }

    // for array which contains +ve & -ve and zeros
    static int getLongestSubArr(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) maxLength = i+1;
            if (!map.containsKey(sum)) map.put(sum, i);
            if (map.containsKey(sum-k)) {
                int length = i - map.get(sum-k);
                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
    }

    // if Array has only +ve & zeros only
    static int getLongestSubArr1( int[] arr, int k) {
        int l = 0;
        int sum = 0, max = 0;

        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];
            while (sum > k && l <= r) {
                sum -= arr[l++];
                l++;
            }

            if (sum == k) max = Math.max(max, r+1-l);
        }
        return max;
    }
}

/*
 * Longest subarray with sum K

Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. 
If no such sub-array exists, return 0.


Examples:
Input: nums = [10, 5, 2, 7, 1, 9],  k=15

Output: 4

Explanation:

The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this sub-array is 4.

Input: nums = [-3, 2, 1], k=6

Output: 0

Explanation:

There is no sub-array in the array that sums to 6. Therefore, the output is 0.
 */