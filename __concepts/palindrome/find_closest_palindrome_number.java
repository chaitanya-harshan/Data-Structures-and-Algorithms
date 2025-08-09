/*
 * 5 steps/checks to solve the problem:
 * 
 * mirror the first half (prefix) of the number to create a palindrome
 * mirror the first half minus one to create a smaller palindrome
 * mirror the first half plus one to create a larger palindrome
 * 10^(len-1) - 1 (e.g. 999 for len=3)
 * 10^len + 1 (e.g. 1001 for len=3
 * 
 * Now check which gives the closest palindrome to the original number.
 */

import java.util.HashSet;

public class find_closest_palindrome_number {

    public String nearestPalindromic(String n) {
        int len = n.length();
        if (len == 1) {
            if (n.equals("0")) return "1";
            else return "" + (n.charAt(0)-'1');
        }

        long og = Long.parseLong(n);
        boolean odd = (len % 2) != 0;
        HashSet<Long> set = new HashSet<>();

        String prefix = n.substring(0, (len + 1)/2);
        long prefix_num = Long.parseLong(prefix);

        set.add(buildPalindrome(prefix_num, odd));
        set.add(buildPalindrome(prefix_num-1, odd));
        set.add(buildPalindrome(prefix_num+1, odd));
        set.add((long)Math.pow(10, len-1)-1);
        set.add((long)Math.pow(10,len)+1);

        set.remove(og);

        long min = 0;
        long minDiff = Long.MAX_VALUE;
        for (long pal: set) {
            long diff = Math.abs(pal - og);
            if (diff < minDiff) {
                min = pal;
                minDiff = diff;
            }
            else if (diff == minDiff && pal < min) min = pal;
        }

        return String.valueOf(min);
    }

    public Long buildPalindrome(long prefix_number, boolean odd) {
        String prefix = String.valueOf(prefix_number);
        String left = new String(prefix);
        if (odd) prefix = prefix.substring(0, prefix.length()-1);
        String palindrome = left + new StringBuilder(prefix).reverse().toString();
        return Long.parseLong(palindrome);
    }
}

/*
 * 564. Find the Closest Palindrome
 * https://leetcode.com/problems/find-the-closest-palindrome/description/
 * 
Solved
Hard
Topics
premium lock icon
Companies
Hint
Given a string n representing an integer, return the closest integer (not including itself), which is a palindrome. If there is a tie, return the smaller one.

The closest is defined as the absolute difference minimized between two integers.

 

Example 1:

Input: n = "123"
Output: "121"
Example 2:

Input: n = "1"
Output: "0"
Explanation: 0 and 2 are the closest palindromes but we return the smallest which is 0.
 

Constraints:

1 <= n.length <= 18
n consists of only digits.
n does not have leading zeros.
n is representing an integer in the range [1, 1018 - 1].
 */