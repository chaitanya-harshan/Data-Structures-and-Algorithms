package dp.stocks;

public class _04_stocks_4 {
    // This in VERY HARD. watch striver.
    // For proper comments watch _03_stocks_3.java
    // f(i, BuyOrSell, trnxAvail)
    // i reached end -> no profit
    // 0 trnxAvail -> no profit
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int prev[][] = new int[2][k + 1];
        // for us k goes from 1 -> k so we need indices 1,2,...,k so we use a lenght k+1 array

        for (int i = n - 1; i >= 0; i--) {
            int dp[][] = new int[2][k + 1];

            for (int buy = 0; buy <= 1; buy++) {
                for (int tnx = 1; tnx <= k; tnx++) {

                    if (buy == 1) { // If we are allowed to buy
                        dp[buy][tnx] = Math.max(
                                -prices[i] + prev[0][tnx], // Buy
                                prev[1][tnx] // Skip
                        );
                    } else { // If we must sell (buy == 0)
                        dp[buy][tnx] = Math.max(
                                prices[i] + prev[1][tnx - 1], // Sell
                                prev[0][tnx] // Skip
                        );
                    }
                }
            }
            prev = dp;
        }
        return prev[1][k];
    }
}

/*
 * URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/

188. Best Time to Buy and Sell Stock IV

You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 
Example 1:
Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:
Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

 
Constraints:

	1 <= k <= 100
	1 <= prices.length <= 1000
	0 <= prices[i] <= 1000
 */