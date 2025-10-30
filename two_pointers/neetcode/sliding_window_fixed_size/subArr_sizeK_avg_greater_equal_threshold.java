package two_pointers.neetcode.sliding_window_fixed_size;

public class subArr_sizeK_avg_greater_equal_threshold {
    
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, cnt = 0;
        for (int i=0; i<k; i++) sum += arr[i];
        if (sum/k >= threshold) cnt++; // cnt = 1

        for (int i=k; i<arr.length; i++) {
            sum += arr[i] - arr[i-k];
            if (sum/k >= threshold) cnt++;
        }
        return cnt;

        // HashMap<Integer,Integer> map = new HashMap<>();
        // map.put(-1, 0);

        // for (int i=0; i<arr.length; i++) {
        //     sum += arr[i];
        //     map.put(i, sum);

        //     if (i >= k-1 && (sum-map.get(i-k)) / k >= threshold) cnt++;
        // }
        // return cnt;
    }
}


// 2,2,2,2,5, 5, 5, 8
// 2,4,6,8,13,18,23,31
//     2,2,3, 4, 5, 6
// 2,5,5
// 5,5,5
// 5,5,8

/*
 * 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/

Given an array of integers arr and two integers k and threshold, return the number of sub-arrays 
of size k and average greater than or equal to threshold.

 

Example 1:

Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).
Example 2:

Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
Output: 6
Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.
 

Constraints:

1 <= arr.length <= 105
1 <= arr[i] <= 104
1 <= k <= arr.length
0 <= threshold <= 104
 */