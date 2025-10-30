package two_pointers.neetcode.sliding_window_variable_size;

import java.util.HashMap;

/*
 * Problem: Find the longest substring containing same letters after performing at most k replacements
 * 
 * Approach:
 * 1. Use sliding window with HashMap to track character frequencies
 * 2. For a valid window: length of window - count of most frequent char ≤ k
 *    (This means we can replace all other characters within our k limit)
 * 3. When window becomes invalid, shrink from left until valid again
 * 
 * Example: "AABABBA", k=1
 * Valid window must satisfy: windowLength - maxFrequency ≤ k
 * This means: number of characters to replace ≤ k
 */
public class longest_repeating_chars_subStr_with_replacemtns {
    
    public int characterReplacement(String s, int k) {
        // Track frequency of each character in current window
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0, maxLen = 0, l = 0;

        for (int r = 0; r<s.length(); r++) {
            // Add right character to window and update its frequency
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c,0)+1);
            // Update max frequency if current char's frequency is higher
            maxFreq = Math.max(maxFreq, map.get(c));

            int len = r-l+1;
            // If window is valid (chars to replace ≤ k), update maxLen
            if ((len - maxFreq) <= k) maxLen = Math.max(maxLen, len);

            // If window invalid (need more replacements than k allows)
            while (r-l+1 - maxFreq > k) {
                char lc = s.charAt(l);
                map.put(lc, map.get(lc)-1);
                l++;

                // maxFreq = Collections.max(map.values());

                // NOT Needed as since u used up for all your k, only then you're here
                // it means now to get more maxLen (mF + k) u need more maxFreq so u dont care about
                // reducing maxFreq just because u removed a Left char as in the future if you really 
                // have a bigger maxLen then it means you'll get bigger mF which then will become the 
                // new mf in max(mf, new mf) i.e -> if you are 
                // getting a bigger len then it means your maxFreq is obviously going to be
                // greater as thats the only way as u already used up all your 'k'

                // by reducing len but not mF the new len will satisfy the condition but u don't care
                // as the new lenght is lesser than the current MaxLength.
                // The only way you'll get bigger ML is by getting bigger mF as u already used up ur 'k'
                // and got the maxLen possible as of now.
                //____________________________________________________________

                // **** READ THIS FIRST ****
                // Note: We don't need to update maxFreq when removing characters
                // Because:
                // 1. If we remove the most frequent char, we're making window smaller anyway
                // 2. To get a longer valid window later, we'll need a higher maxFreq
                // 3. The current maxFreq acts as historical maximum which is fine
                // as we only care about maxLen
            }
        }
        return maxLen;
    }
}

/*
 * URL: https://leetcode.com/problems/longest-repeating-character-replacement/description/

424. Longest Repeating Character Replacement

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.

 
Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.

 
Constraints:

	1 <= s.length <= 105
	s consists of only uppercase English letters.
	0 <= k <= s.length
 */