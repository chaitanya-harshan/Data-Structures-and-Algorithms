/*
 * Given a string s, return the longest palindromic substring in s.
Example 1: Input: s = "babad" 
Output: "bab" Explanation: "aba" is also a valid answer.

Example 2: Input: s = "cbbd" 
Output: "bb"
 */

package strings.medium;

public class _06_long_plaindrome_subString {

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i=0; i<s.length(); i++) {
            int odd = expandFromMiddle(s, i, i);
            int even = expandFromMiddle(s, i, i+1);
            int len = Math.max(odd, even);
            // updating the max length of palindrome in terms of start & end
            if (len > end-start+1) { // end-start+1 is length of the prev largest palindrome
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }

    static int expandFromMiddle(String s, int left, int right) {
        // if (right >= s.length()) return 1;
        // for when i = n then i+1 goes out of bounds
        // but this line is not even needed as it already checks in while loop
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
