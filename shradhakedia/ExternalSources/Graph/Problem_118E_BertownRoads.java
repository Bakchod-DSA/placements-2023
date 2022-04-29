/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://codeforces.com/problemset/problem/118/E
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem_118E_BertownRoads {

    static int timer = 0;

    public static void main(String[] args) throws IOException {

        List<Pair> roads = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        LinkedList<Integer>[] graph = new LinkedList[n + 1];
        for(int i = 1; i < n + 1; i++) {
            graph[i] = new LinkedList<>();
        }

        while(m-- > 0) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] visited = new int[n + 1];
        int[] in = new int[n + 1];
        int[] lowestAncestorIn = new int[n + 1];

        boolean bridgeExists = dfs(1, -1, visited, graph, in, lowestAncestorIn, roads);
        if(bridgeExists) {
            System.out.println(0);
        } else {
            for(Pair pair : roads) {
                System.out.println(pair.first + " " + pair.second);
            }
        }

    }

    private static boolean dfs(int v, int parent, int[] visited, LinkedList<Integer>[] graph, int[] in, int[] lowAncestorIn, List<Pair> roads) {
        visited[v] = 1;
        in[v] = timer;
        lowAncestorIn[v] = timer;
        timer++;

        for(int child : graph[v]) {
            if(visited[child] == 0) {
                // forward edge
                if(dfs(child, v, visited, graph, in, lowAncestorIn, roads)) {
                    // bridge exists for child
                    return true;
                }

                if(lowAncestorIn[child] > in[v]) {
                    // bridge exists for node v
                    return true;
                }

                roads.add(new Pair(v, child));
                lowAncestorIn[v] = Math.min(lowAncestorIn[v], lowAncestorIn[child]);
            } else if(parent != child) {
                // back edge, here it is not necessary that child is ancestor
                lowAncestorIn[v] = Math.min(lowAncestorIn[v], in[child]);

                // when child is ancestor add it to result
                if(in[child] < in[v]) {
                    roads.add(new Pair(v, child));
                }

            }
        }

        return false;
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
