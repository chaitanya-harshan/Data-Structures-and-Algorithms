package arrays.medium.similar;

import java.util.ArrayList;

public class _08_Kth_permutation_sequence_from_start {
    // Bro just remember the code and watch striver if you need
    // https://youtu.be/wT7gcXLYoao
    
    // 1 based indexing for K won't work ( I tried )
    /*
    n = 4, k = 17
    Convert to 0-based: k0 = 16

    0: 1--- (3! = 6 combinations)   →  0-5
    1: 2---        same             →  6-11
    2: 3---        same             → 12-17
    3: 4---        same             → 18-23

    i = 16 / 6 = 2 (index) --> [1,2,3,4] → pick '3'
    k = 16 % 6 = 4

    0: 31-- (2! = 2 combinations)   →  0-1
    1: 32--        same             →  2-3
    2: 34--        same             →  4-5

    i = 4 / 2 = 2 (index) --> [1,2,4] → pick '4'
    k = 4 % 2 = 0

    0: 341- (1! = 1 combination)    →  0
    1: 342-        same             →  1

    i = 0 / 1 = 0 (index) --> [1,2] → pick '1'
    k = 0 % 1 = 0

    0: 3412

    Leftover element: [2] → pick '2'

    Final permutation: "3412"

    */

    public String getPermutation(int n, int k) {
        k--;
        int fact = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1; i<n; i++) {
            fact *= i;
            list.add(i);
        }
        list.add(n);

        String s = "";
        while (list.size() > 1) {
            int i = k/fact;
            s += list.get(i);
            list.remove(i);
            k %= fact;
            fact /= list.size();
        }
        s += list.get(0);

        return s;
    }
}

/*
 * URL: https://leetcode.com/problems/permutation-sequence/description/

60. Permutation Sequence

The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

 
Example 1:
Input: n = 3, k = 3
Output: "213"
Example 2:
Input: n = 4, k = 9
Output: "2314"
Example 3:
Input: n = 3, k = 1
Output: "123"

 
Constraints:

	1 <= n <= 9
	1 <= k <= n!
 */