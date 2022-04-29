package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_SSSPDijkstraAlgorithm {

    private static List<Pair>[] graph;
    private static int[] dist;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        buildGraph(n);

        // SSSP from 1 to all the nodes.
        dijkstra();

        System.out.println(Arrays.toString(Arrays.copyOfRange(dist, 1, dist.length)));
    }

    private static void buildGraph(int n) throws IOException {

        graph = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        int e = Integer.parseInt(br.readLine());
        for (int i = 0; i < e; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]);
            int v = Integer.parseInt(uvw[1]);
            int wt = Integer.parseInt(uvw[2]);
            graph[u].add(new Pair(v, wt));
            graph[v].add(new Pair(u, wt));
        }
    }

    private static void dijkstra() {
        Queue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(1, 0));
        dist[1] = 0;

        while (!queue.isEmpty()) {
            Pair node = queue.remove();
            for(Pair edge : graph[node.dest]) {
                // if distance hold by the child is larger then wt + dis[parent/node] then update the distance
                // and add this updated distance and child to the queue to explore further its child .
                if (dist[node.dest] + edge.wt < dist[edge.dest]) {
                    dist[edge.dest] = dist[node.dest] + edge.wt;
                    queue.add(new Pair(edge.dest, dist[edge.dest]));
                }
            }
        }
    }

    private static class Pair implements Comparable<Pair> {
        int dest, wt;

        Pair(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair p2) {
            return wt - p2.wt;
        }
    }

}
