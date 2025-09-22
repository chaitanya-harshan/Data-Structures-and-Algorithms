package arrays.medium.similar;

public class _04_longest_turbulant_subArr {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n < 2) return n;
        
        // int i = 1;
        // while (i < n && arr[i] == arr[i-1]) i++;
        // if (i == n) return 1;
        // int prevDiff = arr[i] - arr[i-1];
        int prevDiff = 0;

        // int cnt = 2, max = 2;
        int cnt = 1, max = 1;

        // for (int r=i+1; r<n; r++) {
        for (int r=1; r<n; r++) {
            int diff = arr[r] - arr[r-1];

            // skipping flat areas
            if (diff == 0) {
                cnt = 1;
                prevDiff = 0;
                continue;
            }
            // making sure there is a prevDiff which is not 0
            // this is where it starts (for new subArr which started in between the journey)
            if (prevDiff == 0) {
                cnt = 2;
                max = Math.max(max, cnt); // ********** this is where cnt is officially 2 in the beginning 
                // or in the middle journey where flat space has been neutralized
                prevDiff = diff;
                continue;
            }

            if ((prevDiff > 0 && diff < 0) || (prevDiff < 0 && diff > 0)) {
                cnt++;
                max = Math.max(max, cnt);
                prevDiff = diff;
            }
            else {
                cnt = 2;
                prevDiff = diff;
            }
        }
        return max;
    }

    public int maxTurbulenceSize1(int[] arr) {
        boolean greater = true;
        int cnt = 1, max = 1;
        
        for (int r=1; r<arr.length; r++) {
            if (arr[r-1] == arr[r]) {
                max = Math.max(max, cnt);
                cnt = 1;
                // greater = !greater;
            }
            else if (greater && arr[r-1] > arr[r]) {
                cnt++;
                greater = !greater;
            }
            else if (!greater && arr[r-1] < arr[r]) {
                cnt++;
                greater = !greater;
            }
            else {
                max = Math.max(max, cnt);
                // r--;
                // greater = !greater;
                // cnt = 1;
                cnt = 2;
            }
            // greater = !greater;
        }
        max = Math.max(cnt, max);
        return max;
    }
}

/*
 * URL: https://leetcode.com/problems/longest-turbulent-subarray/description/

978. Longest Turbulent Subarray

Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:
For i <= k < j:
arr[k] > arr[k + 1] when k is odd, and
arr[k] < arr[k + 1] when k is even.
Or, for i <= k < j:
arr[k] > arr[k + 1] when k is even, and
arr[k] < arr[k + 1] when k is odd.

 
Example 1:
Input: arr = [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
Example 2:
Input: arr = [4,8,12,16]
Output: 2
Example 3:
Input: arr = [100]
Output: 1

 
Constraints:

	1 <= arr.length <= 4 * 104
	0 <= arr[i] <= 109
 */