/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/feasible-relations/
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.io.*;
import java.util.*;

public class Problem_FeasibleRelations {

    private static int cc_count;

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            cc_count = 0;
            String[] ne = br.readLine().split(" ");
            int n = Integer.parseInt(ne[0]);
            int e = Integer.parseInt(ne[1]);

            List<Pair> notEquals = new ArrayList<>();
            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            while(e-- > 0) {
                String[] urv = br.readLine().split(" ");
                int u = Integer.parseInt(urv[0]);
                int v = Integer.parseInt(urv[2]);

                if(urv[1].equals("=")) {
                    graph.get(u).add(v);
                    graph.get(v).add(u);
                } else {
                    notEquals.add(new Pair(u, v));
                }
            }

            // nahi milne chahiye pair elements, graph me
            // bfs code gives TLE
            /*
            int flag = 0;
            int[] visited = new int[n + 1];
            for(Pair pair : notEquals) {
                Arrays.fill(visited, 0);
                boolean isFound = bfs(pair.first, pair.second, visited, graph);
                if(isFound) {
                    flag = 1;
                    System.out.println("NO");
                    break;
                }
            }

            if(flag == 0) {
                System.out.println("YES");
            }
            */

            int[] visited = new int[n + 1];
            int[] cc = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                if(visited[i] == 0) {
                    cc_count++;
                    dfs(i, cc, visited, graph);
                }
            }

            int flag = 0;
            for(Pair pair : notEquals) {
                if(cc[pair.first] == cc[pair.second]) {
                    flag = 1;
                    System.out.println("NO");
                    break;
                }
            }

            if(flag == 0) {
                System.out.println("YES");
            }
        }

    }

    private static boolean bfs(int source, int destination, int[] visited, List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();

        visited[source] = 1;
        queue.add(source);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int node = queue.remove();

                if(node == destination) {
                    return true;
                }

                for(int child : graph.get(node)) {
                    if(visited[child] == 0) {
                        visited[child] = 1;
                        queue.add(child);
                    }
                }
            }
        }

        return false;
    }

    private static void dfs(int v, int[] cc, int[] visited, List<List<Integer>> graph) {
        visited[v] = 1;
        cc[v] = cc_count;

        for(int child : graph.get(v)) {
            if(visited[child] == 0) {
                dfs(child, cc, visited, graph);
            }
        }
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
