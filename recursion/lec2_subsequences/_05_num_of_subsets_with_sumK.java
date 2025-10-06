/*
 * Given an array arr of size n of non-negative integers and an integer sum, 
 * the task is to count all subsets of the given array with a sum equal to a given sum.
 * 
n = 6, arr = [5, 2, 3, 10, 6, 8], sum = 10
Output:3
Explanation: {5, 2, 3}, {2, 8}, {10} are possible subsets.
 */
package recursion.lec2_subsequences;

public class _05_num_of_subsets_with_sumK {
    
    public static void main(String[] args) {
        // int[] nums = {5,2,3,10,6,8};
		int[] nums = {3,5,6,7};
        System.out.println(perfectSum(nums, nums.length, 9));
    }

    // use % 1000000007 for larger numbers.

    public static int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int count = backtrack(arr, 0, 0, sum, n);
	    return count;
	} 
	
	static int backtrack(int[] nums, int k, int sum, int targetSum, int n) {
	    if (sum > targetSum) return 0;
	    if (k == n) {
	        if (sum == targetSum) return 1;
	        else return 0;
	    }
	    
	    sum += nums[k];
	    int left = backtrack(nums, k+1, sum, targetSum, n);
	    sum -= nums[k];
	    int right = backtrack(nums, k+1, sum, targetSum, n);
	    
	    return (left + right);
	}
}

// time complexity = o(2^n) ??
