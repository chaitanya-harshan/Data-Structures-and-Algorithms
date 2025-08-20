package greedy.medium;

import java.util.Arrays;

/**
 * _04_max_platforms
 */
public class _04_max_platforms {

    // Explantion of the function: We need to find the maximum number of platforms needed at any time.
    // We can do this by sorting the arrival and departure times, and then using two pointers
    // to keep track of the number of platforms needed at any time.
    // We increment the platform count when a train arrives and decrement it when a train departs.
    // The maximum value of the platform count during this process will be the answer.

    /*
        at = 900 940 950 1100 1500 1800
        dt = 910 1200 1120 1130 1900 2000

        this will be basically combined into:
        900a 910d 940a 950a 1000a 1120d 1130d 1200d 1500a 1800a 1900d 2000d
        Now we dont care about the times once its sorted,
        we care about if its 'a' or 'd'
        combined =   a d a a a d d d a a d d
        ptf =        1 0 1 2 3 2 1 0 1 2 1 0
        Max = 3

        for this instead of actually combining the arrays and sort it, 
        we just sort the two arrays and use two pointers to traverse like they both are combined.
     */
    public static int calculateMinPlatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);

        int a = 0, d = 0;
        int platforms = 0;
        int MaxPlatforms = 0;
        while (a < n && d < n) {
            if (at[a] <= dt[d]) {
                platforms++;
                a++;
            } else {
                platforms--;
                d++;
            }
            MaxPlatforms = Math.max(platforms, MaxPlatforms);
        }
        return MaxPlatforms;
    }

    /*
     * You have been given two arrays, 'AT' and 'DT', representing the arrival and departure times of all trains that reach a railway station.
    
    Your task is to find the minimum number of platforms required for the railway station so that no train needs to wait.
    
    Note :
    1. Every train will depart on the same day and the departure time will always be greater than the arrival time. For example, A train with arrival time 2240 and departure time 1930 is not possible.
    
    2. Time will be given in 24H format and colons will be omitted for convenience. For example, 9:05AM will be given as "905", or 9:10PM will be given as "2110".
    
    3. Also, there will be no leading zeroes in the given times. For example, 12:10AM will be given as “10” and not as “0010”.
    
    1 <= T <= 10
    1 <= N <= 50000
    0 <= AT[i] <= DT[i] <= 2359
     */

// ____________________________________________________________________________________________________________________________________

    // ______________WON"T WORK_______________________


    
    /*
     * What’s broken
    You sort trains by arrival and keep a flag pointing to the “oldest” train. But you never track the earliest departure among the active trains—trains[flag][1] is just the departure of the earliest arrival, which might leave last. So you can overcount badly.

    Counterexample (arr, dep):
    A (100, 500), B (200, 210), C (220, 230)
    Your loop says at 220 → 3 platforms. Reality: B left at 210, so it’s 2.

you need to use pq and store the departure times to always check for the earliest departure 
    instead of the earliest (flag) train always to make this work
     */
    public static int calculateMinPlatforms1(int at[], int dt[], int n) {
        int[][] trains = new int[n][2];
        for (int i = 0; i < n; i++) {
            trains[i][0] = at[i];
            trains[i][1] = dt[i];
        }

        Arrays.sort(trains, (a, b) -> a[0] - b[0]);

        int flag = 0;
        int platforms = 0;
        int MaxPlatforms = 0;
        for (int[] train : trains) {
            if (train[0] <= trains[flag][1]) {
                platforms++;
            }
            while (train[0] > trains[flag][1]) {
                platforms--;
                flag++;
            }
            MaxPlatforms = Math.max(platforms, MaxPlatforms);
        }
        return MaxPlatforms;
    }
}

