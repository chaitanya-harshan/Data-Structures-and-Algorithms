package arrays.medium.similar;

import java.util.HashSet;

public class _04_substring_with_largest_vairance {
    // we take major as +1 & minor as -1 and find max subArr sum using kadane's algo
    // But we need atleast 1 minor in the subArr so we do 2 passes(forward & reverse) 
    // to accomodate the issue where minor's are in the front and kadan'e algo reset the variance
    // which would result in no ans when there is one.
    public int largestVariance(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);

        int maxVariance = 0;
        for (char major: set) {
            for (char minor : set) {
                if (major == minor) continue;

                for (int i=0; i<2; i++) {
                    int variance = 0;
                    int minorCnt = 0;

                    for (char c : s.toCharArray()) {
                        if (c == major) variance++;
                        else if (c == minor) {
                            variance--;
                            minorCnt++;
                        }
                        if (variance < 0) {
                            variance = 0;
                            minorCnt = 0;
                        }
                        if (minorCnt > 0) maxVariance = Math.max(maxVariance, variance); 
                    }
                    s = new StringBuilder(s).reverse().toString();
                }
            }
        }
        return maxVariance;
    }
}

/*
 * URL: https://leetcode.com/problems/substring-with-largest-variance/description/

2272. Substring With Largest Variance

The variance of a string is defined as the largest difference between the number of occurrences of any 2 characters present in the string. Note the two characters may or may not be the same.
Given a string s consisting of lowercase English letters only, return the largest variance possible among all substrings of s.
A substring is a contiguous sequence of characters within a string.

 
Example 1:
Input: s = "aababbb"
Output: 3
Explanation:
All possible variances along with their respective substrings are listed below:
- Variance 0 for substrings "a", "aa", "ab", "abab", "aababb", "ba", "b", "bb", and "bbb".
- Variance 1 for substrings "aab", "aba", "abb", "aabab", "ababb", "aababbb", and "bab".
- Variance 2 for substrings "aaba", "ababbb", "abbb", and "babb".
- Variance 3 for substring "babbb".
Since the largest possible variance is 3, we return it.
Example 2:
Input: s = "abcde"
Output: 0
Explanation:
No letter occurs more than once in s, so the variance of every substring is 0.

 
Constraints:

	1 <= s.length <= 104
	s consists of lowercase English letters.
 */