/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/monk-and-the-islands/
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_SingleSourceShortestPathOnUnweightedGraphBFS {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ne = br.readLine().split(" ");
        int n = Integer.parseInt(ne[0]);
        int e = Integer.parseInt(ne[1]);

        LinkedList<Integer>[] graph = new LinkedList[n + 1];
        for(int i = 1; i < n + 1; i++) {
            graph[i] = new LinkedList<>();
        }

        while(e-- > 0) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);

            graph[u].add(v);
            graph[v].add(u);
        }

        int source = Integer.parseInt(br.readLine());

        int[] visited = new int[n + 1];
        int[] distance = new int[n + 1];
        int sssp = bfs(source, distance, visited, graph);

        System.out.println(sssp);
    }

    private static int bfs(int source, int[] distance, int[] visited, LinkedList<Integer>[] graph) {
        Queue<Integer> queue = new LinkedList<>();

        visited[source] = 1;
        queue.add(source);

        while(!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int node = queue.remove();
                for(int child : graph[node]) {

                    if (visited[child] == 0) {
                        visited[child] = 1;
                        queue.add(child);
                        distance[child] = distance[node] + 1;
                    }
                }
            }
        }

        return distance[distance.length - 1];
    }
}
