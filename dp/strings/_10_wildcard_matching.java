package dp.strings;

public class _10_wildcard_matching {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[] prev = new boolean[m+1];
        //------------------------------------------------------------------
        prev[m] = true; // s & p are both empty   {BASE CASE}
        // s is empty & p isn't
        // checking there are any chars after '*' in p
        // if no then prev[j] can match to empty seq to match with empty 's'
        // --- (by matching with prev[m] which is true)
        // else it's false as there are more chars after '*' to be matched
        // --- (by matching with j+1 which are false)
        for (int j=m-1; j>=0; j--) if (p.charAt(j) == '*') prev[j] = prev[j+1];
        //------------------------------------------------------------------

        for (int i=n-1; i>=0; i--) {
            boolean[] dp = new boolean[m+1];
            dp[m] = false; // ~~   // empty p so s can't be matched to p

            for (int j=m-1; j>=0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[j] = prev[j+1];
                }
                else if (p.charAt(j) == '*') {
                    dp[j] = dp[j+1] || prev[j];
                }
            }
            prev = dp;
        }
        return prev[0];
    }
}

/*
 * URL: https://leetcode.com/problems/wildcard-matching/description/

44. Wildcard Matching

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 
Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

 
Constraints:

	0 <= s.length, p.length <= 2000
	s contains only lowercase English letters.
	p contains only lowercase English letters, '?' or '*'.
 */