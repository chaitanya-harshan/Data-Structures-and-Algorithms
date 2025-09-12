package dp.subsequences;

public class _11_rod_cutting_unbounded_knapsack {
    // array is 1 indexed and arr[i] is price of 'i' length
    // meaning in psudocode arr[2] is price of length 2
    // but in code it's arr[2-1] to get te 2nd element which is index 1
    // DONT GET CONFUSED
    public static int cutRod(int[] price) {
        int n = price.length;
        int[] prev = new int[n+1];
        prev[0] = 0;
        
        for (int i=n; i > 0; i--) {
            int[] dp = new int[n+1];

            for (int k=0; k<=n; k++) {
                int noTake = prev[k];
                int take = (i <= k) ? price[i-1] + dp[k-i] : 0;
                
                dp[k] = Math.max(take, noTake);
            }
            prev = dp;
        }
        return prev[n];
    }
}

/*
 * Given a rod of length n inches and an array of prices, price. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.
https://www.geeksforgeeks.org/problems/rod-cutting0840/1
https://www.naukri.com/code360/problems/rod-cutting-problem_800284

Example:

Input: price[] = [1, 5, 8, 9, 10, 17, 17, 20]
Output: 22
Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5+17=22.
Input: price[] = [3, 5, 8, 9, 10, 17, 17, 20]
Output: 24
Explanation: The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*price[1]= 8*3 = 24.
Input: price[] = [1, 10, 3, 1, 3, 1, 5, 9]
Output: 40
 */