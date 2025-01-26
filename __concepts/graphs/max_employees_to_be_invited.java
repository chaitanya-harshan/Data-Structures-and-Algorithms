package __concepts.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// this is super hard problem - better watch the video properly
public class max_employees_to_be_invited {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        boolean[] visited = new boolean[n];
        ArrayList<int[]> len_2_cycles = new ArrayList<>();
        int longestClosedCycle = 0;

        for (int i=0; i< n; i++) {
            HashMap<Integer, Integer> cur_cycle = new HashMap<>();
            int cur = i;
            if (visited[cur]) continue;

            int len = 1;
            while (!visited[cur]) {
                visited[cur] = true;
                cur_cycle.put(cur, len++);
                cur = favorite[cur];
            }

            if (cur_cycle.containsKey(cur)) {
                int curCycleLen = len - cur_cycle.get(cur);
                if (curCycleLen == 2) len_2_cycles.add(new int[]{cur, favorite[cur]});
                longestClosedCycle = Math.max(longestClosedCycle, curCycleLen);
            }
        }

        // @SuppressWarnings("unchecked")
        ArrayList<Integer>[] reverse_graph = new ArrayList[n];
        for (int i=0; i<n; i++) reverse_graph[i] = new ArrayList<>();
        for (int i=0; i<n; i++) {
            reverse_graph[favorite[i]].add(i);
        }

        int sum_openCycle_lengths = 0;
        for (int[] pair : len_2_cycles) {
            int a = pair[0], b = pair[1];
            sum_openCycle_lengths += bfs(a,b, reverse_graph) + bfs(b,a, reverse_graph) + 2;
        }

        return Math.max(longestClosedCycle, sum_openCycle_lengths);
    }

    public static int bfs(int head, int partner, ArrayList<Integer>[] reverse_graph) {
        Queue<int[]> q = new LinkedList<>();
        int maxDepth = 0;
        q.offer(new int[]{head, 0});

        while (!q.isEmpty()) {
            int node = q.peek()[0], depth = q.poll()[1];
            maxDepth = Math.max(maxDepth, depth);

            for (int neighbour : reverse_graph[node]) {
                if (neighbour == partner) continue;
                q.offer(new int[]{neighbour, depth+1});
            }
        }
        return maxDepth;
    }
}

/*
 * 2127. Maximum Employees to Be Invited to a Meeting
https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/description/
https://www.youtube.com/watch?v=aPBELJa-LM8 - neetcode

A company is organizing a meeting and has a list of n employees, waiting to be invited. They have arranged for a large circular table, capable of seating any number of employees.

The employees are numbered from 0 to n - 1. Each employee has a favorite person and they will attend the meeting only if they can sit next to their favorite person at the table. The favorite person of an employee is not themself.

Given a 0-indexed integer array favorite, where favorite[i] denotes the favorite person of the ith employee, return the maximum number of employees that can be invited to the meeting.

 

Example 1:


Input: favorite = [2,2,1,2]
Output: 3
Explanation:
The above figure shows how the company can invite employees 0, 1, and 2, and seat them at the round table.
All employees cannot be invited because employee 2 cannot sit beside employees 0, 1, and 3, simultaneously.
Note that the company can also invite employees 1, 2, and 3, and give them their desired seats.
The maximum number of employees that can be invited to the meeting is 3. 
Example 2:

Input: favorite = [1,2,0]
Output: 3
Explanation: 
Each employee is the favorite person of at least one other employee, and the only way the company can invite them is if they invite every employee.
The seating arrangement will be the same as that in the figure given in example 1:
- Employee 0 will sit between employees 2 and 1.
- Employee 1 will sit between employees 0 and 2.
- Employee 2 will sit between employees 1 and 0.
The maximum number of employees that can be invited to the meeting is 3.
Example 3:


Input: favorite = [3,0,1,4,1]
Output: 4
Explanation:
The above figure shows how the company will invite employees 0, 1, 3, and 4, and seat them at the round table.
Employee 2 cannot be invited because the two spots next to their favorite employee 1 are taken.
So the company leaves them out of the meeting.
The maximum number of employees that can be invited to the meeting is 4.
 

Constraints:

n == favorite.length
2 <= n <= 105
0 <= favorite[i] <= n - 1
favorite[i] != i
 */