/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/course-schedule-iv/
 * Difficulty level: Medium
 */

package leetcode.Graph;

import java.util.*;

public class Problem1462_CourseScheduleIV {

    Set<Integer>[] prerequisiteList;
    List<Integer>[] graph;
    int[] in;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        in = new int[numCourses];
        graph = new List[numCourses];
        prerequisiteList = new Set[numCourses];

        buildGraph(numCourses, prerequisites);
        kahns(numCourses);
        List<Boolean> ans = processQueries(queries);

        return ans;
    }

    private void buildGraph(int numCourses, int[][] prerequisite) {
        /*  Approach: graph representation(adjacency list)
            Time Complexity: O(n + e)
            Space Complexity: O(n + e)
        */

        for(int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int[] edge :  prerequisite) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            in[v]++;
        }
    }

    private void kahns(int numCourses) {
        /*  Approach: Topological sort, Kahn's algo
            Time Complexity: O(n + e)
            Space Complexity: O(n + e)
        */

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            prerequisiteList[i] = new HashSet<>();
            if(in[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.remove();
            for(int child : graph[node]) {
                in[child]--;
                prerequisiteList[child].addAll(prerequisiteList[node]);
                prerequisiteList[child].add(node);
                if(in[child] == 0) {
                    queue.add(child);
                }
            }
        }
    }

    private List<Boolean> processQueries(int[][] queries) {
        /*  Time Complexity: O(n), n = queries.length
            Space Complexity: O(1), not including space consumed by answer.
        */

        List<Boolean> ans = new ArrayList<>();

        for(int[] query : queries) {
            int u = query[0];
            int v = query[1];

            if(prerequisiteList[v].contains(u)) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }
}
