package dp.stocks;

public class _06_stocks_2_with_transc_fee {
    // f(i, buyOrSell)
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] prev = new int[2];

        for (int i=n-1; i>=0; i--) {
            int[] dp = new int[2];

            for (int buy=0; buy<=1; buy++) {
                if (buy == 1) {
                    dp[buy] = Math.max(
                        -prices[i] + prev[0],
                        prev[1]
                    );
                }
                else {
                    dp[buy] = Math.max(
                        prices[i]-fee + prev[1],
                        prev[0]
                    );
                }
            }
            prev = dp;
        }
        return prev[1];
    }
}

/*
 * URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/

714. Best Time to Buy and Sell Stock with Transaction Fee

You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
Note:
You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
The transaction fee is only charged once for each stock purchase and sale.

 
Example 1:
Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Example 2:
Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6

 
Constraints:

	1 <= prices.length <= 5 * 104
	1 <= prices[i] < 5 * 104
	0 <= fee < 5 * 104
 */