package two_pointers.neetcode.sliding_window_variable_size;

import java.util.HashMap;

public class longest_subString_without_repeating_chars {
    
    public int lengthOfLongestSubstring(String s) {
        // This helps us track the last position where we saw each character
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0;
        
        for (int r = 0; r < s.length(); r++) {
            // If current character was seen before and its last position is >= left pointer
            // we need to move left pointer to avoid repeating characters
            if (map.containsKey(s.charAt(r))) {
                // Move left pointer to position after the last occurrence
                // Math.max ensures we don't move left pointer backwards
                // Example: for "abdc[d]acb", when we see second 'a' again 'l' 
                // shouldn't be less then the curr 'l' which is idx[d], 
                // we don't want to move left pointer back to first 'a'
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }
            
            // Update most recent position of current character
            map.put(s.charAt(r), r);
            maxLen = Math.max(r-l+1, maxLen);
        }
        return maxLen;
    }



    // ---------------HASH_SET------------neetcode
        // HashSet<Character> set = new HashSet<>();
        // int len = 0, maxLen = 0;
        // int l = 0;

        // for (int r=0; r<s.length(); r++) {
        //     while (set.contains(s.charAt(r)) ) {
        //         set.remove(s.charAt(l));
        //         l++;
        //     }
        //     set.add(s.charAt(r));
        //     len = r-l+1;
        //     maxLen = Math.max(len, maxLen);
        // }
        // return maxLen;


/*
    * 3. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
         */