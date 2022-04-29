/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.spoj.com/problems/TOPOSORT/
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_TopologicalSorting {

    static int[] inDegree;
    static List<Integer>[] graph;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        buildGraph(n, m);

        kahn(n);
    }

    private static void buildGraph(int n, int m) throws IOException {
        /*  Approach: Graph representation: Adjacency list.
            Time Complexity: O(n + e), e = edges.length
            Space Complexity: O(n ^ 2)
        */

        graph = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        inDegree = new int[n + 1];
        while(m-- > 0) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);

            graph[u].add(v);
            inDegree[v]++;
        }
    }

    private static void kahn(int n) {

        int count = 0;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.remove();
            count++;
            sb.append(node).append(" ");
            for(int child : graph[node]) {
                inDegree[child]--;
                if(inDegree[child] == 0) {
                    queue.add(child);
                }
            }
        }

        if(count != n) {
            System.out.println("Sandro fails.");
        } else  {
            System.out.println(sb.substring(0, sb.length()));
        }
    }
}

