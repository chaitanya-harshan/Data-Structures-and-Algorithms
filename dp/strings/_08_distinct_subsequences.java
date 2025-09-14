package dp.strings;

import java.util.Arrays;

public class _08_distinct_subsequences {
    // In the longest common subsequence problem, we seek the maximum length subsequence.
    // Here, we count the number of distinct ways to form string T from S as a subsequence.
    // Unlike LCS, we must match all of T, and every match or skip in S is considered.
    // We never skip characters in T on mismatch, ensuring all possible subsequences are counted.
    // Therefore we don't need the lengths of lcs at (i,j), just the counts.
    
    public int numDistinct(String s, String t) {
        // dp[i][j] --> how many subsq of t starting at 'j' can u make from s starting at 'i'
        int n = s.length(), m = t.length();
        int[] prev = new int[m+1];
        prev[m] = 1; // how many subsq can u form from s when t is zero len

        for (int i=n-1; i>=0; i--) {
            int[] dp = new int[m+1];
            dp[m] = 1; // how many subsq can u form from s when t is zero len

            for(int j=m-1; j>=0; j--) {
                if (s.charAt(i) == t.charAt(j)) dp[j] = prev[j+1] + prev[j]; // { take noTake }
                else dp[j] = prev[j];
            }
            prev = dp;
        }
        return prev[0];
    }

    //__________________________________________________________________________________________________________________
    int[][] dp;
    String s,t;
    int n, m;

    public int numDistinct1(String s, String t) {
        this.n = s.length();
        this.m = t.length();
        dp = new int[n+1][m+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        this.s = s;
        this.t = t;

        dfs(0,0);
        return dp[0][0];
    }

    int dfs(int i, int j) {
        if (j == m) return 1;
        if (i == n) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = dfs(i+1,j+1) + dfs(i+1,j);
        }
        else dp[i][j] = dfs(i+1, j);

        return dp[i][j];
    } 
}

/*
 * URL: https://leetcode.com/problems/distinct-subsequences/description/

115. Distinct Subsequences

Given two strings s and t, return the number of distinct subsequences of s which equals t.
The test cases are generated so that the answer fits on a 32-bit signed integer.

 
Example 1:
Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit
Example 2:
Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag

 
Constraints:

	1 <= s.length, t.length <= 1000
	s and t consist of English letters.
 */