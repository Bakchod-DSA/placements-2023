/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/critical-connections-in-a-network/
 * Difficulty level: Medium
 */

package leetcode.Graph;

import java.util.*;

public class Problem1192_CriticalConnections {

    int timer = 0;
    List<List<Integer>> criticalCons;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        /*  Approach: dfs
            Time Complexity: O(2(n + e)), n + e to make graph, n + e for dfs
            Space Complexity: O(n + e + 3n), n + e for graph, n for visited, in, low.
        */

        criticalCons = new ArrayList<>();
        LinkedList<Integer>[] graph = new LinkedList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for(List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] visited = new int[n];
        int[] in = new int[n];
        int[] low = new int[n];
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                dfs(i, -1, visited, graph, in, low);
            }
        }

        return criticalCons;
    }


    private void dfs(int v, int parent, int[] visited, LinkedList<Integer>[] graph, int[] in, int[] low) {
        // Approach: Finding bridges.
        visited[v] = 1;
        in[v] = timer;
        low[v] = timer;
        timer++;

        for(int child : graph[v]) {
            if(visited[child] == 0) {
                // explore child and then as its a forward edge, check bridge.
                dfs(child, v, visited, graph, in, low);
                if(low[child] > in[v]) {
                    criticalCons.add(new ArrayList<>(Arrays.asList(v, child)));
                }
                low[v] = Math.min(low[v], low[child]);
            } else if(parent != child) {
                // back edge, update low time of v if its ancestor has lower in time.
                low[v] = Math.min(low[v], in[child]);
            }
        }
    }
}
