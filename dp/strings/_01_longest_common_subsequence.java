package dp.strings;

public class _01_longest_common_subsequence {

    // https://youtu.be/NPZn9jBrX8U - striver
    // watch striver if u feel it's hard else neetcode but neetcode did it in reverse from start to end
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abaaa", "baabaca"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] --> LCS starting at position i,  j for t1 & t2 respectively
        // if i == j --> move nxt on both Str.  i+1, j+1 
        // else check max of (stay one & move other)
        int m = text1.length();
        int n = text2.length();
        int[] prev = new int[n+1];
        prev[n] = 0;

        for (int i=m-1; i>=0; i--) {
            int[] dp = new int[n+1];
            dp[n] = 0;

            for (int j=n-1; j>=0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[j] = 1 + prev[j+1];
                }
                else dp[j] = Math.max(prev[j], dp[j+1]);
            }
            prev = dp;
        }
        return prev[0];
    }




    // **********MEMOIAZATION***********
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int n = text1.length(), m = text2.length();
    //     int[][] dp = new int[n][m];
    //     Arrays.stream(dp).forEach(row -> Arrays.fill(row,-1));
    // 
    //     return backtrack(text1,text2, dp, n-1,m-1);
    // }
    // 
    // public static int backtrack(String s1, String s2, int[][] dp, int i, int j) {
    //     if (i<0 || j<0) return 0;
    //     if (dp[i][j] != -1) return dp[i][j];
    // 
    //     if (s1.charAt(i) == s2.charAt(j))
    //         return 1 + backtrack(s1,s2, dp, i-1,j-1);
    // 
    //     int left = backtrack(s1,s2, dp, i-1,j);
    //     int right = backtrack(s1,s2, dp, i,j-1);
    //     return dp[i][j] = Math.max(left, right);
    // }




    // ********* T-L-E *************(Recursion)
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int i = text1.length()-1;
    //     int j = text2.length()-1;
    //     return backtrack(text1,text2, i,j);
    // }
    // 
    // public static int backtrack(String s1, String s2, int i, int j) {
    //     if (i<0 || j<0) return 0;
    // 
    //     if (s1.charAt(i) == s2.charAt(j))
    //         return 1 + backtrack(s1,s2, i-1,j-1);
    // 
    //     int left = backtrack(s1,s2, i-1,j);
    //     int right = backtrack(s1,s2, i,j-1);
    //     return Math.max(left, right);
    // }
}

// https://leetcode.com/problems/longest-common-subsequence/description/

/*
 * 1143. Longest Common Subsequence
 * 
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
 */