package two_pointers.neetcode.sliding_window;

public class _04_permutation_in_string {

    /**
     * Check if s2 contains a permutation of s1
     * Time Complexity: O(n) where n is length of s2
     * Space Complexity: O(1) as we use fixed size arrays
     */
    public boolean checkInclusion(String s1, String s2) {
        // If s1 is longer than s2, permutation is impossible
        if (s1.length() > s2.length()) return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];

        // Initialize the first window:
        // Count frequencies of characters in s1 and the first s1.length() characters of s2
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i=0; i<26; i++) if (s1map[i] == s2map[i]) matches++;
        
        // If all 26 characters have matching frequencies, we found a permutation
        if (matches == 26) return true;

        // Slide the window through s2
        int l = 0;
        for (int r=s1.length(); r<s2.length(); l++, r++) {
            char lc = s2.charAt(l);  // Character leaving the window
            char rc = s2.charAt(r);  // Character entering the window

            s2map[lc-'a']--;
            if (s1map[lc-'a'] == s2map[lc-'a']) matches++;
            // If frequencies matched before but don't match now, decrement matches
            else if (s1map[lc-'a'] - 1 == s2map[lc-'a']) matches--;

            s2map[rc-'a']++;
            // If after adding, frequencies match, increment matches
            if (s1map[rc-'a'] == s2map[rc-'a']) matches++;
            // If frequencies matched before but don't match now, decrement matches
            else if (s1map[rc-'a'] + 1 == s2map[rc-'a']) matches--;
            // l++;

            // If all characters have matching frequencies, we found a permutation
            if (matches == 26) return true;
        }
        // No permutation found
        return false;
    }
}

/*
Explanation of the Algorithm:

1. Problem Understanding:
   - We need to find if any permutation of s1 exists as a substring in s2
   - Instead of generating all permutations (which would be inefficient), we use character frequency matching

2. Key Concepts:
   - Sliding Window: We maintain a window of size s1.length() in s2
   - Character Frequency: Two arrays track character counts (s1map and s2map)
   - Matches Counter: Tracks how many characters have matching frequencies

3. Algorithm Steps:
   a) Initial Check:
      - If s1 is longer than s2, return false (permutation impossible)
   
   b) Setup:
      - Create frequency arrays for both strings (size 26 for lowercase letters)
      - Initialize first window with frequencies from s1 and first window of s2
   
   c) Sliding Window:
      - For each window position:
        * Remove left character (decrease frequency)
        * Add right character (increase frequency)
        * Update matches count based on frequency changes
        * Check if all frequencies match (matches == 26)

4. Optimization Details:
   - We don't compare entire arrays each time
   - matches variable efficiently tracks matching frequencies
   - Only need to update matches for characters entering/leaving window

5. Time Complexity: O(n) where n is length of s2
   Space Complexity: O(1) as we use fixed size arrays (26 characters)
*/

/*
 * 567. Permutation in String
https://leetcode.com/problems/permutation-in-string/description/

Given two strings s1 and s2, return true if s2 contains a 
permutation
 of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
 */