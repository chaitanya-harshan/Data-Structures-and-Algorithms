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
https://www.geeksforgeeks.org/problems/subset-sums2234/1
 */
package recursion.lec2_subsequences;

import java.util.ArrayList;

public class _09_subset_sum_1 {
    
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        backtrack(0, 0, res, arr);
        return res;
    }
    
    private void backtrack(int i, int sum, ArrayList<Integer> res, int[] arr) {
        if (i == arr.length) {
            res.add(sum);
            return;
        }
        
        backtrack(i+1, sum, res, arr);
        backtrack(i+1, sum + arr[i], res, arr);
    }
}
