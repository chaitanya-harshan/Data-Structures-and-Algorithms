package arrays.sde.Arrays_3;

/**
 * _02_pow
 * https://leetcode.com/problems/powx-n/
 */
public class _02_pow {

    public double myPow(double x, int n) {
        if (x == 1 || n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) return (double)1 / (x*myPow(x,-n-1)); // incase if it's int_min we need to reduce it by 1 
        // to be accomodated in +ve as int_min is larger than +ve storage capacity
        if (n % 2 == 0) return myPow(x*x, n/2);
        else return x * myPow(x, n-1);
    }
}