package dp.subsequences.extras;

import java.util.Arrays;

public class min_cost_to_cut_stick {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length + 2;
        int[] allCuts = new int[m];
        allCuts[0] = 0;
        for(int i=0;i<m-2; i++) allCuts[i+1] = cuts[i];
        allCuts[m-1] = n;
        Arrays.sort(allCuts);

        int[][] dp = new int[m][m];

        for (int i=m-1; i>=0; i--) {
            for (int j=i+1; j<m; j++) {
                int min = Integer.MAX_VALUE;

                for (int k=i+1; k<j; k++) {
                    int cost = allCuts[j]-allCuts[i] + dp[i][k] + dp[k][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = (min == Integer.MAX_VALUE) ? 0 : min;
            }
        }
        return dp[0][m-1];
    }
}
