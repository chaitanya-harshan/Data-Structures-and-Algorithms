package __concepts.two_pointers;

import java.util.HashMap;

public class num_of_substr_containing_all_3_chars {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int l = 0, cnt = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int r=0; r<n; r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c,0)+1);

            while (map.size() == 3) {
                cnt += n-r; 

                char ch = s.charAt(l);
                map.put(ch, map.get(ch)-1);
                if (map.get(ch) == 0) map.remove(ch);
                l++;
            }
        }
        return cnt;
    }
}
/*
 * 1358. Number of Substrings Containing All Three Characters
https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.
 */