/*
 * Given a set of n jobs where each jobi has a deadline and profit associated with it.
Each job takes 1 unit of time to complete and only one job can be scheduled at a time. 
We earn the profit associated with a job if and only if the job is completed by its deadline.

Find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Job_id, Deadline, Profit) associated with that Job. Deadline of the job is the time on or before which job needs to be completed to earn the profit.

https://www.naukri.com/code360/problems/job-sequencing-problem_1169460
https://www.youtube.com/watch?v=QbwltemZbRg

Note :
If a particular job has a deadline 'x', it means that it needs to be completed at any time before 'x'.

Assume that the start time is 0.

*/

package greedy.medium;

import java.util.Arrays;

public class _05_job_sequencing {
    
    public static int[] jobScheduling(int [][]jobs) {
        // 0 - id
        // 1 - deadline (1 based indexing)
        // 2 - profit
        int maxDeadline = 0;
        for (int[] job: jobs) maxDeadline = Math.max(maxDeadline, job[1]);
        boolean[] available = new boolean[maxDeadline];
        Arrays.fill(available, true);

        int jobs_done = 0, profit = 0;
        Arrays.sort(jobs, (a,b) -> b[2] - a[2]); // Integer.compare(b[2], a[2]) 
        
        for (int[] job: jobs) {
            int day = job[1]-1;
            while (day >= 0 && !available[day]) {
                day--;
            }
            if (day >= 0) {
                available[day] = false;
                jobs_done++;
                profit += job[2];
            }
        }
        return new int[]{jobs_done, profit};
    }
}
