
package recursion.lec2;

import java.util.ArrayList;
import java.util.List;

public class _01_binary_strings {
    public static void main(String[] args) {
        System.out.println(validStrings(3));
        System.out.println(validStrings(4));
    }

    static List<String> res;

    public static List<String> validStrings(int n) {
        res = new ArrayList<>();
        generateBinaryStrings("0", n-1);
        generateBinaryStrings("1", n-1);
        return res;
    }

    public static void generateBinaryStrings(String s, int n) {
        if (n == 0) {
            res.add(s);
            return;
        }

        if (s.charAt(s.length()-1) == '0') generateBinaryStrings(s+'1', n-1);
        else {
            generateBinaryStrings(s+'0', n-1);
            generateBinaryStrings(s+'1', n-1);
        }
    }
}

// This is a similar sum.

/*
 * URL: https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/description/

3211. Generate Binary Strings Without Adjacent Zeros

You are given a positive integer n.
A binary string x is valid if all  of x of length 2 contain at least one "1".
Return all valid strings with length n, in any order.

 
Example 1:
Input: n = 3
Output: ["010","011","101","110","111"]
Explanation:
The valid strings of length 3 are: "010", "011", "101", "110", and "111".
Example 2:
Input: n = 1
Output: ["0","1"]
Explanation:
The valid strings of length 1 are: "0" and "1".

 
Constraints:

	1 <= n <= 18
 */