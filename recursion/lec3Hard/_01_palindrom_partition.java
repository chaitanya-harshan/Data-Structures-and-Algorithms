package recursion.lec3Hard;

import java.util.ArrayList;
import java.util.List;

public class _01_palindrom_partition {
    List<List<String>> res = new ArrayList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(new ArrayList<>(), 0);
        return res;
    }

    public void dfs(List<String> path, int i) {
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j=i; j<s.length(); j++) {
            if (isPalindrome(i,j)) {
                path.add(s.substring(i,j+1));
                dfs(path, j+1);
                path.removeLast();
            }
        }
    }

    boolean isPalindrome(int l, int r) {
        if (l == r) return true;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}

//                                                (aabb)
//                  [a]abb ----------------- [aa]bb ------ [aab]b ----- [aabb]
//         [a]bb-----[ab]b----[abb]      [b]b------[bb]       X           X
//     [b]b---[bb]     X        X         [b]        |
//     [b]      |                          |      {aa,bb}
//      |     {a,a,bb}                  {aa,b,b}   
//   {a,a,b,b}



/*
 * URL: https://leetcode.com/problems/palindrome-partitioning/description/

131. Palindrome Partitioning

Given a string s, partition s such that every  of the partition is a . Return all possible palindrome partitioning of s.

 
Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:
Input: s = "a"
Output: [["a"]]

 
Constraints:

	1 <= s.length <= 16
	s contains only lowercase English letters.
 */