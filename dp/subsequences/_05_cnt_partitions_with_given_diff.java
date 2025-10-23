package dp.subsequences;

import java.util.Arrays;

public class _05_cnt_partitions_with_given_diff {
    // Arr values are +ve
	// If arr contains -ve then we have to do:
	// -- find all subsets and iterate (& use meet in the middle algo for time-complexity)
	// ** Arr also have duplicates but dp already naturally solves that issue
	static final int MOD = 1_000_000_007;
	public static int countPartitions(int n, int d, int[] arr) {
		// if valid:
		// always (total-diff)/2 is even (why? think, you;ll get it) so no issue.
		// else return 0;
		
		int total = Arrays.stream(arr).sum();
		if (total < d || (total+d)%2 != 0) return 0; // ******************
		int target = (total - d)/2;
		int[] prev = new int[target+1];
		prev[0] = 1;

		for (int i=n-1; i>=0; i--) {
			int[] dp = new int[target+1];
			int num = arr[i];

			for (int k=0; k<= target; k++) {
				int noTake = prev[k];
				int take = 0;
				if (num <= k) take = prev[k-num];
				dp[k] = (noTake + take) % MOD;
			}
			prev = dp;
		}
		return prev[target];
	}
}

/*
 *  Partitions With Given Difference
https://www.naukri.com/code360/problems/partitions-with-given-difference_3751628

Given an array ‘ARR’, partition it into two subsets (possibly empty) such that their union is the original array. 
Let the sum of the elements of these two subsets be ‘S1’ and ‘S2’.

Given a difference ‘D’, count the number of partitions in which ‘S1’ is greater than or equal to ‘S2’ 
and the difference between ‘S1’ and ‘S2’ is equal to ‘D’. 
Since the answer may be too large, return it modulo ‘10^9 + 7’.

If ‘Pi_Sj’ denotes the Subset ‘j’ for Partition ‘i’. Then, two partitions P1 and P2 are considered different if:

1) P1_S1 != P2_S1 i.e, at least one of the elements of P1_S1 is different from P2_S2.
2) P1_S1 == P2_S2, but the indices set represented by P1_S1 is not equal to the indices set of P2_S2. 
	Here, the indices set of P1_S1 is formed by taking the indices of the elements from which the subset is formed.
Refer to the example below for clarification.
Note that the sum of the elements of an empty subset is 0.

For example :
If N = 4, D = 3, ARR = {5, 2, 5, 1}
There are only two possible partitions of this array.
Partition 1: {5, 2, 1}, {5}. The subset difference between subset sum is: (5 + 2 + 1) - (5) = 3
Partition 2: {5, 2, 1}, {5}. The subset difference between subset sum is: (5 + 2 + 1) - (5) = 3
These two partitions are different because, in the 1st partition, S1 contains 5 from index 0, and in the 2nd partition, S1 contains 5 from index 2.



Time limit: 1 sec
Sample Input 1 :
2
4 3
5 2 6 4
4 0
1 1 1 1
Sample Output 1 :
1
6
Explanation For Sample Input 1 :
For test case 1:
We will print 1 because :
There is only one possible partition of this array.
Partition : {6, 4}, {5, 2}. The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3

For test case 2:
We will print 6 because :
The partition {1, 1}, {1, 1} is repeated 6 times:
Partition 1 : {ARR[0], ARR[1]}, {ARR[2], ARR[3]}
Partition 2 : {ARR[0], ARR[2]}, {ARR[1], ARR[3]}
Partition 3 : {ARR[0], ARR[3]}, {ARR[1], ARR[2]}
Partition 4 : {ARR[1], ARR[2]}, {ARR[0], ARR[3]}
Partition 5 : {ARR[1], ARR[3]}, {ARR[0], ARR[2]}
Partition 6 : {ARR[2], ARR[3]}, {ARR[0], ARR[1]}
The difference is in the indices chosen for the subset S1(or S2).
Sample Input 2 :
3
3 1
4 6 3
5 0
3 1 1 2 1
5 1
3 2 2 5 1
Sample Output 2 :
1
6
3


Constraints :
1 ≤ T ≤ 10
1 ≤ N ≤ 50
0 ≤ D ≤ 2500
0 ≤ ARR[i] ≤ 50
 */