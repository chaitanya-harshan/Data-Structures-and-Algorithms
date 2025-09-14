package dp.stocks;

public class _03_stocks_3 {
    // This in VERY HARD. watch striver.

    // f(i, BuyOrSell, trnxAvail)
    // if tnxAvail = 0, then no more
    // if i==n, then no more {return 0}
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // prev[buy][transactions_left]
        int[][] prev = new int[2][3];
        // for us k goes from 1 -> 2 so we need indices 0,1,2 so we use a lenght 3 array
        // to have base case dp[][0] = 0

        // Iterate from the day before the end to the beginning
        for (int i = n - 1; i >= 0; i--) {
            int[][] dp = new int[2][3];

            // Iterate through buy states (1: can buy, 0: must sell)
            for (int buy = 0; buy <= 1; buy++) {
                // Iterate through available transactions (1 or 2)
                // Note: tnx=0 is implicitly 0 profit, which is correct.
                for (int tnx = 1; tnx <= 2; tnx++) {

                    if (buy == 1) { // If we are allowed to buy
                        // Max of (buy today vs skip today)
                        dp[buy][tnx] = Math.max(
                            -prices[i] + prev[0][tnx], // Buy
                            prev[1][tnx]               // Skip
                        );
                    } else { // If we must sell (buy == 0)
                        // Max of (sell today vs skip today)
                        dp[buy][tnx] = Math.max(
                            prices[i] + prev[1][tnx - 1], // Sell
                            prev[0][tnx]                  // Skip
                        );
                    }
                }
            }
            // Move current day's results to prev for the next iteration
            prev = dp;
        }

        // Final answer is on day 0, when we can buy (1), with 2 transactions available.
        return prev[1][2];
    }
}

/*
 * URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

123. Best Time to Buy and Sell Stock III

You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most two transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 
Example 1:
Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

 
Constraints:

	1 <= prices.length <= 105
	0 <= prices[i] <= 105
 */