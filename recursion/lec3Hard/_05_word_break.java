package recursion.lec3Hard;

import java.util.HashSet;
import java.util.List;

public class _05_word_break {
    // This is noob code. we need to use dp + memoization to optimize it
    HashSet<String> set;
    int[] memo; // 1-true; 2-false; 0-not_searched_yet

    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict);
        this.memo = new int[s.length()+1];

        return bt(0, s);
    }

    boolean bt(int k, String s) {
        if (k == s.length()) return true;
        if (memo[k] != 0) return memo[k] == 1 ? true: false;

        for (int i=k+1; i<=s.length(); i++) {
            if (set.contains(s.substring(k,i))) {
                if (bt(i,s)) {
                    memo[i] = 1;
                    return true;
                }
            }
        }
        memo[k] = 2;
        return false;
    }
}

/*
 * URL: https://leetcode.com/problems/word-break/description/

139. Word Break

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

 
Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

 
Constraints:

	1 <= s.length <= 300
	1 <= wordDict.length <= 1000
	1 <= wordDict[i].length <= 20
	s and wordDict[i] consist of only lowercase English letters.
	All the strings of wordDict are unique.
 */