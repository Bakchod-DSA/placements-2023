/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-eventual-safe-states/
 * Difficulty level: Medium
 */

package leetcode.Graph;

import java.util.*;

public class Problem802_EventualSafeStates {

    List<Integer>[] revGraph;
    int[] in;
    boolean[] safe;

    int[] visited;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        return approachTwo(graph);
    }

    private List<Integer> approachOne(int[][] graph) {
        /*  Approach: Topological sorting using Kahn's Algo
            Time Complexity: O(2(n + e)), e = sum(graph[i].length) i.e. e is no. of edges, n = graph.length, for making graph (n + e) time
                             then for kahn's algo.
            Space Complexity: O(n + e + 3n), n + e for revGraph, 3n for in, safe and queue.
        */

        int n = graph.length;
        revGraph = new List[n];
        in = new int[n];
        safe = new boolean[n];

        for(int i = 0; i < n; i++) {
            revGraph[i] = new LinkedList<>();
        }

        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                revGraph[graph[i][j]].add(i);
                in[i]++;
            }
        }

        return findSafeNodes(n);
    }

    private List<Integer> findSafeNodes(int n) {

        List<Integer> safeNodes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(in[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.remove();
            safe[node] = true;

            for(int child : revGraph[node]) {
                in[child]--;
                if(in[child] == 0) {
                    queue.add(child);
                }
            }
        }

        for(int i = 0; i < n ; i++) {
            if(safe[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private List<Integer> approachTwo(int[][] graph) {
        /*  Approach: Dfs for cycle detection in directed graph
            Time Complexity: O((n + e)), e = sum(graph[i].length) i.e. e is no. of edges, n = graph.length.
            Space Complexity: O(n), n for visited.
        */

        int n = graph.length;
        visited = new int[n];
        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            // we have to run dfs for all the nodes because its a directed cycle. maybe there is a cycle from anode which dfss determines, but
            // there was another node from that cycle causing node, which was safe and needs to be added to answer, hence we need to visit it so
            // we run dfs on all nodes. eg. test case 1: 2 goes to 3 and 5, 3 causes cycle can be determined first but 2 goes to 5 also and is a
            // terminal node and hence safe node needs to be appended to the answer.

            if(!dfs(i, graph)) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean dfs(int v, int[][] graph) {

        visited[v] = 1;
        for(int child : graph[v]) {
            if(visited[child] == 0) {
                if(dfs(child, graph)) {
                    return true;
                }
            } else if(visited[child] == 1) {
                return true;
            }
        }

        visited[v] = 2;
        return false;
    }
}
