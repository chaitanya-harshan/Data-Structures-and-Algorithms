package dp.strings;

public class _05_min_insertions_to_make_plaindrome {
    // do - (LPS) Longest Palindrome Sub Sequence b/w 's' & 's.reverse'
    // then ---> n - LPS = min insertions
    // LPS is same as LCS b/w 's' & 's.reverse'
    // (n-LPS) = basically the chars which are either diff or not in correct position
    // so we need to insert those chars on the opposite side to make the string palindrome
    
    public int minInsertions(String s) {
        int n = s.length();
        String t = new StringBuilder(s).reverse().toString();
        int[] prev = new int[n+1];
        prev[n] = 0; //~~

        for (int i=n-1; i>=0; i--) {
            int[] dp = new int[n+1];
            dp[n] = 0; //~~

            for (int j=n-1; j>=0; j--) {
                if (s.charAt(i) == t.charAt(j)) dp[j] = 1 + prev[j+1];
                else dp[j] = Math.max(dp[j+1], prev[j]);
            }
            prev = dp;
        }

        int longestPalindromeSubseq = prev[0];
        return n - longestPalindromeSubseq;
    }
}

/*
 * 1312. Minimum Insertion Steps to Make a String Palindrome
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
 * 
Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
 */