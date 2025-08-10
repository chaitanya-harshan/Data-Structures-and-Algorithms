/*
 * Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 } and a target value N.
Find the minimum number of coins and/or notes needed to make the change for Rs N. You must return the list containing the value of coins required. 
 */
package greedy.easy;

import java.util.ArrayList;
import java.util.List;

public class _03_min_coins {
    public static void main(String[] args) {
        int N = 121;
        List<Integer> result = minCoins(N);
        System.out.println("Minimum coins for " + N + ": " + result);
        System.out.printf("Coins used: %d", result.get(0));
        // System.out.printf("Coins used:", result);
    }

    static List<Integer> minCoins(int N) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] coins = {1,2,5,10,20,50,100,200,500,2000};
        int idx = coins.length - 1;
        
        while (N != 0) {
            if (N >= coins[idx]) {
                N -= coins[idx];
                list.add(coins[idx]);
            }
            else idx--;
        }
        return list;
    }
}
