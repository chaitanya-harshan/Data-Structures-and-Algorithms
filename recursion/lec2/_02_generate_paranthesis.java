/*
 * 22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Input: n = 1
Output: ["()"]
 */

package recursion.lec2;

import java.util.ArrayList;
import java.util.List;

public class _02_generate_paranthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, "", 0, 0, n);
        return list;
    }

    static void generate(List<String> list, String str, int open, int close, int n) {
        // if (close > open) return;
        if (open == n && close == n) {
            list.add(str);
            return;
        }

        if (open < n) generate(list, str+'(', open+1, close, n);
        if (close < n && close < open) generate(list, str+')', open, close+1, n);
    }
}