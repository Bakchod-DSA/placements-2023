/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/is-graph-bipartite/
 * Difficulty level: Medium
 */

package leetcode.Graph;

public class Problem785_IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        /*  Approach: dfs
            Time Complexity: O(n)
            Space Complexity: The length of longest path = m. For each node, you have to store its siblings so that when you have visited all
                              the children, and you come back to a parent node, you can know which sibling to explore next. For m nodes down
                              the path, you will have to store b nodes extra for each of the m nodes. That’s how you get an O(bm) space
                              complexity.
        */

        int n = graph.length;
        int[] visited = new int[n];
        int[] color = new int[n];

        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                boolean isBipartite = dfs(i, 0, visited, color, graph);
                if(!isBipartite) {
                    return false;
                }
            }
        }

        return true;
    }

    // graph = adjacency list
    public boolean dfs(int v, int c, int[] visited, int[] color, int[][] graph) {
        // parent and child cannot have same color
        visited[v] = 1;
        color[v] = c;
        for(int child : graph[v]) {
            if(visited[child] == 0) {

                boolean isBipartite = dfs(child, color[v] ^ 1, visited, color, graph);
                if(!isBipartite) {
                    return false;
                }
            } else if(color[child] == color[v]) {
                return false;
            }
        }

        return true;
    }

}
