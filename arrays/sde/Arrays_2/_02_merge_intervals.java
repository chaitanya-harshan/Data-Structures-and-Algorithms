package arrays.sde.Arrays_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _02_merge_intervals {
    
    public static void main(String[] args) {
        // int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        // int[][] arr = {{1,4}, {0,4}};
        // int[][] arr = {{1,4},{2,3}};
        int[][] arr = {{0,10},{2,4},{3,6},{8,10}};
        System.out.println(Arrays.deepToString(merge(arr)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]); // lamnda expression
        // Arrays.sort(intervals, new Comparator<int[]>() {
        //     public int compare(int[] arr1, int[] arr2) {
        //         return arr1[0] - arr2[0];
        //     }
        // });

        List<int[]> list = new ArrayList<>();
        int n = intervals.length;

        // for (int i=0; i<n; i++) {
        //     int a = intervals[i][0];
        //     int end = intervals[i][1];
        //     while (i+1 < n && end >= intervals[i+1][0] ) {
        //         i++;
        //         end = Math.max(end, intervals[i][1]);
        //     }
        //     list.add(new int[]{a, end} );
        // }
        
        list.add(intervals[0]);// adding the 1st row
        for (int i= 1; i<intervals.length; i++) {
            if (intervals[i][0] <= list.getLast()[1]) {
                list.getLast()[1] = Math.max(intervals[i][1], list.getLast()[1]);
            }
            else list.add(intervals[i]);
        }

        int m = list.size();
        return list.toArray(new int[m][]);
        // int[][] ans = new int[m][m];
        // int i = 0;
        // for (int[] arr: list) {
        //     ans[i] = arr.clone();
        //     i++;
        // }
        // return ans;
    }
}

/*
https://leetcode.com/problems/merge-intervals/description/
https://youtu.be/44H3cEC2fFM

 * 6. Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Edge cases:

----------------------------------------
----  -----  -----------   --------

----------
        ---------------------
                -------

----------
    ---------
             -----
 */

