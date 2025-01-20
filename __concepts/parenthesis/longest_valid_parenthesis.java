package _extras.paranthesis;

import java.util.Stack;

// https://leetcode.com/problems/longest-valid-parentheses/
// https://youtu.be/CPEDLKfaQJE

public class longest_valid_parenthesis {
    
    public int longestValidParentheses(String s) {
        // STACK - uses some memory
        Stack<Integer> st = new Stack<>();
        st.push(-1); // as the base value
        int max = 0;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') st.push(i);
            else if (c == ')') {
                st.pop();
                if (!st.empty()) {
                    max = Math.max(max, i - st.peek());
                }
                else st.push(i);
            }
        }
        return max;

        // **************** TWO POINTER ************
        // ---------iterating from front & back------
        // int open = 0, close = 0;
        // int max = 0;

        // for (char c: s.toCharArray()) {
        //     if (c == '(') open++;
        //     else close++;

        //     if (open == close) 
        //         max = Math.max(max, open + close);

        //     if (close > open) 
        //         open = close = 0;
        // }

        // open = close = 0;

        // for (char c: new StringBuilder(s).reverse().toString().toCharArray()) {
        //     if (c == '(') open++;
        //     else close++;

        //     if (open == close) 
        //         max = Math.max(max, open + close);
                
        //     if (open > close) 
        //         open = close = 0;
        // }
        // return max;
    }
}

/*
 * 32. Longest Valid Parentheses
https://leetcode.com/problems/longest-valid-parentheses/

Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.

Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:
Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
 */