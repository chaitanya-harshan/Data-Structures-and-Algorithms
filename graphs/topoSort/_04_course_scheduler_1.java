package graphs.topoSort;

import java.util.*;

public class _04_course_scheduler_1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i=0; i<numCourses; i++) adj[i] = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int[] p: prerequisites) { // edges are given in reverse: 
            // head should have tail as dependency and not other way round
            // for doing topo sort on graph 
            adj[p[1]].add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<numCourses; i++) if (indegree[i] == 0) q.offer(i);
        int cnt = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;

            for (int nei: adj[cur]) {
                if (--indegree[nei] == 0) q.offer(nei);
            }
        }        
        return cnt == numCourses;
    }
}

/*
 * URL: https://leetcode.com/problems/course-schedule/description/

207. Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 
Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 
Constraints:

	1 <= numCourses <= 2000
	0 <= prerequisites.length <= 5000
	prerequisites[i].length == 2
	0 <= ai, bi < numCourses
	All the pairs prerequisites[i] are unique.
 */