package __concepts.two_pointers;

import java.util.HashMap;

public class count_substr_with_all_vowels_and_k_consonents_2 {
    public long countOfSubstrings(String word, int k) {
        return sub_str_k_plus(word, k) - sub_str_k_plus(word, k+1); 
    }

    public long sub_str_k_plus(String word, int k) {
        int l = 0;
        int consonent = 0;
        long cnt = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int r=0; r<word.length(); r++) {
            char c = word.charAt(r);
            if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
                map.put(c, map.getOrDefault(c, 0)+1);
            }
            else consonent++;

            while (map.size() == 5 && consonent >=  k) {
                cnt += (long)word.length() - r;

                char ch = word.charAt(l);
                if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                    map.put(ch, map.get(ch)-1);
                    if (map.get(ch) == 0) map.remove(ch);
                }
                else consonent--;
                l++;
            }
        }
        return cnt;
    }
}

/*
 * 3306. Count of Substrings Containing Every Vowel and K Consonants II
https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/
You are given a string word and a non-negative integer k.

Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.

 

Example 1:

Input: word = "aeioqq", k = 1

Output: 0

Explanation:

There is no substring with every vowel.

Example 2:

Input: word = "aeiou", k = 0

Output: 1

Explanation:

The only substring with every vowel and zero consonants is word[0..4], which is "aeiou".

Example 3:

Input: word = "ieaouqqieaouqq", k = 1

Output: 3

Explanation:

The substrings with every vowel and one consonant are:

word[0..5], which is "ieaouq".
word[6..11], which is "qieaou".
word[7..12], which is "ieaouq".
 

Constraints:

5 <= word.length <= 2 * 105
word consists only of lowercase English letters.
0 <= k <= word.length - 5
 */