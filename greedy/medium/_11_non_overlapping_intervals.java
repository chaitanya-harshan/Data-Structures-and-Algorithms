package greedy.medium;

import java.util.Arrays;

public class _11_non_overlapping_intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0] -b[0]);
        int prevEnd = intervals[0][1];
        int cnt = 0;

        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                cnt++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            }
            else {
                prevEnd = intervals[i][1];
            }
        }
        return cnt;
    }

    //     ------------A
    // --------B          ---------C  -> remove A

    //     -----A
    // -------------B     ---------C  -> remove B


    // I don't understand this approach
    public int eraseOverlapIntervals1(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);

        int cnt = 1, j = 0;
        for (int i=1; i<n; i++) {
            if (intervals[i][0] >= intervals[j][1]) {
                cnt++;
                j = i;
            }
        }
        return n - cnt;
    }
}

/*
 * URL: https://leetcode.com/problems/non-overlapping-intervals/description/

435. Non-overlapping Intervals

Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.

 
Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

 
Constraints:

	1 <= intervals.length <= 105
	intervals[i].length == 2
	-5 * 104 <= starti < endi <= 5 * 104
 */