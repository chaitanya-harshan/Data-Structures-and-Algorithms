package __concepts.palindrome;

public class shortest_Palindrome_HARD {
    // Hard difficulty
    // Reference: https://www.youtube.com/watch?v=niOT-FK1RH8
    // Rabin karp [or] Rolling Hash Algorithm
    /* 
     * Intuition and Concept:
     * 1. We want to find the longest palindrome prefix in the string
     *    - For "aacecaaa", longest palindrome prefix is "aacecaa"
     *    - For "abcd", longest palindrome prefix is "a"
     * 
     * 2. Rolling Hash Approach:
     *    - We compute two hashes simultaneously:
     *      a) front_hash: reads string left to right
     *      b) reverse_hash: reads string right to left
     *    - When these hashes match, we've found a palindrome prefix
     * 
     * 3. How it works:
     *    - For string "aacecaa":
     *      front_hash:  a → aa → aac → aace → aacec → aaceca → aacecaa
     *      reverse_hash: a → aa → aac → aace → aacec → aaceca → aacecaa
     *    - When hashes match at index i, string[0...i] is a palindrome
     *    
     *    Base-26 Hash Calculation:
     *    - Each char is converted to 1-26 (a=1, b=2, etc)
     *    - front_hash: multiply previous hash by 26 and add new char
     *      Example for "abc":
     *      Step 1: a = 1
     *      Step 2: (1 * 26) + 2 = 28
     *      Step 3: (28 * 26) + 3 = 731
     *    
     *    - reverse_hash: add (char * power) to previous hash
     *      Example for "abc":
     *      Step 1: c = 3
     *      Step 2: (b * 26) + 3 = (2 * 26) + 3 = 55
     *      Step 3: (a * 26^2) + 55 = (1 * 676) + 55 = 731
     *    
     *    - Using numeric hashes allows O(1) comparison instead of
     *      O(n) string comparison. MOD is used to prevent overflow.
     * 
     * 4. Final Step:
     *    - Take remaining characters after longest palindrome prefix
     *    - Reverse them and add to front of original string
     *    Example: "aacecaaa" → longest prefix "aacecaa" → add "a" reversed = "aaacecaaa"
     */
    public String shortestPalindrome(String s) {
        long front = 0; // front_hash26
        long reverse = 0; // reverse_hash26
        long power = 1;
        int last_idx = -1;
        final long MOD = 1_000_000_000 + 7; //(int)1e9 + 7

        for (int i=0; i<s.length(); i++) {
            int c = s.charAt(i) - 'a' +1;

            front = ((front * 26)%MOD + c) % MOD;
            reverse = (c*power + reverse) % MOD;
            power = (power * 26) % MOD;
            // (A×(B%M))%M = (A×B)%M
            // MOD Arithmetics: @likhit's gpt-4o
            // https://chatgpt.com/c/677cfab7-4668-8004-b190-b9b0a09b762b

            if (front == reverse) last_idx = i;
        }

        last_idx++;
        String suffix_str = s.substring(last_idx);
        return new StringBuilder(suffix_str).reverse().toString() + s;
    }
}

/*
 * 214. Shortest Palindrome
https://leetcode.com/problems/shortest-palindrome/description/

You are given a string s. You can convert s to a 
palindrome
 by adding characters in front of it.

Return the shortest palindrome you can find by performing this transformation.

 

Example 1:

Input: s = "aacecaaa"
Output: "aaacecaaa"
Example 2:

Input: s = "abcd"
Output: "dcbabcd"
 

Constraints:

0 <= s.length <= 5 * 104
s consists of lowercase English letters only.
 */