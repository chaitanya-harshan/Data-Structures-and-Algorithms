package dp.2D.extras;

public class count_integer_partitions {

    public static void main(String[] args) {
        System.out.println(count_partitions(5));
    }

    public static int count_partitions(int n) {
        int[] prev = new int[n+1];

        for (int i = n-1; i > 0; i--) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            for (int k = 1; k <= n; k++) {
                if (k >= i) dp[k] += dp[k-i];
                dp[k] += prev[k];
            }
            prev = dp;
        }
        return prev[n];

        // int[][] dp = new int[n - 1][n + 1];
        // for (int i = 0; i < dp[0].length; i++) {
        //     dp[0][i] = 1;
        // }
        // for (int i = 0; i < dp.length; i++) {
        //     dp[i][0] = 1;
        // }
        // for (int i = 1; i < dp.length; i++) {
        //     for (int j = 1; j < dp[0].length; j++) {
        //         if (j > i) {
        //             dp[i][j] = dp[i - 1][j] + dp[i][j - (i + 1)];
        //         } else {
        //             dp[i][j] = dp[i - 1][j];
        //         }
        //     }
        // }
        // return dp[dp.length - 1][dp[0].length - 1];
    }
}
