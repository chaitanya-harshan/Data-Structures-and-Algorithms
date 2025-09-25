package arrays.sde.Arrays_2;

import java.util.ArrayList;
import java.util.List;

// ** If an inversion is done with reference to a num 'i' then the lower number than 'i'
// is already sorted and pushed left of 'i'
// ** counting is done while merging arrays
// in esence if some num 'i' is left of 'j' it means if there is a inverson of (i,j) then it's already done.
public class _06_inversions_in_Array {

    public static long getInversions(long arr[], int n) {
        return mergeSort(arr, 0, n-1);
    }

    static int mergeSort(long[] arr, int left, int right) {
        if (left == right) return 0;

        int cnt = 0;
        int mid = (left + right) >> 1;
        cnt += mergeSort(arr, left, mid);
        cnt += mergeSort(arr, mid+1, right);
        cnt += merge(arr, left, mid, right);
        return cnt;
    }

    static int merge(long[] arr, int low, int mid, int high) {
        int cnt = 0;
        int left = low;
        int right = mid+1;
        List<Long> list = new ArrayList<>();
        // int prev = right-1; //

        while (left <= mid || right <= high) {
            if (left <= mid && right < high && arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            }
            else if (left <= mid && right <= high && arr[left] > arr[right]) {
                list.add(arr[right]);
                cnt += mid-left+1;
                // cnt += (right-prev)*(mid-left+1);// --> r-p => r+1-r == 1 (always) DUMB ASS
                // prev = right;  // since you're always doing p = r when r changes and then r++
                right++;
            }
            else if (left <= mid) { // if elements on the left half are still left
                list.add(arr[left]);
                left++;
            }
            else if (right <= high) { // if elements on the right half are still left
                list.add(arr[right]);
                right++;
            }
        }
        // transfering all elements from temporary to arr
        int k = low;
        for (long num : list) {
            arr[k] = num;
            k++;
        }
        return cnt;
    }
}
/*
 * https://www.naukri.com/code360/problems/count-inversions_615?leftPanelTabValue=PROBLEM
 * https://youtu.be/AseUmwVNaoY
 * 
 * 
For a given integer array of size 'N' containing all "distinct values", find the total number of 'Inversions' that may exist.

An inversion is defined for a pair of integers in the arr when the following two conditions are met.

A pair ('ARR[i]', 'ARR[j]') is said to be an inversion when:

1. 'ARR[i] > 'ARR[j]' 
2. 'i' < 'j'
Where 'i' and 'j' denote the indices ranging from [0, 'N').

Constraints :
1 <= N <= 10^5 
1 <= ARR[i] <= 10^9

Where 'ARR[i]' denotes the array element at 'ith' index.

I/p: 3, 3 2 1
o/p: 3 --> (3, 2), (2, 1) and (3, 1).

I/p: 5, 2 5 1 3 4
o/p: 4 --> (2, 1), (5, 1), (5, 3) and (5, 4).


Hints:
1. Start with the brute force approach.
2. Use a modified merge sort.
3. Iterate through the elements in sorted order and use a Fenwick tree to track the inversions.
 */