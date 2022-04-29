/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : 1. https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 *          2. https://www.hackerearth.com/problem/algorithm/connected-components-in-a-graph/ (I solved it here).
 * Difficulty level: Medium
 */

package leetcode.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem323_NumberOfConnectedComponentsInUndirectedGraph {

    public static void main(String[] args) throws Exception {
        /*  Approach: dfs
            Time Complexity: O(n)
            Space Complexity:
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ve = br.readLine().split(" ");
        int n = Integer.parseInt(ve[0]);
        int e = Integer.parseInt(ve[1]);

        // LinkedList<Integer>[] adjacencyList = makeAdjacencyList(n, e);
        LinkedList<Integer>[] adjacencyList = new LinkedList[n + 1];
        for(int i = 1; i < n + 1; i++) {
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
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(visited[i] == 0) {
                dfs(i, visited, adjacencyList);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int vertex, int[] visited, LinkedList<Integer>[] adjacencyList) {

        visited[vertex] = 1;
        for(int child: adjacencyList[vertex]) {
            if(visited[child] == 0) {
                dfs(child, visited, adjacencyList);
            }
        }
    }
}
