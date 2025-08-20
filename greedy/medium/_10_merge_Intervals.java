package greedy.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class _10_merge_Intervals {
    
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        int i = 0, j = 1;
        while (j < n) {
            if (intervals[i][1] >= intervals[j][0]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                j++;
            }
            else {
                list.add(intervals[i]);
                i = j++;
            }
        }
        list.add(intervals[i]);

        return list.toArray(int[][]::new);
    }
}

/*
 * URL: https://leetcode.com/problems/merge-intervals/description/

56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 
Constraints:

	1 <= intervals.length <= 104
	intervals[i].length == 2
	0 <= starti <= endi <= 104
 */