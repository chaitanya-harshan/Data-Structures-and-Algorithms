package __concepts.parenthesis;

public class check_if_parenthesis_str_can_be_valid {
    // u need to watch NeetCode video for this and that other video too
    // https://youtu.be/KMIIGDiXLhY - NeetCode
    // https://www.youtube.com/watch?v=8Svn_u41rt8 - Techdose

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) return false;
        int open = 0, wildcard = 0, close = 0;
        
        for (int i=0; i<s.length(); i++) {
            if (locked.charAt(i) == '0') wildcard++;
            else if (s.charAt(i) == '(') open++;
            // Here wc & o are the same thing so u can just use close count and then make sure o+wc >= c
            else {
                if (open > 0) open--;
                else if (wildcard > 0) wildcard--;
                else return false;
            }
        }

        wildcard = 0;
        for (int i=s.length()-1; i>=0; i--) {
            if (locked.charAt(i) == '0') wildcard++;
            else if (s.charAt(i) == ')') close++;
            else {
                if (close > 0) close--;
                else if (wildcard > 0) wildcard--;
                else return false;
            }
        }
        
        return true;
    }
        
    // ----- GREEDY (better)-----------
    /**
     
     * The thought process of the code:
     * 1. Initialize two counters, minOpen and maxOpen, to track the minimum and maximum number of open parentheses.
     * 3. Iterate through each character in the string s:
     *    a. If the character is locked ('1'):
     *       i. If it is an open parenthesis '(', increment both minOpen and maxOpen.
     *       ii. If it is a close parenthesis ')', decrement both minOpen and maxOpen.
     *    b. If the character is unlocked ('0'):
     *       i. Decrement minOpen (considering it as a close parenthesis).
     *       ii. Increment maxOpen (considering it as an open parenthesis).
     * 4. Ensure minOpen does not go below 0.
     * 5. If maxOpen goes below 0, return false as it indicates an invalid state.
     * 6. After the loop, return true if minOpen is 0, indicating a valid parentheses string.
     */
    public boolean canBeValid1(String s, String locked) {
        int minOpen = 0, maxOpen = 0;
        if (s.length() % 2 == 1) return false;

        for (int i=0; i<s.length(); i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    minOpen++;
                    maxOpen++;
                }
                else {
                    minOpen--;
                    maxOpen--;
                }
            }
            else {
                minOpen--;
                maxOpen++;
            }

            if (minOpen < 0) minOpen = 0;
            if (maxOpen < 0) return false;
        }
        return minOpen == 0; 
    }
}
