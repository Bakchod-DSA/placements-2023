/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-if-path-exists-in-graph/
 * Difficulty level: Easy
 */

package leetcode.Graph;

import java.util.*;

public class Problem1971_FindIfPathExistsInGraph {

    int[] visited;
    List<Integer>[] graph;

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        buildGraph(n, edges);

        visited = new int[n];
        dfs(source);

        return visited[destination] == 1;
    }

    private void buildGraph(int n, int[][] edges) {
        /*  Approach: Graph representation: Adjacency list.
            Time Complexity: O(n + e), e = edges.length
            Space Complexity: O(n ^ 2)
        */

        graph = new List[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
    }

    private void dfs(int v) {
        /*  Approach: dfs
            Time Complexity: O(n + e), e = edges.length
            Space Complexity: O(n + e)
        */

        visited[v] = 1;

        for(int child : graph[v]) {
            if(visited[child] == 0) {
                dfs(child);
            }
        }
    }
}
