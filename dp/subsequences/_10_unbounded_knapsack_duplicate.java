package dp.subsequences;

public class _10_unbounded_knapsack_duplicate {
    
    public static int unboundedKnapsack_2d_dp(int n, int w, int[] profit, int[] weight) {
        int[] prev = new int[w+1];
        prev[0] = 0;

        for (int i=n-1; i>=0; i--) {
            int[] dp = new int[w+1];
            int num = weight[i];

            for(int k=0; k<=w; k++) {
                int noTake = prev[k];
                int take = (num <= k) ? profit[i] + dp[k-num] : 0;
                dp[k] = Math.max(noTake, take);
            }
            prev = dp;
        }
        return prev[w];
    }

    public static int unboundedKnapsack_1d_dp(int n, int w, int[] profit, int[] weight) {
        int[] dp = new int[w + 1];
        dp[0] = 0; // zero profit for when 0 capacity is left

        // u can sort it like in minCoins and make it effecient but this is 2 array input so
        // it's extra work.... u can do it if u want

        for (int k = 1; k <= w; k++) {
            for (int i = 0; i < n; i++) {
                if (weight[i] <= k) {
                    // This is the key transition, directly parallel to Code 2.
                    // We either:
                    // 1. Don't take item i (dp[k] keeps its current value)
                    // 2. Take item i (profit[i] + dp[k - weight[i]])
                    dp[k] = Math.max(dp[k], profit[i] + dp[k - weight[i]]);
                }
                // incase u sorted it:
                // else break;
            }
        }
        return dp[w];
    }
    
    // gfg
    // public static int knapSack(int val[], int weight[], int capacity) {
    //     // code here
    //     int n = weight.length;
    //     int[][] dp = new int[n][capacity+1];
    //     Arrays.stream(dp).forEach(row -> Arrays.fill(row,-1));
        
    //     return knapsack(0, capacity, val, weight, dp, n);
    // }
    
    // public static int knapsack(int i, int wt, int[] val, int[] weight, int[][] dp, int n) {
    //     if (i == n-1) return (wt/weight[i])*val[i];
    //     // if (i == n) return 0; // not needed as we used i=n-1
    //     if (dp[i][wt] != -1) return dp[i][wt];
        
    //     int taken = 0;
    //     if (wt >= weight[i]) taken = val[i] + knapsack(i, wt-weight[i], val, weight, dp, n);
    //     int notTaken = knapsack(i+1, wt, val, weight, dp, n);
        
    //     return dp[i][wt] = Math.max(taken, notTaken);
    // }
}

/*
 * Knapsack with Duplicate Items
 * https://www.naukri.com/code360/problems/unbounded-knapsack_1215029
 * https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=knapsack-with-duplicate-items

Given a set of items, each with a weight and a value, represented by the array wt and val respectively. 
Also, a knapsack with a weight limit capacity.
The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
Note: Each item can be taken any number of times.

Examples:

Input: val = [1, 1], wt = [2, 1], capacity = 3
Output: 3
Explanation: The optimal choice is to pick the 2nd element 3 times.
Input: val[] = [6, 1, 7, 7], wt[] = [1, 3, 4, 5], capacity = 8
Output: 48
Explanation: The optimal choice is to pick the 1st element 8 times.
Input: val[] = [6, 8, 7, 100], wt[] = [2, 3, 4, 5], capacity = 1
Output: 0
Explanation: We can't pick any element .hence, total profit is 0.
Constraints:
1 <= val.size() = wt.size() <= 1000
1 <= capacity <= 1000
1 <= val[i], wt[i] <= 100
 */