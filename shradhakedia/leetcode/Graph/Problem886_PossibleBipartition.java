/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/possible-bipartition/
 * Difficulty level: Medium
 */

package leetcode.Graph;

import java.util.*;

public class Problem886_PossibleBipartition {

    List<Integer>[] graph;
    int[] visited;
    int[] color;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        /*  Approach: dfs
            Time Complexity: O(2(n + e)), n + e to make graph, n + e for dfs
            Space Complexity: O(n + e + n), n + e for graph, n for visited.
        */

        buildGraph(n, dislikes);

        visited = new int[n + 1];
        color = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            if(visited[i] == 0) {
                if(!dfs(i, 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    private void buildGraph(int n, int[][] dislikes) {
        graph = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] dislike : dislikes) {
            int u = dislike[0];
            int v = dislike[1];

            graph[u].add(v);
            graph[v].add(u);
        }
    }

    private boolean dfs(int v, int c) {
        visited[v] = 1;
        color[v] = c;

        for(int child : graph[v]) {
            if(visited[child] == 0) {
                boolean isBipartite = dfs(child, c ^ 1);
                if(!isBipartite) {
                    return false;
                }
            } else if(color[v] == color[child]) {
                return false;
            }
        }

        return true;
    }
}
