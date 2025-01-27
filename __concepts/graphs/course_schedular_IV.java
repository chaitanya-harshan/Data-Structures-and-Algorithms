package  __concepts.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class course_schedular_IV {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // @SuppressWarnings("unchecked")
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i=0; i<numCourses; i++) adj[i] = new HashSet<>();
        for (int[] pair : prerequisites) {
            adj[pair[1]].add(pair[0]);
        }

        boolean[] visited = new boolean[numCourses];
        for (int i=0; i<numCourses; i++) {
            if (!visited[i]) dfs(i, adj, visited);
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] pair : queries) {
            boolean res = adj[pair[1]].contains(pair[0]);
            ans.add(res);
        }
        return ans;
    }

    public static HashSet<Integer> dfs(int cur, HashSet<Integer>[] adj, boolean[] visited) {
        if (visited[cur]) return adj[cur];

        visited[cur] = true;
        HashSet<Integer> set = new HashSet<>(adj[cur]);
        for (int prereq: set) {
            adj[cur].addAll( dfs(prereq, adj, visited));
        }
        return adj[cur];
    }
}

/*
 * 1462. Course Schedule IV
https://leetcode.com/problems/course-schedule-iv/description/
https://www.youtube.com/watch?v=cEW05ofxhn0

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course ai first if you want to take course bi.

For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a prerequisite of course c, then course a is a prerequisite of course c.

You are also given an array queries where queries[j] = [uj, vj]. For the jth query, you should answer whether course uj is a prerequisite of course vj or not.

Return a boolean array answer, where answer[j] is the answer to the jth query.
 */