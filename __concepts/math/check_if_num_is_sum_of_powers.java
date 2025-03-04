package __concepts.math;

public class check_if_num_is_sum_of_powers {
    public boolean checkPowersOfThree(int n) {
        double limit = Math.pow(10,7);
        int max = (int)Math.ceil(Math.log(limit) / Math.log(3));
        // **** once power can only be used once

        int pow = max;
        while (n > 0) {
            int val = (int)Math.pow(3,pow);
            if (pow < 0) return false;

            if (val <= n) {
                n -= val;
            }
            pow--;
            
        }
        return true;
    }
}

/*
 * 1780. Check if Number is a Sum of Powers of Three
https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/description/

Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.

An integer y is a power of three if there exists an integer x such that y == 3x.

 

Example 1:

Input: n = 12
Output: true
Explanation: 12 = 31 + 32
Example 2:

Input: n = 91
Output: true
Explanation: 91 = 30 + 32 + 34
Example 3:

Input: n = 21
Output: false
 

Constraints:

1 <= n <= 107
 */