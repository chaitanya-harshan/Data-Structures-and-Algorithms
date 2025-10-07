package graphs.topoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _05_course_scheduler_2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int i = 0;
        int[] topo = new int[numCourses];

        while (!q.isEmpty()) {
            int cur = q.poll();
            topo[i++] = cur;

            for (int nei: adj[cur]) {
                if (--indegree[nei] == 0) q.offer(nei);
            }
        }        
        return i == numCourses ? topo: new int[0];
    }
}

/*
 * URL: https://leetcode.com/problems/course-schedule-ii/description/

210. Course Schedule II

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 
Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:
Input: numCourses = 1, prerequisites = []
Output: [0]

 
Constraints:

	1 <= numCourses <= 2000
	0 <= prerequisites.length <= numCourses * (numCourses - 1)
	prerequisites[i].length == 2
	0 <= ai, bi < numCourses
	ai != bi
	All the pairs [ai, bi] are distinct.
 */