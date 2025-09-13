package dp.strings;

public class _07_shortest_common_SuperSequence {

    // Bottom-up approach to find the shortest common supersequence
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Build the LCS table from bottom up
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // ********** THIS ISN'T SIMPLY constructing LCS from dp
        // constructing the pre_chars + LCS & chars in between **********
        // The dp table guides us to make the optimal choice at each step.

        int i = 0, j = 0;
        // Iterate as long as we have characters to compare in BOTH strings.
        while (i < n && j < m) {
            // Case 1: The characters match.
            // This character is part of the LCS. We can represent it for both strings
            // by adding it to our result just once. Then, we can move on in both strings.
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
                i++;
                j++;
            } // Case 2: The characters do not match.
            // We must add one of them. To keep the supersequence as short as possible,
            // we need to make a greedy choice. We look at our dp table to see which
            // path preserves a longer future LCS.
            // dp[i+1][j] = LCS length of str1.substring(i+1) and str2.substring(j)
            // dp[i][j+1] = LCS length of str1.substring(i) and str2.substring(j+1)
            else if (dp[i + 1][j] >= dp[i][j + 1]) {
                // By moving along the path of str1 (i++), we preserve a better or equal future LCS.
                // This means the character str1.charAt(i) is more "critical" for the future LCS
                // than str2.charAt(j) is. So, we must first add str1.charAt(i).
                sb.append(str1.charAt(i));
                i++;
            } else {
                // The opposite is true: moving along str2's path preserves a better future LCS.
                // We append str2.charAt(j) and advance j.
                sb.append(str2.charAt(j));
                j++;
            }
        }

        // now all the chars before the subsequence + chars in the range b/w 
        // 1st & last postion of subsequence are all added to result.
        // now we add the remaining chars that might be left out because one of the str1 
        // has already been consumed so loop stops so we will append the other string 
        while (i < n) {
            sb.append(str1.charAt(i));
            i++;
        }

        while (j < m) {
            sb.append(str2.charAt(j));
            j++;
        }

        return sb.toString();
    }
}

/*
 * URL: https://leetcode.com/problems/shortest-common-supersequence/description/

1092. Shortest Common Supersequence

Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.
A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

 
Example 1:
Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation:
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Example 2:
Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"

 
Constraints:

	1 <= str1.length, str2.length <= 1000
	str1 and str2 consist of lowercase English letters.
 */
