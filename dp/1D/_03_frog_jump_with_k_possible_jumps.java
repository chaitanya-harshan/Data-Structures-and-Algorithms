package dp.1D;

public class _03_frog_jump_with_k_possible_jumps {
    // Coding ninjas - https://www.naukri.com/code360/problems/minimal-cost_8180930?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
    public static int minimizeCost(int n, int k, int []height){
        int[] dp = new int[n];
        // dp[n-1] = 0;

        for (int i=n-2; i>=0; i--) {
            int energy = Integer.MAX_VALUE;
            for (int j=i+1;  j <= i+k && j<n;  j++) {
                int jump = Math.abs(height[i] - height[j]) + dp[j];
                energy = Math.min(energy, jump);
            }
            dp[i] = energy;
        }
        return dp[0];
    }
}

/*
 * https://www.geeksforgeeks.org/problems/minimal-cost/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimal-cost
 * GFG
 * Minimal Cost
 * There is an array arr of heights of stone and Geek is standing at the first stone and can jump to 
 * one of the following: Stone i+1, i+2, ... i+k stone, where k is the maximum number of steps that can be jumped and cost will be |hi-hj| is incurred, where j is the stone to land on. Find the minimum possible total cost incurred before the Geek reaches the last stone.

Example:

Input: k = 3, arr[]= [10, 30, 40, 50, 20]
Output: 30
Explanation: Geek will follow the path 1->2->5, the total cost would be | 10-30| + |30-20| = 30, which is minimum
 */