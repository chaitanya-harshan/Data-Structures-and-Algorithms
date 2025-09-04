/*
You are given an array 'nums' of ‘n’ integers.
Return all subset sums of 'nums' in a non-decreasing order.

Note:
Here subset sum means sum of all elements of a subset of 'nums'. A subset of 'nums' is an array formed by removing some (possibly zero or all) elements of 'nums'.

For example
Input: 'nums' = [1,2]

Output: 0 1 2 3

Explanation:
Following are the subset sums:
0 (by considering empty subset)
1 
2
1+2 = 3
So, subset sum are [0,1,2,3].

https://practice.geeksforgeeks.org/problems/subset-sums2234/1
https://www.naukri.com/code360/problems/subset-sum_3843086
 */
package recursion.lec2;

import java.util.ArrayList;
import java.util.List;

public class _09_subset_sum_1 {
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> sums = new ArrayList<>();
        backtrack(sums, 0, 0, arr, n);
        return sums;
    }
    
    static void backtrack(List<Integer> sums, int k, int sum, List<Integer> arr, int n) {
        if (k == n) {
            sums.add(sum);
            return;
        }
        
        backtrack(sums, k+1, sum+arr.get(k), arr, n);
        backtrack(sums, k+1, sum, arr, n);
    }
}
