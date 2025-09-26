package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _course_scheduler_2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i=0; i<numCourses; i++) adj[i] = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int[] p: prerequisites) {
            adj[p[1]].add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int[] topo = new int[numCourses];
        int i = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            topo[i++] = cur;

            for (int nei: adj[cur]) {
                indegree[nei]--;
                if (indegree[nei] == 0) q.offer(nei);
            }
        }        
        return i == numCourses ? topo: new int[0];
    }
}
