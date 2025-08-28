package binary.math;

public class _14_Kth_element_combined_sorted_arrays {
    public static void main(String[] args) {
        // int[] a = {1, 4, 7, 10, 12};
        // int[] b = {2, 3, 6, 15};
        int[] a = {5, 5, 8, 8, 8, 9, 11, 11, 11, 11, 11};
        int[] b = {4, 4, 4, 4, 6, 8, 9, 9, 9, 11, 13,};
        System.out.println("The kth element is " + kthElement(a, b, 2));
        int[] c = {1,2,3}; 
        int[] d = {10, 20, 30};
        System.out.println("The kth element is " + kthElement(c, d, 1));
    }

    public static int kthElement( int a[], int b[], int k) {
        if (a.length > b.length) {int[] temp = a; a = b; b = temp;}
        int n1 = a.length, n2 = b.length;

        int kth = k-1; // we need to pivot/split k-1 elements to be in the left part
        // then the 1st element of the right part is the answer.
        int l = -1, h = n1-1;
        // int l = Math.max(-1, kth - n2-1), h = Math.min(kth-1, n1-1);
        // It's correct but something else logic i didn't understand
        while (l <= h) {
            int m = l+h >> 1;
            int bil = kth - m - 2;
            int bir = bil + 1;
            
            int Al = (m >= 0) ? a[m] : Integer.MIN_VALUE;
            int Ar = (m+1 < n1) ? a[m+1] : Integer.MAX_VALUE;
            // int Bl = (bil >= 0) ? b[bil] : Integer.MIN_VALUE;
            // int Br = (bir < n2) ? b[bir] : Integer.MAX_VALUE;
            int Bl = (bil < 0) ? Integer.MIN_VALUE : (bil >= n2 ? Integer.MAX_VALUE : b[bil]);
            int Br = (bir < 0) ? Integer.MIN_VALUE : (bir >= n2 ? Integer.MAX_VALUE : b[bir]);
            // int Bl, Br;
            // if (bil < 0) Bl = Integer.MIN_VALUE;
            // else if (bil >= n2) Bl = Integer.MAX_VALUE;
            // else Bl = b[bil];
            // if (bir < 0) Br = Integer.MIN_VALUE;
            // else if (bir >= n2) Br = Integer.MAX_VALUE;
            // else Br = b[bir];

            if (Al <= Br && Bl <= Ar) {
                return Math.min(Ar,Br);
            }
            else if (Al > Br) h = m-1;
            else l = m+1;
        }
        return 0; // never reach here (dummy return)
    }
    /*
     * When m is too small: This means you are taking too few elements from a, which implies you 
     * must take a large number of elements from b (i.e., bi is large). If bi becomes greater 
     * than or equal to n2, your code sets Bl to Integer.MIN_VALUE. This prevents the condition 
     * Bl > Ar from ever being true, so the binary search doesn't move right to increase m. 
     * It gets stuck. 
     * 
     * Correction: In this case, Bl should be Integer.MAX_VALUE to correctly signal that m is too small.

    When m is too large: This implies you must take a small or even negative number of elements 
    from b (i.e., bir is small). If bir becomes less than 0, your code sets Br to Integer.MAX_VALUE. 
    This prevents the condition Al > Br from being true, so the binary search doesn't move left to decrease m.

        Correction: In this case, Br should be Integer.MIN_VALUE to correctly signal that m is too large.
     */

    // Similar but low, high calculation is different
    public static int kthElement1( int a[], int b[], int k) {
        if (a.length > b.length) {int[] temp = a; a = b; b = temp;}
        int n1 = a.length, n2 = b.length;

        int kth = k-1; // we need to pivot/split k-1 elements to be in the left part
        // then the 1st element of the right part is the answer.
        int l = Math.max(-1, kth - n2-1); // Explantion: if we take '0' elements from a[], then we need to take 'k-1' elements from b[]
        // Explantion for (kth -n2-1): if we take 'n2' elements from b[], then we need to take 'k-1-n2' elements from a[]
        // if (kth - n2-1 < -1) l = -1: this case is when k-1 < n2, i.e., we can take all k-1 elements from b[] only
        // if (kth - n2-1 >= -1) l = kth - n2-1: this case is when k-1 >= n2, i.e., we must take at least (k-1-n2) elements from a[]
        int h = Math.min(kth-1, n1-1);
        while (l <= h) {
            int m = l+h >> 1;
            int bil = kth - m - 2;
            int bir = bil + 1;
            
            int Al = (m >= 0) ? a[m] : Integer.MIN_VALUE;
            int Ar = (m+1 < n1) ? a[m+1] : Integer.MAX_VALUE;
            int Bl = (bil >= 0) ? b[bil] : Integer.MIN_VALUE;
            int Br = (bir < n2) ? b[bir] : Integer.MAX_VALUE;

            if (Al <= Br && Bl <= Ar) {
                return Math.min(Ar,Br);
            }
            else if (Al > Br) h = m-1;
            else l = m+1;
        }
        return 0; // never reach here (dummy return)
    }
}

/*
https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1

 * K-th element of two Arrays
Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.

Examples :

Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.
Input: a[] = [1, 4, 8, 10, 12], b[] = [5, 7, 11, 15, 17], k = 6
Output: 10
Explanation: Combined sorted array is [1, 4, 5, 7, 8, 10, 11, 12, 15, 17]. The 6th element of this array is 10.
Constraints:
1 ≤ a.size(), b.size() ≤ 106
1 ≤ k ≤ a.size() + b.size()
0 ≤ a[i], b[i] ≤ 108
 */