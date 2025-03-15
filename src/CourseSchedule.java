import java.util.*;

//https://leetcode.com/problems/course-schedule/description/
public class CourseSchedule {
    public boolean canFinish(int num, int[][] pre) {
        if (pre.length == 0) return true;
        int[] indegree = new int[num];
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            adjList.add(i, new ArrayList<>());
        }

        for (int i = 0; i < pre.length; i++) {
            indegree[pre[i][1]]++;
            adjList.get(pre[i][0]).add(pre[i][1]);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[num];
        for (int i = 0; i < num; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                visited[i] = true;
            }
        }

        int processedNodes = 0;

        while(!q.isEmpty()) {
            for (int val : adjList.get(q.poll())) {
                indegree[val]--;
                if (indegree[val] == 0 && !visited[val]) {
                    visited[val] = true;
                    q.add(val);
                }
            }

            processedNodes++;
        }
        return processedNodes == num;
    }
}
