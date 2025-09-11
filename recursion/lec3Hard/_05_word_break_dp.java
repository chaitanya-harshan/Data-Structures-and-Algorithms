package recursion.lec3Hard;

import java.util.Arrays;
import java.util.List;

public class _05_word_break_dp {
    public static void main(String[] args) {
        // this is too big of a number to be solved by recurson. we need to use dp
        // since there is a b in the end the it'll check for all the iteratons hence the big number but if there is no b at the end then it'll solve easily
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] dict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        System.out.println(wordBreak(s, Arrays.asList(dict)));
    }

    // public static boolean wordBreak(String s, List<String> wordDict) {
    //     return dfs(0, s, wordDict);
    // }
    // 
    // static boolean dfs(int i, String s, List<String> wordDict) {
    //     System.out.println(i);
    //     if (i == s.length()) return true;
    //    
    //     for (String word : wordDict) {
    //         if (i+word.length() <= s.length() && s.substring(i, i+word.length()).equals(word) ) {
    //             if (dfs(i+word.length(), s, wordDict) == true) return true;
    //         }
    //     }
    //     return false;
    // }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[dp.length-1] = true;

        for (int i = s.length()-1; i>=0; i--) {
            for (String w: wordDict) {
                if (i+w.length() <= s.length() && s.substring(i,i+w.length()).equals(w) ) {
                    dp[i] = dp[i + w.length()];
                }
                if (dp[i] == true) break;
            }
        }
        return dp[0];
    }
}

/*
https://www.youtube.com/watch?v=Sx9NNgInc3A
https://leetcode.com/problems/word-break/description/

 * 39. Word Break
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
 */

