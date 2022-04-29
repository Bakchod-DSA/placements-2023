/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/practice-problems/algorithm/minimum-spanning-tree-5/
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_MSTSumUsingPrims {

    static int[] visited;
    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        visited = new int[n + 1];
        graph = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]);
            int v = Integer.parseInt(uvw[1]);
            int w = Integer.parseInt(uvw[2]);
            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));

        }

        int sum = prims();
        System.out.println(sum);
    }

    private static int prims() {
        Queue<Edge> minHeap = new PriorityQueue<>();
        minHeap.add(new Edge(0, 1, 0));

        int sum = 0;
        while(!minHeap.isEmpty()) {
            Edge edge = minHeap.remove();
            int node = edge.dest;
            if(visited[node] == 1) {
                continue;
            }
            visited[node] = 1;
            sum += edge.wt;
            for(Edge child : graph[node]) {
                if(visited[child.dest] == 0) {
                    minHeap.add(child);
                }
            }
        }

        return sum;
    }

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }


        @Override
        public int compareTo(Edge edge2) {
            return this.wt - edge2.wt;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "src=" + src +
                    ", dest=" + dest +
                    ", wt=" + wt +
                    '}';
        }
    }
}
