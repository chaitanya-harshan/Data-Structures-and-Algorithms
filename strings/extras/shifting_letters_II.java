package strings.extras;

public class shifting_letters_II {
    /*
     * Problem: Given a string and array of shifts where each shift contains [start, end, direction],
     * we need to shift characters in the given range (start to end inclusive) forward if direction=1 
     * or backward if direction=0.
     * 
     * Solution approach: Using prefix sum technique to efficiently handle multiple shifts
     * 1. Instead of processing each shift operation separately (which would be O(n*k)), 
     * 2. We use a difference array to mark the boundaries where shifts begin and end
     * 3. Then accumulate these differences to get the final shift count for each position
     */
    public String shiftingLetters(String s, int[][] shifts) {
        // difference array to store the shift impact at each position
        int[] charShift = new int[s.length()];

        // Process each shift operation
        for (int j=0; j<shifts.length; j++) {
            int start = shifts[j][0], end = shifts[j][1], direction = shifts[j][2];
            // Add +1 at start index for forward shift, -1 for backward shift
            charShift[start] += direction == 1 ? 1 : -1;
            // Cancel out the shift effect after the end index (if within bounds)
            // This ensures the shift only affects characters within the range [start, end]
            if (end+1 < charShift.length) charShift[end+1] += direction == 1? -1 : 1;
        } 

        // Running sum to accumulate all shifts affecting current position
        int shiftDiff = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < charShift.length; i++) {
            // Accumulate shifts and normalize to [0-25] range
            shiftDiff = (shiftDiff + charShift[i]) % 26; // Very Imp to do %26
            // here if shiftDiff is < -25 then even after adding 26 then 'c' becomes
            // less than a => 'c' will not in [a-z]
            // Therefore for the sake of -ve nums we need to normalize shiftDiff to 
            // be inside [0 - 25] in every iteration

            // Calculate new character:
            // 1. s.charAt(i)-'a' converts char to 0-based index (a=0, b=1, etc)
            // 2. Add shiftDiff to move forward/backward
            // 3. Add 26 and mod 26 to handle negative shifts and wrap around
            // 4. Add 'a' to convert back to character
            char c = (char)('a' + (s.charAt(i)-'a' + shiftDiff + 26)%26);
            res.append(c);
        }

        return res.toString();
    }
}


/*
 * 2381. Shifting Letters II
https://www.youtube.com/watch?v=eEUjVY7wK3k

You are given a string s of lowercase English letters and a 2D integer array shifts where shifts[i] = [starti, endi, directioni]. For every i, shift the characters in s from the index starti to the index endi (inclusive) forward if directioni = 1, or shift the characters backward if directioni = 0.

Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Similarly, shifting a character backward means replacing it with the previous letter in the alphabet (wrapping around so that 'a' becomes 'z').

Return the final string after all such shifts to s are applied.

 

Example 1:

Input: s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
Output: "ace"
Explanation: Firstly, shift the characters from index 0 to index 1 backward. Now s = "zac".
Secondly, shift the characters from index 1 to index 2 forward. Now s = "zbd".
Finally, shift the characters from index 0 to index 2 forward. Now s = "ace".
Example 2:

Input: s = "dztz", shifts = [[0,0,0],[1,1,1]]
Output: "catz"
Explanation: Firstly, shift the characters from index 0 to index 0 backward. Now s = "cztz".
Finally, shift the characters from index 1 to index 1 forward. Now s = "catz".
 

Constraints:

1 <= s.length, shifts.length <= 5 * 104
shifts[i].length == 3
0 <= starti <= endi < s.length
0 <= directioni <= 1
s consists of lowercase English letters.
 */