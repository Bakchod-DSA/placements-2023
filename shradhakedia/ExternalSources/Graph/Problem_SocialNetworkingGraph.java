/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://assessment.hackerearth.com/challenges/college/lab-test-4/algorithm/02f1c79b00844701ab4414e7b8ac4626/
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.io.*;
import java.util.*;

public class Problem_SocialNetworkingGraph {

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        LinkedList<Integer>[] graph = new LinkedList[n + 1];
        for(int i = 0; i < n + 1; i++) {
            graph[i] = new LinkedList<>();
        }

        while(m-- > 0) {

            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);

            graph[u].add(v);
            graph[v].add(u);
        }

        int q = Integer.parseInt(br.readLine());
        while(q-- > 0) {

            int[] visited = new int[n + 1];
            int[] dis = new int[n + 1];

            String[] vt = br.readLine().split(" ");
            int v = Integer.parseInt(vt[0]);
            int t = Integer.parseInt(vt[1]);

            bfs(v, dis, visited, graph);

            int c = 0;
            for(int d : dis) {
                if(d == t) {
                    c++;
                }
            }

            System.out.println(c);
        }
    }

    private static void bfs(int source, int[] dis, int[] visited, List<Integer>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int node = queue.remove();

                for(int child : graph[node]) {
                    if(visited[child] == 0) {
                        visited[child] = 1;
                        queue.add(child);
                        dis[child] = dis[node] + 1;
                    }
                }
            }
        }
    }
}

