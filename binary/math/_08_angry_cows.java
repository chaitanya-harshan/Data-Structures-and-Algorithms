package binary.math;

import java.util.Arrays;

public class _08_angry_cows {
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggressiveCows(stalls, k);
        System.out.println(ans);
    }

    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;

        int l = 1, h = stalls[n-1]-stalls[0]; // more opt 'h' couldn't be found than this by me
        while (l <= h) {
            int cows = 1;
            int m = l+h >> 1;

            int prev_stall = stalls[0];
            for (int stall : stalls) {
                if (cows >= k) break;
                if (stall-prev_stall >= m) {
                    cows++;
                    prev_stall = stall;
                }
            }
            
            if (cows >= k) l = m+1;
            else h = m-1;
        }
        return h;
    }

    
    // public static int aggressiveCows(int []stalls, int k) {
    //     //    Write your code here.
    //     Arrays.sort(stalls);
    //     int low = 1, high = stalls[stalls.length-1] - stalls[0];
    //     while (low <= high) {
    //         int mid = (low + high)/2;
    //         if (canWePlace(stalls,k,mid)) {
    //             low = mid + 1;
    //         }
    //         else high = mid -1;
    //     }
    //     return high;
    // }
    // 
    // static boolean canWePlace(int[] arr, int cows, int diff) {
    //     int last = arr[0];
    //     int count = 1;
    //     for (int i = 1; i<arr.length; i++) {
    //         if (arr[i] - last >= diff){
    //             count++;
    //             last = arr[i];
    //         }
    //         if (count >= cows) return true;
    //     }
    //     return false;
    // }
}

/*
 * https://www.naukri.com/code360/problems/aggressive-cows_1082559
 * 
You are given an array 'arr' consisting of 'n' integers which denote the position of a stall.
You are also given an integer 'k' which denotes the number of aggressive cows.
You are given the task of assigning stalls to 'k' cows such that the minimum distance 
between any two of them is the maximum possible.
Print the maximum possible minimum distance.



Example:
Input: 'n' = 3, 'k' = 2 and 'arr' = {1, 2, 3}

Output: 2

Explanation: The maximum possible minimum distance will be 2 when 2 cows are placed at positions {1, 3}. Here distance between cows is 2.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6 4
0 3 4 7 10 9


Sample Output 1 :
3


Explanation to Sample Input 1 :
The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. Here distance between cows are 3, 4 and 3 respectively.


Sample Input 2 :
5 2
4 2 1 3 6


Sample Output 2 :
5
 */