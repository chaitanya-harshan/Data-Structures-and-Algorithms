package __concepts.palindrome;

public class construct_k_palindrome_strings {

    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        int[] map = new int[26];
        int odd = 0;

        for (char c : s.toCharArray()) map[c-'a']++;
        for (int i : map) odd += i % 2;

        return odd <= k ? true: false;
    }
    // all u need is that the odd doesnt exceed 'k' then the even elements 
    // can be added to any string/palindrome as needed to not exceed the count 'k'
    // if there are less palindromes then we can even create a new plaindrome for eg:
    // 'aa' or 'cc' but if a palindrome can only contain one odd char.
    // if u have something like 'aaa', u can use 2 'a's as plaindrome or add it to other
    // strings but u'd still be left with 1 'a' which acts as a odd one 

    // a  n  e  l  b
    // 2  2  2  2  1

    // aa  nel-b-len
    // anna    el-b-le
    // aneena   lbl
    // anellena    b
}

/*
 * 1400. Construct K Palindrome Strings
https://leetcode.com/problems/construct-k-palindrome-strings/description/

Given a string s and an integer k, return true if you can use all the characters in s to construct k palindrome strings or false otherwise.

Example 1:

Input: s = "annabelle", k = 2
Output: true
Explanation: You can construct two palindromes using all characters in s.
Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
Example 2:

Input: s = "leetcode", k = 3
Output: false
Explanation: It is impossible to construct 3 palindromes using all the characters of s.
Example 3:

Input: s = "true", k = 4
Output: true
Explanation: The only possible solution is to put each character in a separate string.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= 105
 */