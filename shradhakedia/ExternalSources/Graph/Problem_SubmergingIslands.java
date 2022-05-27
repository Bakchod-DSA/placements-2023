/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.spoj.com/problems/SUBMERGE/
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Problem_SubmergingIslands {

    private static int timer;
    private static LinkedList<Integer>[] graph;
    private static int[] visited;
    private static int[] in;
    private static int[] low;
    private static Set<Integer> articulationPoints;
    private static int count;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] ne = br.readLine().split(" ");
            int n = Integer.parseInt(ne[0]);
            int e = Integer.parseInt(ne[1]);

            if(n == 0 && e == 0) {
                break;
            }

            buildGraph(n, e);

            timer = 0;
            visited = new int[n + 1];
            in = new int[n + 1];
            low = new int[n + 1];
            articulationPoints = new HashSet<>();
            count = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0) {
                    dfs(i, -1);
                }
            }

            System.out.println(count);
        }
    }

    private static void buildGraph(int n, int e) throws IOException {
        graph = new LinkedList[n + 1];
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
    }

    private static void dfs(int v, int parent) {
        visited[v] = 1;
        in[v] = timer;
        low[v] = timer;
        timer++;

        int subtreeCount = 0;
        for(int child : graph[v]) {
            if(visited[child] == 0) {
                // forward edge, can be articulation point.
                dfs(child, v);
                if(low[child] >= in[v] && parent != -1) {
                    // parent != -1 because for root low[child] >= in[v] is always true, but if the root
                    // has only one subtree then it cannot be a articulation point. In order to be an articulation point,
                    // root should have more than one subtree.
                    // same articulation point can be found by its many children, so prefer using set to store articulation point.
                    if(articulationPoints.add(v)) {
                        count++;
                    }
                }
                low[v] = Math.min(low[v], low[child]);
                subtreeCount++;
            } else if(parent != child) {
                // if parent == child, it is the same edge it came from so we need to do nothing in that case.
                // back edge, cannot be an articulation point.

                // in case child is v's ancestor its in time will be less than v, and low[v] needs to be updated if this be the case.
                low[v] = Math.min(low[v], in[child]);
            }
        }

        if(parent == -1 && subtreeCount > 1) {
            // root is an articulation point
            if(articulationPoints.add(v)) {
                count++;
            }
        }
    }
}
