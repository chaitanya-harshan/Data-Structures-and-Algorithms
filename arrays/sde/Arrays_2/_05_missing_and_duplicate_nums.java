package arrays.sde.Arrays_2;
/**
 * _05_missing_and_duplicate_nums
 */
public class _05_missing_and_duplicate_nums {

    // usinf xor & buckets
    public static int[] findMissingRepeatingNumbers(int []arr) {
        // fiding xor to get the diff bit between mssing and duplicate
        long n = arr.length;
        long xor = 0;
        for (int i=0; i<n; i++) {
            xor ^= arr[i];
            xor ^= i+1;
        }

        long difBit = (xor & xor-1) ^ xor;
        long a = 0, b = 0; // buckets;
 
        // adding(xor) to buckets based on the diff bit 
        for (int i = 0; i < n; i++) {
            if (((long)arr[i] & difBit) > 0) a ^= arr[i];
            else b ^= arr[i];
            if (((i+1) & difBit) > 0) a ^= i+1;
            else b ^= i+1;
        }

        // checking for order of missing and duplicate for returning
        int cnt = 0;
        for (int i : arr) {
            if (a == i) cnt++;
        }
        if (cnt == 2) return new int[]{(int)a,(int)b};
        else return new int[]{(int)b, (int)a};
    }


    // Math method
    // diff = x-y
    // difSq = x^2 - y^2
    // x+y = (x^2-y^2)/ x-y
    // find x, y usinf algebra
    public static int[] findMissingRepeatingNumbers1(int []arr) {
        long n = arr.length;
        long sumN = n*(n+1)/2;
        long sumSqrN = n*(n+1)*(2*n+1)/6;
        long s = 0, sSq = 0;
        for (long i: arr) {
            s += i;
            sSq += i*i;
        }
        
        long dif = s - sumN;
        long difSq = sSq - sumSqrN;
        long add = difSq / dif;
        long repeat = (dif + add) / 2;
        long missing = (add - repeat);
        
        return new int[]{(int)repeat, (int)missing};
    }
}

/*
 * Problem statement
You are given an array of ‘N’ integers where each integer value is between ‘1’ and ‘N’. Each integer appears exactly once except for ‘P’, which appears exactly twice, and ‘Q’, which is missing.



Your task is to find ‘P’ and ‘Q’ and return them respectively.

P and Q must be retuned in order
 */