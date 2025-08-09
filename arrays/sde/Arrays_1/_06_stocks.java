package arrays.sde.Arrays_1;

public class _06_stocks {
    
    public int maxProfit(int[] prices) {
        int buy = 0;
        int maxPro = 0;
        for (int j = 0; j<prices.length; j++) {
            
            int profit = prices[j] - prices[buy];
            maxPro = Math.max(profit, maxPro);

            if (prices[j] < prices[buy]) buy = j;
        }
        return maxPro;
    }
}

// $    $$        $
// $$ $$$$$      $$$
// $$$$$$$$$    $$$$$$
// $$$$$$$$$$$$$$$$$$$
// $$$$$$$$$$$$$$$$$$
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/*
 * 21. Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Input: prices = [7,1,5,3,6,4]
Output: 5
 */