package greedy.easy;

public class _05_valid_paranthesis_string {
    
    public boolean checkValidString(String s) {
        // we solve it by finding the valid range of open and close
        int min = 0, max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                min++;
                max++;
            }
            else if (c == ')') {
                min--;
                max--;
            }
            else {
                min--;
                max++;
            }

            if (max < 0) return false; // case: ))((
            if (min < 0) min = 0; // here we are basically saying ok the previous
            // '*' must be open and not close else no. of open '(' will become negative
        }
        return min == 0;
    }
}


/*
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
 */