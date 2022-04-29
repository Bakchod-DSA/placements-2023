package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Problem_FindingBridges {

    static int timer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        int[] visited = new int[n + 1];
        int[] in = new int[n + 1];
        int[] lowestAncestorIn = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            if(visited[i] == 0) {
                dfs(i, -1, visited, graph, in, lowestAncestorIn);
            }
        }
    }

    private static void dfs(int v, int parent, int[] visited, LinkedList<Integer>[] graph, int[] in, int[] lowAncestorIn) {
        visited[v] = 1;
        in[v] = timer;
        lowAncestorIn[v] = timer;
        timer++;

        for(int child : graph[v]) {
            if(visited[child] == 0) {
                // explore child and then as its a forward edge, check bridge.
                dfs(child, v, visited, graph, in, lowAncestorIn);
                if(lowAncestorIn[child] > in[v]) {
                    System.out.println(v + " - " + child + " is a bridge.");
                }
                lowAncestorIn[v] = Math.min(lowAncestorIn[v], lowAncestorIn[child]);
            } else if(parent != child) {
                // back edge, update low time of v if its ancestor has lower in time.
                lowAncestorIn[v] = Math.min(lowAncestorIn[v], in[child]);
            }
        }
    }
}
