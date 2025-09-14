package dp.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _02_print_Longest_Increasing_Subseqeunce {
    public static List<Integer> printingLongestIncreasingSubsequence(int[] arr, int x) {
        int n = arr.length;

        // dp[i] stores the length of the LIS starting at index i.
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Initialize LIS length for all elements to 1.

        // nxt[i] stores the index of the next element in the LIS starting at i.
        // This array helps in reconstructing the path of the LIS.
        int[] nxt = new int[n];
        Arrays.fill(nxt, -1); // -1 indicates the end of a subsequence.

        int LIS = 1;
        int startIdx = n - 1; // Stores the starting index of the overall longest LIS.

        // Compute LIS values in a bottom-up manner (from right to left).
        for (int i=n-1; i>=0; i--) {
            for (int j = i+1; j<n; j++) {
                if (arr[i] < arr[j]) {
                    // If we found a longer path by including arr[j].
                    if (1 + dp[j] > dp[i]) {
                        dp[i] = 1 + dp[j]; // Update the length.
                        nxt[i] = j;        // Record the path: the element after i is at index j.
                    }
                }
            }
            // If the LIS starting at the current 'i' is the new longest, update trackers.
            if (dp[i] > LIS) {
                LIS = dp[i];
                startIdx = i;
            }
        }

        // Reconstruct the LIS using the starting index and the 'nxt' path array.
        List<Integer> res = new ArrayList<>();
        int i = startIdx;
        while (i != -1) {
            res.add(arr[i]);
            i = nxt[i]; // Move to the next element in the recorded path.
        }

        return res;
    }
}

/* Printing Longest Increasing Subsequence
https://www.naukri.com/code360/problems/printing-longest-increasing-subsequence_8360670

You are given an array 'arr' of length 'n'.



Find the Longest Increasing Subsequence of the array.



A subsequence is a subset of an array achieved by removing some (possibly 0) elements without changing the order of the remaining elements.



Increasing subsequence means a subsequence in which all the elements are strictly increasing.



Longest increasing subsequence is an increasing subsequence that has the largest length possible.



Please note that there may be more than one LIS (Longest Increasing Subsequence) possible. Return any one of the valid sequences.



Example:
Input: ‘arr’ = [5, 6, 3, 4, 7, 6]

Output: LIS = [5, 6, 7] OR [3, 4, 7] OR [3, 4, 6]

Explanation: All these three subsequences are valid Longest Increasing Subsequences. Returning any of them is correct.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
6
5 6 3 4 7 6


Sample Output 1:
3


Explanation Of Sample Input 1 :
There are three valid LIS for the given array: [5, 6, 7], [3, 4, 7] OR [3, 4, 6], and their length is 3.


Sample Input 2 :
5
1 2 3 4 5


Sample Output 2 :
5


Explanation Of Sample Input 2 :
There is only one valid LIS for the array: [1, 2, 3, 4, 5], and its length is 5.


Expected time complexity:
The expected time complexity is O(‘n’ ^ 2).


Constraints:
1 <= ‘n’ <= 500
1 <= ‘arr[i]’ <= 10^5 */