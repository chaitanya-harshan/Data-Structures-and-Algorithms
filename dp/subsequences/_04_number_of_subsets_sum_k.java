package dp.subsequences;

public class _04_number_of_subsets_sum_k {
    
    final static int MOD = (int)(Math.pow(10, 9)+7);

    public static int findWays(int nums[], int sum) {
        int n = nums.length;
        int[] prev = new int[sum+1];
	    prev[0] = 1;
	    
	    for (int i=n-1; i>=0; i--) {
			int[] dp = new int[sum+1];
			int num = nums[i];

            // ~ from 0 
            // if nums has {*,0,*} then there are more ways to make target_sum=0
			// so we have to calculte for k=0 as well
	        for (int k=0; k<=sum; k++) {
	            int notTaken = prev[k];
	            int taken = 0;
	            if (num <= k) taken = prev[k-num];

	            dp[k] = (notTaken + taken)%MOD;
	        }
			prev = dp;
	    }
	    return prev[sum];
    }


    
    // ********* Recursion **********

    static int subsetsWithSumK1(int[] nums, int sum) {
        int cnt = backtrack(0, 0, sum, nums, nums.length);
        return cnt % MOD;
    }
    static int backtrack(int i, int k, int sum, int[] nums, int n) {
        // if (k == sum) return 1; 
        // *** U can't cause u also have '0's in the array so [5] & [5,0] count as 2 subsets
        if (k > sum) return 0;
        if (i == n) {
            if (k == sum) return 1;
            else return 0;
        }
        int noTake = backtrack(i+1, k        , sum, nums, n);
        int take =   backtrack(i+1, k+nums[i], sum, nums, n);
        return (noTake + take) % MOD;
    }
}

/*
 *  Count Subsets with Sum K
https://www.naukri.com/code360/problems/count-subsets-with-sum-k_3952532

Problem statement
You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.
Find the number of ways of selecting the elements from the array such that the sum of chosen 
elements is equal to the target 'k'.
Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.



Example:
Input: 'arr' = [1, 1, 4, 5]

Output: 3

Explanation: The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
4 5
1 4 4 5


Sample Output 1 :
 3


Explanation For Sample Output 1:
The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.


Sample Input 2 :
3 2
1 1 1


Sample Output 2 :
3


Explanation For Sample Output 1:
There are three 1 present in the array. Answer is the number of ways to choose any two of them.


Sample Input 3 :
3 40
2 34 5


Sample Output 3 :
0


Expected time complexity :
The expected time complexity is O('n' * 'k').


Constraints:
1 <= 'n' <= 100
0 <= 'arr[i]' <= 1000
1 <= 'k' <= 1000

Time limit: 1 sec
 */
