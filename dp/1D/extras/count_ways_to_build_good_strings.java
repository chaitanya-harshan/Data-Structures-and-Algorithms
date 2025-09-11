package extras;

public class count_ways_to_build_good_strings {
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = 1_000_000_007;

        // dp[i] will store the number of ways to construct a string of length i.
        int[] dp = new int[high + 1];
        // Base case: There is one way to form an empty string (the string of length 0).
        dp[0] = 1;

        int goodStringsCount = 0;

        // Iterate from length 1 up to the maximum possible length, high.
        for (int i = 1; i <= high; i++) {
            // A string of length 'i' can be formed by two ways:
            // 1. Appending a '*0*' string (length `zero`) to a previous string of length `i - zero`.
            if (i >= zero) {
                dp[i] = (0 + dp[i - zero]) % MOD;
                // ~ dp[i] = (d[i] + dp[i - zero]) % MOD; ----- as dp initial value is zero so using 0 is fine
            }

            // 2. Appending a '*1*' string (length `one`) to a previous string of length `i - one`.
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % MOD; 
                // can't use o here for dp[i] cause you have to add to it not replace
            }

            // If the current length 'i' is within the [low, high] range,
            if (i >= low) {
                goodStringsCount = (goodStringsCount + dp[i]) % MOD;
            }
        }

        return goodStringsCount;
    }

/*
 * 2466. Count Ways To Build Good Strings
https://leetcode.com/problems/count-ways-to-build-good-strings/description/

Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at each step perform either of the following:

Append the character '0' zero times.
Append the character '1' one times.
This can be performed any number of times.

A good string is a string constructed by the above process having a length between low and high (inclusive).

Return the number of different good strings that can be constructed satisfying these properties. Since the answer can be large, return it modulo 109 + 7.

 

Example 1:

Input: low = 3, high = 3, zero = 1, one = 1
Output: 8
Explanation: 
One possible valid good string is "011". 
It can be constructed as follows: "" -> "0" -> "01" -> "011". 
All binary strings from "000" to "111" are good strings in this example.
Example 2:

Input: low = 2, high = 3, zero = 1, one = 2
Output: 5
Explanation: The good strings are "00", "11", "000", "110", and "011".
 

Constraints:

1 <= low <= high <= 105
1 <= zero, one <= low
 */