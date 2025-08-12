/*
 * There is one meeting room in a firm. You are given two arrays, start and end each of size N.
 * For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]  
 * will denote the ending time of the ith meeting. Find the maximum number of meetings that 
 * can be accommodated if only one meeting can happen in the room at a  particular time.
 * 
 * https://www.naukri.com/code360/problems/maximum-meetings_1062658
 * 
 */
package greedy.medium;

import java.util.Arrays;


public class _01_max_meetings {
    
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        System.out.println(maximumMeetings(start, end));
    }
    
    public static int maximumMeetings(int []start, int []end) {
        int n = start.length;
        int[][] meet = new int[n][2];
        for (int i=0; i<n; i++) {
            meet[i][0] = start[i];
            meet[i][1] = end[i];
        }        

        Arrays.sort(meet, (a,b) -> a[1]-b[1]);
        int meetings = 0;
        int avaliable_since = -1; // for the case where first meeting starts at 0 else we can use available_since = 0 instead of -1
        for (int[] meeting: meet) {
            if (meeting[0] > avaliable_since) {
                meetings++;
                avaliable_since = meeting[1];
            }
        }
        return meetings;
    }
}