package dp.strings;

public class _04_longest_plaindrome_subsequence {
    
    // just revese rhe string as s2 and do LCS b/w 's' and 's.reverse'
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[] prev = new int[n+1];
        prev[n] = 0;

        for (int i=n-1; i>=0; i--) {
            int[] dp = new int[n+1];
            dp[n]  = 0;

            for (int j=n-1; j>=0; j--) {
                if (s.charAt(i) == t.charAt(j)) dp[j] = 1 + prev[j+1];
                else dp[j] = Math.max(dp[j+1], prev[j]);
            }
            prev = dp;
        }
        return prev[0];
    }
}

/*
 * 516. Longest Palindromic Subsequence
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 * 
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 

Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.
 */