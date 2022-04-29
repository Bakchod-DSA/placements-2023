/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Problem_IsItATree {

    public static void main(String[] args) throws IOException {
        /*  Approach: dfs
            Time Complexity: O(n)
            Space Complexity:
            Note: 1. A tree is always a connected graph so call for the root only.
                  2. A tree does not has cycle. can also be considered as cycle detection in an undirected graph.
            Explanation: To include all the vertex in the graph as a single component we need at least n -1 edges
                         and if we dont include all connected component will be more than 1 and if we connect all edges and
                         make a cycle also then no. of edges will be more than n - 1.
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ne = br.readLine().split(" ");
        int n = Integer.parseInt(ne[0]);
        int e = Integer.parseInt(ne[1]);

        LinkedList<Integer>[] adjacencyList = new LinkedList[n + 1];
        for(int i = 0; i < n + 1; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

        for(int i = 0; i < e; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        int[] visited = new int[n + 1];

        int ccCount = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, adjacencyList);
                ccCount++;
            }
        }

        if(ccCount == 1 && n - 1 == e) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void dfs(int v, int[] visited, LinkedList<Integer>[] adjacencyList) {
        visited[v] = 1;
        for (int child : adjacencyList[v]) {
            if(visited[child] == 0) {
                dfs(child, visited, adjacencyList);
            }
        }
    }
}
