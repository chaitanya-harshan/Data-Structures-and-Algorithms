package strings.extras;

import java.util.ArrayList;
import java.util.List;

public class wod_subsets {
    
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] m2 = new int[26];

        // Calculate the maximum frequency of each character required by all words in words2
        for (String word: words2) {
            int[] m3 = new int[26];
            for (char c: word.toCharArray()) {
                int i = c-'a';
                m3[i]++;
                if (m3[i] > m2[i]) m2[i] = m3[i];
            }
        }

        List<String> res = new ArrayList<>();
        // Check each word in words1 to see if it is a universal word
        for (String word: words1) {
            int[] m1 = new int[26];
            for (char c: word.toCharArray()) {
                m1[c-'a']++;
            }

            boolean flag = true;
            // Verify if the word contains all characters with required frequencies
            for (int i=0; i<26; i++) {
                if (m1[i] < m2[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.add(word);
        }
        return res;
    }
}

/*
 * 916. Word Subsets
https://leetcode.com/problems/word-subsets/description/

You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

 

Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]
 

Constraints:

1 <= words1.length, words2.length <= 104
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.
 */