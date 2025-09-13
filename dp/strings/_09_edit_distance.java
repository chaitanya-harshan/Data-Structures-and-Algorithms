package dp.strings;

public class _09_edit_distance {
    // dp[i][j] denotes how many ops are required for words starting at i and j.
    // If a character is equal, then move to the next substring in both the strings. If it's not 
    // equal, check which operation is resulting in the minimum ops for insert, replace, and delete
    // And that will be the number of ops required to convert word 1 to 2 starting at index i, j.
    public int minDistance(String word1, String word2) {
        // you might need to watch NeetCode
        int n = word1.length(), m = word2.length();
        int[] prev = new int[m+1];
        for (int i=0; i<m; i++) prev[i] = m-i;

        for (int i=n-1; i>=0; i--) {
            int[] dp = new int[m+1];
            dp[m] = n-i;

            for (int j=m-1; j>=0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) dp[j] = prev[j+1];
                else {
                    int min = Integer.MAX_VALUE;
                    // Insert
                    min = Math.min(1 + dp[j+1], min);
                    // Delete
                    min = Math.min(1 + prev[j], min);
                    // Replace
                    min = Math.min(1 + prev[j+1], min);

                    dp[j] = min;
                }
            }
            prev = dp;
        }
        return prev[0];
    }
}

/*
 * URL: https://leetcode.com/problems/edit-distance/description/
 * https://youtu.be/XYi2-LPrwm4

72. Edit Distance

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:
Insert a character
Delete a character
Replace a character

 
Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

 
Constraints:

	0 <= word1.length, word2.length <= 500
	word1 and word2 consist of lowercase English letters.
 */