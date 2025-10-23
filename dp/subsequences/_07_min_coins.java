package dp.subsequences;

import java.util.Arrays;

public class _07_min_coins {

    public int coinChange_2d_dp(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        prev[0] = 0;

        for (int i=n-1; i>=0; i--) {
            int[] dp = new int[amount + 1];
            int num = coins[i];

            for (int k=0; k<= amount; k++) {
                int noTake = prev[k];
                int take = (num <= k) ? 1+dp[k-num] : 0;
                dp[k] = Math.min(noTake, take);
            }
            prev = dp;
        }
        return prev[amount];
    }

    public int coinChange_1d_dp(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins); // u don't really need to sort it

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // can't use Integer.MAX_VALUE as you'll do 1+dp[prev]
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                } 
                else break;
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];

        // without sorting the coins array 
        // int[] dp = new int[amount + 1];
        // dp[0] = 0;
        // for (int k=1; k <= amount; k++) {
        //     int MinCoins = amount+1; // don't use Int.MAX becasue it will overflow when u do 1+dp[]
        //     for (int i=0; i<coins.length; i++) {
        //         if (coins[i] <= k) {
        //             MinCoins = Math.min(MinCoins, 1 + dp[k-coins[i]] );
        //              // only if the all the 0,1...,n-1 values are processed then it comes to i=n
        //         }
        //     }
        //     dp[i] = MinCoins;
        // }
        // return dp[amount] != amount +1 ? dp[amount] : -1;
    }
    // every amount from 0 - amount is evaluated even if some of the nums<amount are not possible.
    // If amount 'i' can't be found then then dp[i]/Mincoins = (amount+1){max value}

    /* consider for better understanding:
     [3,4,5] , 12 --> dp[12-5] = dp[7] = dp[7-4] = dp[3] = 1
     
     [2,4] , 7 --> dp[7-4] = dp[3] = dp[3-2] = dp[1] = XX no solution
     0   1   2   3   4   5   6   7
               1+[1]   1+[1]   1+[3]
     0   8   1 (1+8) 1 (1+8) 2 (1+8)
     */
}

/*
 * URL: https://leetcode.com/problems/coin-change/description/

322. Coin Change

You are given an integer array coins representing coins of different denominations and an integer amount 
representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be 
made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

 
Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:
Input: coins = [2], amount = 3
Output: -1
Example 3:
Input: coins = [1], amount = 0
Output: 0

 
Constraints:

	1 <= coins.length <= 12
	1 <= coins[i] <= 231 - 1
	0 <= amount <= 104
 */
