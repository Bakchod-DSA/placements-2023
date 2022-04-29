/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/course-schedule/
 * Difficulty level: Medium
 */

package leetcode.Graph;

import java.util.*;

public class Problem207_CourseSchedule {

    int[] inDegree;
    List<Integer>[] graph;
    int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses, prerequisites);
        // return approachOne(numCourses);
        return approachTwo(numCourses);

    }

    private void buildGraph(int numCourses, int[][] prerequisites) {
        graph = new LinkedList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        inDegree = new int[numCourses];
        for(int[] uv : prerequisites) {
            int u = uv[0];
            int v = uv[1];
            graph[v].add(u);
            inDegree[u]++;
        }
    }

    private boolean approachOne(int numCourses) {
        /*  Approach: dfs
            Time Complexity: O(2(n + e)), n + e to make graph, n + e for dfs
            Space Complexity: O(n + e + n), n ^ 2 for graph, n for visited.
        */

        visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == 0) {
                if(detectCycleInDirectedGraph(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean detectCycleInDirectedGraph(int v) {
        visited[v] = 1;
        for(Object node : graph[v]) {
            int child = (int) node;
            if(visited[child] == 0) {
                if(detectCycleInDirectedGraph(child)) {
                    return true;
                }
            } else if(visited[child] == 1) {
                return true;
            }
        }

        visited[v] = 2;
        return false;
    }

    private boolean approachTwo(int numCourses) {
        /*  Approach: dfs
            Time Complexity: O(2(n + e)), n + e to make graph, n + e for dfs
            Space Complexity: O(n + e + n), n ^ 2 for graph, n for inDegree.
        */

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.remove();
            count++;
            for(int child : graph[node]) {
                inDegree[child]--;
                if(inDegree[child] == 0) {
                    queue.add(child);
                }
            }
        }

        if(count != numCourses) {
            return false;
        } else  {
            return true;
        }
    }
}
