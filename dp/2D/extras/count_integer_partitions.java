/**
 * Problem: Count Integer Partitions
 * Link: https://www.geeksforgeeks.org/coin-change-dp-7/ (This is a variation of the coin change problem)
 *
 * Description:
 * Given a positive integer n, the task is to find the number of ways it can be written as a sum of positive integers.
 * The order of the integers in the sum does not matter. This is equivalent to the "unbounded knapsack" or "coin change"
 * problem where the "coins" are the integers from 1 to n.
 *
 * Example:
 * Input: n = 4
 * Output: 5
 * Explanation: The partitions are:
 * 4
 * 3 + 1
 * 2 + 2
 * 2 + 1 + 1
 * 1 + 1 + 1 + 1
 *
 * Input: n = 5
 * Output: 7
 * Explanation: The partitions are:
 * 5
 * 4 + 1
 * 3 + 2
 * 3 + 1 + 1
 * 2 + 2 + 1
 * 2 + 1 + 1 + 1
 * 1 + 1 + 1 + 1 + 1
 */
package dp.2D.extras;

public class count_integer_partitions {

    public static void main(String[] args) {
        // Example usage:
        int n = 5;
        System.out.println("Number of partitions for " + n + " is: " + count_partitions(n)); // Expected: 7

        n = 4;
        System.out.println("Number of partitions for " + n + " is: " + count_partitions(n)); // Expected: 5
    }

    /**
     * This function calculates the number of partitions for a given integer n.
     * It uses a 1D dynamic programming array to store the number of ways to form each sum from 0 to n.
     *
     *  n The integer to be partitioned.
     */
    public static int count_partitions(int n) {
        // dp[i] will be storing the number of partitions for integer i.
        int[] dp = new int[n + 1];

        // Base case: There is one way to make a sum of 0 (by choosing no elements).
        dp[0] = 1;

        // We iterate through all the numbers from 1 to n. These are the "coins" we can use.
        for (int i = 1; i <= n; i++) {
            // For each "coin" i, we update the dp array for all sums j >= i.
            for (int j = i; j <= n; j++) {
                // The number of ways to make sum 'j' is updated by adding the number of ways to make sum 'j-i'.
                // This is because we can form partitions of 'j' by taking an existing partition of 'j-i' and adding 'i' to it.
                dp[j] += dp[j - i];
            }
        }

        // The final answer is the number of ways to make the sum 'n'.
        return dp[n];
    }
}