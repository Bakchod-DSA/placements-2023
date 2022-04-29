/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/course-schedule-ii/
 * Difficulty level: Medium
 */

package leetcode.Graph;

import java.util.*;

public class Problem210_CourseScheduleII {

    int[] inDegree;
    List<Integer>[] graph;
    int[] orderedCourses;
    int[] visited;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        buildGraph(numCourses, prerequisites);

        // boolean canFinish = approachTwo(numCourses);
        boolean canFinish = approachOne(numCourses);
        return (canFinish)? orderedCourses : new int[0];
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
        /*  Approach: dfs cycle detection in directed graph, if no cycle return the stack containing topological sorted order.
            Time Complexity: O(2(v + e))
            Space Complexity: O(v + e)
        */

        Stack<Integer> stack = new Stack<>();
        visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == 0) {
                if(dfs(i, stack)) {
                    // if cycle exists
                    return false;
                }
            }
        }

        int idx = 0;
        orderedCourses = new int[numCourses];
        while(!stack.isEmpty()) {
            orderedCourses[idx++] = stack.pop();
        }
        return true;
    }

    private boolean dfs(int v, Stack<Integer> stack) {
        /*  Approach: dfs cycle detection in directed graph
            Time Complexity: O(v + e)
            Space Complexity: O(v + e)
        */

        visited[v] = 1;
        for(Object node : graph[v]) {
            int child = (int) node;
            if(visited[child] == 0) {
                if(dfs(child, stack)) {
                    return true;
                }
            } else if(visited[child] == 1) {
                return true;
            }
        }

        // add the node only when all its neighbor are processed so by this way the curr node will be at the top,
        // means when we pop it out. it will be popped out first before any of its neighbor
        // indicating it is a prerequisite for them.
        stack.push(v);
        visited[v] = 2;
        return false;
    }

    private boolean approachTwo(int numCourses) {
        /*  Approach: Kahn's Algorithm
            Time Complexity: O(2(v + e)), one for building graph too.
            Space Complexity: O(v + e)
        */

        int count = 0;
        orderedCourses = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.remove();
            orderedCourses[count++] = node;
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
