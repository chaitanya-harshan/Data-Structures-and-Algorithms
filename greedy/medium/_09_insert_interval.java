package greedy.medium;

import java.util.ArrayList;

public class _09_insert_interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        ArrayList<int[]> list = new ArrayList<>();

        while (i < n && intervals[i][1] < newInterval[0]) {
            if (intervals[i][1] < newInterval[0]) list.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) { 
            // think case: {[1,3], [5,9]}. [6,8] so => we can't have iv[i][1] <= niv[1] b/c 
            // here niv is inside iv[i][1]
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        while (i < n) {
            list.add(intervals[i]);
            i++;
        }

        // int[][] res = new int[list.size()][];
        // list.toArray(res);
        // return res;
        // return list.toArray(new int[list.size()][]);
        return list.toArray(int[][]::new);
    }

    // public int[][] insert(int[][] intervals, int[] newInterval) {
    //     int n = intervals.length;
    //     if (n == 0) return new int[][]{newInterval};

    //     // 0, [i, i+1], n
    //     int l = Arrays.binarySearch(intervals, newInterval, (a,b) -> a[0] - b[0]);
    //     if (l < 0) {
    //         l = -l -1;
    //         if (l == 0) l = 0;
    //         else if (intervals[l-1][1] >= newInterval[0]) l--;
    //     }      

    //     // 0, [i, i], n-1
    //     int r = Arrays.binarySearch(intervals, new int[]{newInterval[1]}, (a,b) -> a[0]-b[0]);
    //     if (r < 0) {
    //         r = -r -1;
    //         if (r != 0) r--;
    //     }

    //     boolean flag = (newInterval[1] < intervals[0][0]) ? true: false;

    //     int len = l + 1; // l+1+ =   n-r, n-1-r, n-1-r
    //     if (flag) len += n;
    //     else len += n-r-1;

    //     int[][] res = new int[len][2];
    //     int i;
    //     for (i=0; i<l; i++) {
    //         res[i] = Arrays.copyOf(intervals[i],2);
    //     }

    //     int left = (l == n) ? newInterval[0] : Math.min(intervals[l][0], newInterval[0]);
    //     int right = (flag) ? newInterval[1] : Math.max(intervals[r][1], newInterval[1]);
    //     res[i++] = new int[]{left, right};

    //     if (flag) r--;
    //     for (int j=r+1; j<n; j++) {
    //         res[i] = Arrays.copyOf(intervals[j],2);
    //         i++;
    //     }

    //     return res;
    // }
}

/*
 * URL: https://leetcode.com/problems/insert-interval/description/

57. Insert Interval

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

 
Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

 
Constraints:

	0 <= intervals.length <= 104
	intervals[i].length == 2
	0 <= starti <= endi <= 105
	intervals is sorted by starti in ascending order.
	newInterval.length == 2
	0 <= start <= end <= 105
 */