package dp.strings;

public class _06_do_ops_to_make_strings_same {
    
    // Find LCS: then do (n - LCS) + (m - LCS)
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] prev = new int[m+1];
        prev[m] = 0; // ~~

        for (int i=n-1; i>=0; i--) {
            int[] dp = new int[m+1];
            dp[m] = 0; // ~~

            for (int j=m-1; j>=0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) dp[j] = 1 + prev[j+1];
                else dp[j] = Math.max(dp[j+1], prev[j]);
            }
            prev = dp;
        }

        int LCS = prev[0];
        return n-LCS + m-LCS;
    }
}

/*
 * 583. Delete Operation for Two Strings
https://leetcode.com/problems/delete-operation-for-two-strings/description/

Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

 

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4
 

Constraints:

1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters.
 */