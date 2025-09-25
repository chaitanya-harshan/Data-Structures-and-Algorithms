package arrays.medium.similar;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _08_min_adj_swap_to_convert_to_Kth_nxtPermutation {
    // *********** THIS IS A more OPTIMIZED (completely unnecessary) approach intuition ***************
    // I'll paste the code in vscode in Arrays/medium/similar/_08_***

    // We create a indexMap p[] to have the index of the val in og array: 
    // => target[i] = og[j] then P[i] = j
    // now we have P[] which only contains indexs as values from 0 -> (n-1) (no duplicates)
    // Now, we basically need to find the number of swaps to sort P[]
    // Adjacent swapping means you can only do bubble sort. So, basically we need to find the total
    // number of swaps being done by the bubble sort === which is the inversion count of p[]
    // Inversion function() --> modification of merge sort
    // ------
    // Here yb val I really mean index as p[] only contains positions/indexes.
    // If it weren't for Adjacent swap constraint, then we can just directly swap cur value with the
    // indexMap val from i-> 0 to n-1 if target[i] != og[i];
    // this mean max swap of O(n) unlike with bubble sort O(n^2)

    // The below code is different. It doesn't create P[] but instead, finds the value index and then 
    // bubbles it down and adds the total swap cnt.
    // you only need P[] to find inversions else you can just do Bubbling without it 
    public int getMinSwaps(String num, int k) {
        int n = num.length();
        char[] og = num.toCharArray();
        char[] s = num.toCharArray();
        for (int i=0; i<k; i++) nextPermutation(s);

        int swaps = 0;

        for (int i=0; i<n; i++) {
            if (og[i] == s[i]) continue;

            int j = i+1;
            while (j<n && s[i] != og[j]) j++;
            swaps += j-i;

            char key = og[j];
            while (j > i) {
                og[j] = og[j-1];
                j--;
            }
            og[i] = key;
        }
        return swaps;

        // Consider the below as artifact I've leaving for that more optimized approach.
        // Creating the index map: a->b or b->a (doesn't matter)
        // Adjacent swapping means only bubble sort & no. of swaps in Bubble_S is inversion cnt
    }

    void nextPermutation(char[] s) {
        int n = s.length;
        // Finding Pivot:
        int l = n-2;
        while (l >= 0 &&s[l] >= s[l+1]) l--;
        if (l == -1) {
            reverse(s, 0, n-1);
            return;
        }

        // Finding Successor & swapping:
        int r = n-1;
        while (s[l] >= s[r]) r--;
        swap(s, l, r);

        reverse(s, l+1, n-1);
    }

    void reverse(char[] s, int i, int j) {
        int l = (i+j)/2;
        int r = (i+j+1)/2;

        while (l >= i) {
            swap(s, l,r);
            l--;
            r++;
        }
    }

    void swap(char[] s, int i, int j) {
        if (s[i] == s[j]) return;
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}

/*
 * URL: https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/description/

1850. Minimum Adjacent Swaps to Reach the Kth Smallest Number

You are given a string num, representing a large integer, and an integer k.
We call some integer wonderful if it is a permutation of the digits in num and is greater in value than num. There can be many wonderful integers. However, we only care about the smallest-valued ones.
For example, when num = "5489355142":
The 1st smallest wonderful integer is "5489355214".
The 2nd smallest wonderful integer is "5489355241".
The 3rd smallest wonderful integer is "5489355412".
The 4th smallest wonderful integer is "5489355421".
Return the minimum number of adjacent digit swaps that needs to be applied to num to reach the kth smallest wonderful integer.
The tests are generated in such a way that kth smallest wonderful integer exists.

 
Example 1:
Input: num = "5489355142", k = 4
Output: 2
Explanation: The 4th smallest wonderful number is "5489355421". To get this number:
- Swap index 7 with index 8: "5489355142" -> "5489355412"
- Swap index 8 with index 9: "5489355412" -> "5489355421"
Example 2:
Input: num = "11112", k = 4
Output: 4
Explanation: The 4th smallest wonderful number is "21111". To get this number:
- Swap index 3 with index 4: "11112" -> "11121"
- Swap index 2 with index 3: "11121" -> "11211"
- Swap index 1 with index 2: "11211" -> "12111"
- Swap index 0 with index 1: "12111" -> "21111"
Example 3:
Input: num = "00123", k = 1
Output: 1
Explanation: The 1st smallest wonderful number is "00132". To get this number:
- Swap index 3 with index 4: "00123" -> "00132"

 
Constraints:

	2 <= num.length <= 1000
	1 <= k <= 1000
	num only consists of digits.
 */

// ===========================================================================================================================================================

class moreOptimizedSolution {
    
    public int getMinSwaps(String num, int k) {
        char[] originalArr = num.toCharArray();
        char[] targetArr = num.toCharArray();

        // 1. Find the k-th wonderful integer (target permutation)
        for (int i = 0; i < k; i++) {
            nextPermutation(targetArr);
        }

        int n = originalArr.length;
        int[] p = new int[n];

        // 2. Create a map to store the original indices of each character
        // The queue ensures we match the 1st '1' with the 1st '1', 2nd with 2nd, etc.
        Map<Character, Queue<Integer>> originalIndicesMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            originalIndicesMap.computeIfAbsent(originalArr[i], c -> new LinkedList<>()).add(i);
        }

        // 3. Build the position permutation array 'p'
        // p[i] = final index of the character that was originally at index i
        for (int j = 0; j < n; j++) {
            char targetChar = targetArr[j];
            int originalIndex = originalIndicesMap.get(targetChar).poll();
            p[originalIndex] = j;
        }

        // 4. Count inversions in 'p' using a merge-sort based approach
        return countInversions(p, new int[n], 0, n - 1);
    }

    /**
     * Counts inversions in an array using a modified merge sort.
     */
    private int countInversions(int[] arr, int[] temp, int left, int right) {
        int invCount = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            invCount += countInversions(arr, temp, left, mid);
            invCount += countInversions(arr, temp, mid + 1, right);
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }
        return invCount;
    }

    private int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;      // Pointer for the left subarray
        int j = mid + 1;   // Pointer for the right subarray
        int k = left;      // Pointer for the temporary merged array
        int invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // If arr[i] > arr[j], it's an inversion.
                // All elements from arr[i] to arr[mid] are also > arr[j]
                // because the left subarray is sorted.
                invCount += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from left subarray
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right subarray
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the sorted, merged elements back to the original array
        System.arraycopy(temp, left, arr, left, right - left + 1);

        return invCount;
    }

    // Your existing helper methods
    void nextPermutation(char[] s) {
        int n = s.length;
        int l = n - 2;
        while (l >= 0 && s[l] >= s[l + 1]) l--;
        if (l == -1) {
            reverse(s, 0, n - 1);
            return;
        }
        int r = n - 1;
        while (s[l] >= s[r]) r--;
        swap(s, l, r);
        reverse(s, l + 1, n - 1);
    }

    void reverse(char[] s, int i, int j) {
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    void swap(char[] s, int i, int j) {
        if (s[i] == s[j]) return;
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}