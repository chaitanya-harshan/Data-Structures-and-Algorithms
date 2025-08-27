/* 
* Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
    The guards have gone and will come back in h hours.
    Koko can decide her bananas-per-hour eating speed of k.
* Each hour, she chooses some pile of bananas and eats k bananas from that pile.
    If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
    Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
* Return the minimum integer k such that she can eat all the bananas within h hours.

*/

package binary.math;


public class _03_banannas {

    public static void main(String[] args) {
        int arr[] = {3,6,7,11};
        System.out.println(minEatingSpeed(arr, 8));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        // ******** IMPORTANT 🚨🚨🚨
        //      Math.ceil(tot/h) can be Mathematically written as (tot - 1) / h + 1 
        //      -1 ->  shifting the series backward => so [91 ~ 100] gives 10 instead of
        //      [90 - 99] to match with Math.ceil()
        // ********
        int n = piles.length;
        long tot = 0;
        for (int p: piles) tot += p; 
        // 🚨🚨🚨 Can't use Arrays.stream().sum() as it'll integer overflow

        int l = (int)((tot-1) / h)  + 1;
        // case where one pile conatains all expect n-1 which are spread as 1 per each remaining pile
        // ( {total - [n-1]} -1 ) / ( h - {n-1} ) + 1
        int r = (int)((tot-n) / (h-n+1))  + 1;

        while (l <= r) {
            int time = 0;
            int m = l+ (r-l)/2; // else interger overflow for this problem
            for (int pile : piles) {
                time += (pile-1) / m + 1;
            }

            if (time <= h) r = m-1;
            else l = m+1;
        }
        return l;
    }







    
    // public static int minEatingSpeed(int[] piles, int h) {
    //     int low = 1, high = max(piles);

    //     while (low <= high) {
    //         int mid = (low + high)/2;
    //         int time = calculateTime(piles, mid);
    //         if (time <= h) high = mid - 1;
    //         else low = mid + 1;
    //     }
    //     return low;
    // }

    // static int calculateTime(int[] piles ,int k) {
    //     int time = 0;
    //     for (int i = 0; i<piles.length; i++) {
    //         time += Math.ceil((double)piles[i] / k);
    //     }
    //     return time;
    // }

    // static int max(int[] arr) {
    //     int max = 0;
    //     for (int i = 0; i<arr.length; i++) {
    //         max = Math.max(max, arr[i]);
    //     }
    //     return max;
    // }
}


/*
 * URL: https://leetcode.com/problems/koko-eating-bananas/description/

875. Koko Eating Bananas

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.

 
Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23

 
Constraints:

	1 <= piles.length <= 104
	piles.length <= h <= 109
	1 <= piles[i] <= 109
 */