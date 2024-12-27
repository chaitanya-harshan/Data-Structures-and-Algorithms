package arrays.extras;

public class best_sightseeing_pairs {

    public int maxScoreSightseeingPair(int[] values) {
        int n =  values.length;
        int[] r = new int[n]; // r -> max right value at idx 'i' to be added to val[i] which is
        // (val[j] - (j-i)) 
        int rmax = 0;

        for (int i=n-2; i >= 0; i--) {
            rmax = Math.max(rmax-1, values[i+1]-1);
            r[i] = rmax;
        }

        int max = 0;
        for (int i=0; i<n-1; i++) {
            max = Math.max(max, values[i] + r[i]);
        }
        return max;
    }
}

/*
 * 1014. Best Sightseeing Pair
 * https://leetcode.com/problems/best-sightseeing-pair/description/
 * 
You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.

The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.

 

Example 1:

Input: values = [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
Example 2:

Input: values = [1,2]
Output: 2
 

Constraints:

2 <= values.length <= 5 * 104
1 <= values[i] <= 1000
 */