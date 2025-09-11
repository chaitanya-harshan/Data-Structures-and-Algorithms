package dp.2D;

public class _01_ninja_training {

    public static int ninjaTraining(int n, int points[][]) {
        int[] dp = new int[3];

        for (int i = n-1; i >= 0; i--) {
            int[] newDP = new int[3];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == k) continue;
                    newDP[j] = Math.max(newDP[j], dp[k]);
                }
                newDP[j] += points[i][j];
            }
            dp = newDP;
        }

        return Math.max(dp[0], Math.max(dp[1], dp[2]));
    }
}

/*
https://www.naukri.com/code360/problems/ninja-s-training_3621003

 * A Ninja has an ‘N’ Day training schedule. 
 * He has to perform one of these three activities (Running, Fighting Practice, or Learning New Moves) 
 * each day. There are merit points associated with performing an activity each day. 
 * The same activity can’t be performed on two consecutive days. We need to find the maximum 
 * merit points the ninja can attain in N Days.

We are given a 2D Array POINTS of size ‘N*3’ which tells us the merit point 
of specific activity on that particular day. Our task is to calculate the maximum 
number of merit points that the ninja can earn.

Examples:

Input: n=3 and arr[]= [[1,2,5],[3,1,1],[3,3,3]]
Output:11

3
10 40 70
20 50 80
30 60 90

Output- 210
 */