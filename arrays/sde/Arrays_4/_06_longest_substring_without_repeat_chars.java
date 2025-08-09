import java.util.HashMap;

public class _06_longest_substring_without_repeat_chars {
    
    // ********* BOTH methods use sliding window
    public int lengthOfLongestSubstring(String s) {
    //--------------HASH_MAP-------------------striver article (better version)
        HashMap<Character, Integer> map =  new HashMap<>();
        int maxLen = 0;
        int l = 0;

        for (int r=0; r<s.length(); r++) {
            if (map.containsKey(s.charAt(r)) ) {
                l = Math.max(l, map.get(s.charAt(r))+1 );
            }
            map.put(s.charAt(r), r);
            maxLen = Math.max(r-l+1, maxLen);
        }
        return maxLen;

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
    }
}

/*
 * . Longest Substring Without Repeating Characters
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