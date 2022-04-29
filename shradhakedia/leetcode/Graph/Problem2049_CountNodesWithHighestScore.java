/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/count-nodes-with-the-highest-score/
 * Difficulty level: Medium
 */

package leetcode.Graph;

import java.util.*;

public class Problem2049_CountNodesWithHighestScore {

    long max;
    int count;

    public int countHighestScoreNodes(int[] parents) {
        /*  Approach: dfs
            Time Complexity: O(2(n + e)), n + e to make graph, n + e for dfs
            Space Complexity: O(n + e + n), n + e for graph, n for visited.
        */

        int n = parents.length;
        count = 0;
        max = Long.MIN_VALUE;

        LinkedList<Integer>[] graph = new LinkedList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int i = 1; i < n; i++) {
            int u = i;
            int v = parents[i];
            graph[v].add(u);
        }

        int[] visited = new int[n];
        dfs(0, visited, graph);

        return count;
    }


    private int dfs(int v, int[] visited, LinkedList<Integer>[] graph) {
        visited[v] = 1;

        int n = 1;
        long product = 1;
        int self = graph.length - 1;
        for(int child : graph[v]) {
            if(visited[child] == 0) {
                int size = dfs(child, visited, graph);
                n += size;
                product *= size;
                self -= size;
            }
        }

        if(v != 0) {
            product *= self;
        }

        if(max < product) {
            count = 1;
            max = product;
        } else if(max == product) {
            count++;
        }

        return n;
    }
}
