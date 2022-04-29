/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : problem: https://www.codechef.com/problems/FIRESC
 *          solution: https://www.codechef.com/viewsolution/62877830
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Problem_FireEscapeRoute {

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
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

            long cc_count = 0l;
            long product = 1l;
            int[] visited = new int[n + 1];
            for(int i = 1; i < n + 1; i++) {
                if(visited[i] == 0) {
                    long numOfNodes = dfs(i, visited, graph) + 1;
                    product = (product * numOfNodes) % 1000000007 ;
                    cc_count++;
                }
            }

            System.out.println(cc_count + " " + product);
        }
    }

    private static long dfs(int v, int[] visited, LinkedList<Integer>[] graph) {
        visited[v] = 1;

        if(graph[v].isEmpty()) {
            return 0;
        }

        int n = 0;
        for(Object obj : graph[v]) {
            int child = (int) obj;
            if(visited[child] == 0) {
                n += dfs(child, visited, graph) + 1;
            }
        }

        return n;
    }
}
