package binary.math;

public class _02_Nth_root {
    public static void main(String[] args) {
        int n = 3, m = 27;
        System.out.println(NthRoot(n, m));
        System.out.println(NthRoot(1,4));
    }
    
    public static int NthRoot(int n, int m) {
        int low = 1, high = m; // not m/2+1 cause of the case n=1,m=4
        while (low <= high) {
            int mid = (low + high)/2;
            if (Math.pow(mid, n) == m) {
                return mid;
            }
            else if (Math.pow(mid, n) < m) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return -1;
    }
}

/*
https://www.naukri.com/code360/problems/nth-root-of-m_1062679
 * You are given two positive integers 'n' and 'm'. You have to return the 'nth' root of 'm', i.e. 'm(1/n)'. If the 'nth root is not an integer, return -1.



Note:
'nth' root of an integer 'm' is a number, which, when raised to the power 'n', gives 'm' as a result.


Example:
Input: ‘n’ = 3, ‘m’ = 27

Output: 3

Explanation: 
3rd Root of 27 is 3, as (3)^3 equals 27.

Expected Time Complexity:
Try to do this in O(log(n+m)).

Constraints:
1 <= n <= 30
1 <= m <= 10^9
 */