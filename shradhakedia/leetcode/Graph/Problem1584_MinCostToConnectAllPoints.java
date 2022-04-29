/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/min-cost-to-connect-all-points/
 * Difficulty level: Medium
 */

package leetcode.Graph;

import java.util.*;

public class Problem1584_MinCostToConnectAllPoints {

    int[] parent;

    public int minCostConnectPoints(int[][] points) {
        return approachOne(points);
    }

    private int approachOne(int[][] points) {
        /*  Approach: kruskal's algo, MST(graph), points are the nodes here
            Time Complexity: O(n ^ 2 + n ^ 2.log(n ^ 2) + n ^ 2.α(n)) ≈ O(n ^ 2.log(n ^ 2)) ≈ O(n ^ 2.log(n)), first to create
                             edges array, then for sorting the array, then TC for union find is α(n) and we do this n ^ 2 times
                             in worrst case.
            Space Complexity: O(n ^ 2), to store edges
        */

        int n = points.length;
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dis = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                edges.add(new Edge(i, j, dis));
            }
        }

        Collections.sort(edges);
        parent = new int[n];
        Arrays.fill(parent, -1);

        int edgesUsed = 0, sum = 0;
        for(int i = 0; i < edges.size() && edgesUsed < n - 1; i++) {
            // MST can have atmost n - 1 edges. => edgesUsed < n - 1

            int u = edges.get(i).src;
            int v = edges.get(i).dest;

            int x = find(u);
            int y = find(v);
            if(x != y) {
                union(x, y);
                sum += edges.get(i).wt;
                edgesUsed++;
            }
        }

        return sum;
    }

    private int find(int x) {
        if(parent[x] == -1) {
            // self edge
            return x;
        }

        // path compression going from parent to parent untill we reach a vertex where there is a self loop
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int x, int y) {
        parent[x] = y;
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
