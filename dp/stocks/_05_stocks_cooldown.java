package dp.stocks;

public class _05_stocks_cooldown {
    // f(i, BuyOrSell)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        // n + 1(for base case) + 1(for base case for cooldown case at i=n-1 -> i=n+1)

        // Iterate from the day before the end to the beginning
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {

                if (buy == 1) {
                    // Max of (buy today vs skip today)
                    dp[i][buy] = Math.max(
                        -prices[i] + dp[i+1][0], // Buy
                        dp[i+1][1]               // Skip
                    );
                } else {
                    // Max of (sell today vs skip today)
                    dp[i][buy] = Math.max(
                        prices[i] + dp[i+2][1], // Sell and cooldown next day
                        dp[i+1][0]                // Skip
                    );
                }
            }
        }
        return dp[0][1];
    }
}

/*
 * URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

309. Best Time to Buy and Sell Stock with Cooldown

You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 
Example 1:
Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:
Input: prices = [1]
Output: 0

 
Constraints:

	1 <= prices.length <= 5000
	0 <= prices[i] <= 1000
 */