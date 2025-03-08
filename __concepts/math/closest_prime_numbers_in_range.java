package __concepts.math;

import java.util.ArrayList;
import java.util.Arrays;

public class closest_prime_numbers_in_range {
    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> primes = getPrimes(left, right);
        int[] res = new int[]{-1,-1};
        int min = Integer.MAX_VALUE;

        for (int i=0; i<primes.size()-1; i++) {
            int num1 = primes.get(i);
            int num2 = primes.get(i+1);

            if ((num2 - num1) < min) {
                res = new int[]{num1, num2};
                min =  num2-num1;
            }
        }
        return res;
    }

    public ArrayList<Integer> getPrimes(int left, int right) {
        if (right < 2) return new ArrayList<>();

        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int num = 2; num <= Math.sqrt(right)+1; num++) {
            if (!isPrime[num]) continue;

            for (int i=num+num; i <= right; i += num) {
                isPrime[i] = false;
            } 
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i=left; i<= right; i++) {
            if (isPrime[i] == true) primes.add(i);
        }
        return primes;
    }
}

/*
 * 2523. Closest Prime Numbers in Range
https://leetcode.com/problems/closest-prime-numbers-in-range/description/

Given two positive integers left and right, find the two integers num1 and num2 such that:

left <= num1 < num2 <= right .
Both num1 and num2 are prime numbers.
num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].

 

Example 1:

Input: left = 10, right = 19
Output: [11,13]
Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
Since 11 is smaller than 17, we return the first pair.
Example 2:

Input: left = 4, right = 6
Output: [-1,-1]
Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
 

Constraints:

1 <= left <= right <= 106
 
 */