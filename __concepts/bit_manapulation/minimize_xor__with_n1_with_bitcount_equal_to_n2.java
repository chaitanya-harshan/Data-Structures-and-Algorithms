package __concepts.bit_manapulation;

public class minimize_xor__with_n1_with_bitcount_equal_to_n2 {
    
    public int minimizeXor(int num1, int num2) {
        int bc2 = Integer.bitCount(num2); // bit count
        int bc1 = Integer.bitCount(num1);

        int diff = Math.abs(bc2 - bc1);
        int x = num1, idx = 0;

        if (bc1 > bc2) {
            while (diff > 0) {
                if ((x >> idx & 1) == 1) { // & is more precedence
                    x ^= 1 << idx;
                    diff--;
                }
                idx++;
            }
        }
        else {
            while (diff > 0) {
                if ((x >> idx & 1) == 0) {
                    // x ^= 1 << idx;
                    x |= (1 << idx);
                    diff--;
                }
                idx++;
            }
        }
        
        return x;
    }
}

// -> more bits
// 11001101
// 11001000
// -> less bits
// 11001000  1100101
// 11001011  1101111

/*
 * 2429. Minimize XOR
https://leetcode.com/problems/minimize-xor/description/

Given two positive integers num1 and num2, find the positive integer x such that:

x has the same number of set bits as num2, and
The value x XOR num1 is minimal.
Note that XOR is the bitwise XOR operation.

Return the integer x. The test cases are generated such that x is uniquely determined.

The number of set bits of an integer is the number of 1's in its binary representation.

 

Example 1:

Input: num1 = 3, num2 = 5
Output: 3
Explanation:
The binary representations of num1 and num2 are 0011 and 0101, respectively.
The integer 3 has the same number of set bits as num2, and the value 3 XOR 3 = 0 is minimal.
Example 2:

Input: num1 = 1, num2 = 12
Output: 3
Explanation:
The binary representations of num1 and num2 are 0001 and 1100, respectively.
The integer 3 has the same number of set bits as num2, and the value 3 XOR 1 = 2 is minimal.
 

Constraints:

1 <= num1, num2 <= 109
 */
