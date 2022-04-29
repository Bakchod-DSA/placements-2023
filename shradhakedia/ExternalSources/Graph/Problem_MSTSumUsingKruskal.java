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
import java.util.Arrays;

public class Problem_MSTSumUsingKruskal {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]);
            int v = Integer.parseInt(uvw[1]);
            int w = Integer.parseInt(uvw[2]);
            edges[i] = new Edge(u, v, w);
        }
        Arrays.sort(edges);
//        System.out.println(Arrays.toString(edges));

        int sum = 0;
        for(int i = 0; i < m; i++) {
            Edge e = edges[i];
            int u = e.src;
            int v = e.dest;

            int x = find(u);
            int y = find(v);
//            System.out.println("Step " + (i + 1));
//            System.out.println(u + ": " + x + ", " + v + ": " + y);
//            System.out.println(Arrays.toString(parent));
            if(x != y) {
                union(x, y);
                sum += e.wt;
            }
//            System.out.println(Arrays.toString(parent));
        }

        System.out.println(sum);
    }

    private static int find(int a) {
        if(parent[a] == -1) {
            return a;
        }

        parent[a] = find(parent[a]);
        return parent[a];
    }

    private static void union(int a, int b) {
        parent[a] = b;
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
