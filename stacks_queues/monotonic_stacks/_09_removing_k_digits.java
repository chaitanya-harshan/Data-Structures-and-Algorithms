package stacks_queues.monotonic_stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class _09_removing_k_digits {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Deque<Character> st = new ArrayDeque<>();

        for (char c: num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            if (c == '0' && st.isEmpty()) continue; // to prevent leading zeros
            st.push(c);
        }

        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) res.append(st.pop());
        res.reverse();

        if (res.length() == 0) return "0";
        return res.toString();
    }

    public String removeKdigits1(String num, int k) {
        int n = num.length();
        Deque<Character> st = new ArrayDeque<>();

        for (char c: num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        while (k > 0) {
            st.pop();
            k--;
        }
        if (st.isEmpty()) return "0";

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) res.append(st.pop());
        while (res.length() > 0 && res.charAt(res.length()-1) == '0') {
            res.deleteCharAt(res.length()-1);
        }
        res.reverse();

        if (res.length() == 0) return "0";
        return res.toString();
    }
}

/*
 * URL: https://leetcode.com/problems/remove-k-digits/description/

402. Remove K Digits

Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 
Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

 
Constraints:

	1 <= k <= num.length <= 105
	num consists of only digits.
	num does not have any leading zeros except for the zero itself.
 */