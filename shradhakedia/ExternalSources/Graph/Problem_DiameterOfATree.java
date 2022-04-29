/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.spoj.com/problems/PT07Z/
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Problem_DiameterOfATree {

    private static int maxDis;
    private static int farthestNode;

    public static void main(String[] args) throws IOException {
        /*  Approach: dfs
            Time Complexity: O(2n)
            Space Complexity: O(n)
            Explanation: Its a proof that after choosing any arbitrary node and running dfs on it to find the farthest node
                         We end up finding one of the ends of the diameter this running a dfs on this node again gives
                         us the diameter of the tree.
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // LinkedList<Integer>[] adjacencyList = makeAdjacencyList(n, e);
        LinkedList<Integer>[] adjacencyList = new LinkedList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        int[] visited = new int[n + 1];

        maxDis = Integer.MIN_VALUE;
        dfs(1, 0, visited, adjacencyList);

        Arrays.fill(visited, 0);
        maxDis = Integer.MIN_VALUE;
        dfs(farthestNode, 0, visited, adjacencyList);

        System.out.println(maxDis);
    }

    private static void dfs(int v, int dis, int[] visited, LinkedList<Integer>[] adjacencyList) {
        visited[v] = 1;

        for(int child : adjacencyList[v]) {
            if(visited[child] == 0) {
                if(maxDis < dis + 1) {
                    maxDis = dis + 1;
                    farthestNode = child;
                }
                dfs(child, dis + 1, visited, adjacencyList);
            }
        }
    }
}
