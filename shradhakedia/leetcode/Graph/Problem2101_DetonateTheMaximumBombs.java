/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/detonate-the-maximum-bombs/
 * Difficulty level: Medium
 */

package leetcode.Graph;

import java.util.*;

public class Problem2101_DetonateTheMaximumBombs {

    List<Integer>[] graph;
    int[] visited;

    public int maximumDetonation(int[][] bombs) {
        /*  Approach: dfs
            Time Complexity: O(2n(n + e)), n + e to make graph, n + e for dfs
            Space Complexity: O(n + e + n), n + e for graph, n for visited.
        */

        int n = bombs.length;
        buildGraph(bombs, n);

        int maxBombDetonated = Integer.MIN_VALUE;
        visited = new int[n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(visited, 0);
            int numBombDetonated = dfs(i);
            maxBombDetonated = Math.max(maxBombDetonated, numBombDetonated);
        }

        return maxBombDetonated;
    }

    private void buildGraph(int[][] bombs, int n) {
        graph = new List[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            int[] bomb1 = bombs[i];
            int x1 = bomb1[0];
            int y1 = bomb1[1];
            long r = bomb1[2];

            for(int j = 0; j < n; j++) {
                int[] bomb2 = bombs[j];
                int x2 = bomb2[0];
                int y2 = bomb2[1];

                if(i != j) {
                    long dx = (x1 - x2);
                    long dy = (y1 - y2);
                    if(dx * dx + dy * dy <= r * r) {
                        graph[i].add(j);
                    }
                }
            }
        }
    }

    private int dfs(int v) {
        visited[v] = 1;

        int n = 1;
        for(int child : graph[v]) {
            if(visited[child] == 0) {
                n += dfs(child);
            }
        }

        return n;
    }
}
