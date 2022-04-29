/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/bishu-and-his-girlfriend/
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_SingleSourceShortestPathOnTreeUsingDFS {

    public static void main(String[] args) throws Exception {
        /*  Approach: dfs
            Time Complexity: O(n)
            Space Complexity:
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

        Set<Integer> girlsInCountry = new HashSet<>();
        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i < q; i++) {
            girlsInCountry.add(Integer.parseInt(br.readLine()));
        }

        int[] visited = new int[n + 1];
        int[] dis = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            if(visited[i] == 0) {
                dfs(i, dis, visited, adjacencyList);
            }
        }

        int minDis = Integer.MAX_VALUE;
        int countryId = 0;
        for(int d = 1; d < n + 1; d++) {
            if(minDis > dis[d] && girlsInCountry.contains(d)) {
                minDis = dis[d];
                countryId = d;
            }
        }

        System.out.println(countryId);

    }


    private static void dfs(int v, int[] dis, int[] visited, LinkedList<Integer>[] adjacencyList) {
        visited[v] = 1;
        for(int child : adjacencyList[v]) {
            if(visited[child] == 0) {
                dis[child] = dis[v] + 1;
                dfs(child, dis, visited, adjacencyList);
            }
        }
    }
}
