package __concepts.prefix;

public class prefix_cnt_common_arr_of_two_arrays {
    
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // int N = 50;
        int n = A.length;
        int[] prefix = new int[n];
        int[] res = new int[n];
        int cnt = 0;

        for (int i=0; i<n; i++) {
            prefix[A[i]-1]++;
            if (prefix[A[i]-1] == 2) cnt++;
            prefix[B[i]-1]++;
            if (prefix[B[i]-1] == 2) cnt++;

            res[i] = cnt;
        }
        return res;
    }

    // 1 2 3 4 5 6 7 8 9 10 -  index
    // __count__
    // 1   1
    // 2   2
    // 2 2 2 
    // 2 2 2 2  
    // _________            
    // 0 2 3 4              -  o/p

}

/*
 * 2657. Find the Prefix Common Array of Two Arrays
https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/

You are given two 0-indexed integer permutations A and B of length n.

A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.

Return the prefix common array of A and B.

A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.

 

Example 1:

Input: A = [1,3,2,4], B = [3,1,2,4]
Output: [0,2,3,4]
Explanation: At i = 0: no number is common, so C[0] = 0.
At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.
Example 2:

Input: A = [2,3,1], B = [3,1,2]
Output: [0,1,3]
Explanation: At i = 0: no number is common, so C[0] = 0.
At i = 1: only 3 is common in A and B, so C[1] = 1.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
 

Constraints:

1 <= A.length == B.length == n <= 50
1 <= A[i], B[i] <= n
It is guaranteed that A and B are both a permutation of n integers.
 */