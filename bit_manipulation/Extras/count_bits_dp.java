package bit_manipulation.extras;

public class count_bits_dp {
    
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        int currentPowOf2 = 1;
        int nxtPowOf2 = 1;

        for (int i = 1; i<dp.length; i++) {
            if (i == nxtPowOf2) {
                currentPowOf2 = nxtPowOf2;
                nxtPowOf2 *= 2;
                dp[i] = 1;
            }
            else {
                dp[i] = 1 + dp[i-currentPowOf2];
            }
        }
        return dp;
    }
}

/*

0   0000        -> 0
1   0001 ______ -> 1+dp[1-1] = 1+dp[0] = 1
2   0010 ______ -> 1+dp[2-2] = 1+dp[0] = 1
3   0011        -> 1+dp[3-2]
4   0100 ______ -> 1+dp[4-4] = 1+dp[0] = 1
5   0101        -> 1+dp[5-4]
6   0110        -> 1+dp[6-4]
7   0111        -> 1+dp[7-4]
8   1000 ______ -> 1+dp[8-8] = 1+dp[0] = 1
9   1001        -> 1+dp[9-8]
10  1010        -> 1+dp[10-8]
11  1011        -> 1+dp[11-8]
12  1100        -> 1+dp[12-8]
13  1101        -> 1+dp[13-8]
.
.
.
so on

*/

/*
https://leetcode.com/problems/counting-bits/description/

 * 338. Counting Bits
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 
 */