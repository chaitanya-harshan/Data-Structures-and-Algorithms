package __concepts_mixed.sorting_and_intervals;

import java.util.Arrays;
// You can't use prefix here because it will exceed the range. 
// You need the ability to apply the meetings without actually storing them. 
// So you have to sort it.
public class count_days_without_meetings {

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->a[0]-b[0]);
        int free = days;

        int prevEnd = 0;
        for (int i=0; i<meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            if (end <= prevEnd) continue;

            if (start <= prevEnd) free -= end-prevEnd;
            else free -= end-start+1;
            prevEnd = end;
        }
        return free;
    }
}

/*
 * 3169. Count Days Without Meetings
https://leetcode.com/problems/count-days-without-meetings/description

You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).

Return the count of days when the employee is available for work but no meetings are scheduled.

Note: The meetings may overlap.

 

Example 1:

Input: days = 10, meetings = [[5,7],[1,3],[9,10]]

Output: 2

Explanation:

There is no meeting scheduled on the 4th and 8th days.

Example 2:

Input: days = 5, meetings = [[2,4],[1,3]]

Output: 1

Explanation:

There is no meeting scheduled on the 5th day.

Example 3:

Input: days = 6, meetings = [[1,6]]

Output: 0

Explanation:

Meetings are scheduled for all working days.

 

Constraints:

1 <= days <= 109
1 <= meetings.length <= 105
meetings[i].length == 2
1 <= meetings[i][0] <= meetings[i][1] <= days
 */