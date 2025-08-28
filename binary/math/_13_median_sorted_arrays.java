package binary.math;

public class _13_median_sorted_arrays {
    public double findMedianSortedArrays(int[] a, int[] b) {
        // Watch Neetcode. its' impossible without his explanation
        // this is diff verison so you might need to ask gpt
        if (b.length < a.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }
        int n1 = a.length, n2 = b.length;
        int tot = n1 + n2;
        int half = tot / 2;

        int l = -1, h = n1-1;
        // elements after m are in right half & elments before m are in left half
        // l is -1 because '-1' means no elements taken from a[] 
        // h is n1-1 because 'n1-1' means all elements taken from a[]
        while (l <= h) {
            int m = l+h >> 1;
            int bi = half - m - 2; // bi is the index of the last element of left part of b[]

            int Al = (m >= 0) ? a[m] : Integer.MIN_VALUE; // [3,4] [1,2,5,6]
            int Ar = (m+1 < n1) ? a[m+1] : Integer.MAX_VALUE; // [1,2,3] [4,5,6,7]
            int Bl = (bi >= 0) ? b[bi] : Integer.MIN_VALUE; // [1,2,3] [4,5,6,7]
            int Br = (bi+1 < n2) ? b[bi+1] : Integer.MAX_VALUE; // [7,8,9] [1,2,3,4,5,6] 

            if (Al <= Br && Bl <= Ar) {
                if (tot % 2 == 1) return Math.min(Ar,Br);
                else return (Math.max(Al,Bl) + Math.min(Ar,Br)) / 2.0; 
            }
            else if (Al > Br) h = m - 1;
            else l = m + 1;
        }
        return 0; // never reach here (dummy return)
    }


    // OPTIMAL VERSION--------------------
    public double findMedianSortedArrays1(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;
        if (n1 > n2) return findMedianSortedArrays(b,a);

        int left = (n1 + n2 +1)/2; // length of the left half

        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low +high)/2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < n1) r1 = a[mid1];
            if (mid2 < n2) r2 = b[mid2];
            if (mid1-1 >= 0) l1 = a[mid1-1];
            if (mid2-1 >= 0) l2 = b[mid2-1];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1,l2);
                else return ( (double)Math.max(l1,l2) + Math.min(r1,r2) )/2.0;
            }
            else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0;
    }

    // BETTER version---------------------------------------------------
    public double findMedianSortedArrays2(int[] a, int[] b) {
        int length = a.length + b.length;
        int id2 = length / 2;
        int id1 = id2 - 1;
        int count = 0;
        int e1 = -1, e2 = -1;

        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (count == id1) e1 = a[i];
                else if (count == id2) {
                    e2 = a[i];
                    count++;
                    break;
                }
                i++;
                count++;
            }
            else {
                if (count == id1) e1 = b[j];
                else if (count == id2) {
                    e2 = b[j];
                    count++;
                    break;
                }
                j++;
                count++;
            }
        }
        while (i < a.length) {
            if (count == id1) e1 = a[i];
            else if (count == id2) {
                e2 = a[i];
                break;
            }
            i++;
            count++;
        }
        while (j < b.length) {
            if (count == id1) e1 = b[j];
            else if (count == id2) {
                e2 = b[j];
                break;
            }
            j++;
            count++;
        }

        if (length % 2 == 0) return ((double)e1+e2)/2.0;
        else return (double)e2; 
    }
}


/*
 * URL: https://leetcode.com/problems/median-of-two-sorted-arrays/description/

4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

 
Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

 
Constraints:

	nums1.length == m
	nums2.length == n
	0 <= m <= 1000
	0 <= n <= 1000
	1 <= m + n <= 2000
	-106 <= nums1[i], nums2[i] <= 106
 */