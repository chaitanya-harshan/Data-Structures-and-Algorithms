package arrays.medium.similar;

public class _06_stocks_2 {
    public int maxProfit(int[] prices) {
        // int max = 0, profit = 0;
        // int start = 0;

        // for (int i=1; i<prices.length; i++) {
        //     if (prices[i] < prices[i-1]) {
        //         max += profit;
        //         profit = 0;
        //         start = i;
        //     }
        //     profit = Math.max(profit, prices[i]-prices[start]);
        //     if (prices[i] < prices[start]) start = i;
        // }
        // if (profit != 0) max += profit;
        // return max;

        // -----------------------------------------------------------------------------
        // int buy = 0;
        // int maxPro = 0;
        // int totalProfit = 0;
        // for (int i = 0; i< prices.length; i++) {
        //     if (prices[i] < prices[buy]) buy = i;

        //     int profit = prices[i] - prices[buy];
        //     maxPro = Math.max(maxPro, profit);
            
        //     if (profit < maxPro) {
        //         totalProfit += maxPro;
        //         maxPro = 0;
        //         buy = i;
        //     }
        // }
        // return totalProfit + maxPro;
        // -------------------------------------------------------------------------------
        int profit = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > prices[i-1]) profit += prices[i]-prices[i-1];
        }
        return profit;
    }
}

/*
 * URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

122. Best Time to Buy and Sell Stock II

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock.
Find and return the maximum profit you can achieve.

 
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

 
Constraints:

	1 <= prices.length <= 3 * 104
	0 <= prices[i] <= 104
 */