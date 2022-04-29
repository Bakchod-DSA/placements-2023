package ExternalSources.Graph;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_FindDistanceBetweenAnyTwoNodes {

    private static BufferedReader br;
    private static List<Integer>[] graph;
    private static int[][] lca;
    private static int[] level;
    private static int maxN;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // build the graph
        buildGraph(n);
        // initialize level array and lca array
        init(n);

        int numQuery = Integer.parseInt(br.readLine());
        while(numQuery-- > 0) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            System.out.println(distance(a, b));
        }
    }

    private static void buildGraph(int n) throws IOException {
        graph = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            graph[u].add(v);
            graph[v].add(u);
        }
    }

    private static void init(int n) {
        level = new int[n + 1];
        maxN = (int) ((int) Math.log10(n)/Math.log10(2));
        lca = new int[n + 1][maxN + 1];
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < maxN + 1; j++) {
                lca[i][j] = -1;
            }
        }

        dfs(1, 0, -1);

        // col from 1 as we have filled 0 before
        for(int i = 1; i < maxN + 1; i++) {
            // row from one because we nodes from 1
            for(int j = 1; j < n + 1; j++) {
                if(lca[j][i - 1] != -1) {
                    int parent = lca[j][i - 1];
                    lca[j][i] = lca[parent][i - 1];

                }
            }
        }
    }

    private static void dfs(int v, int levelV, int parent) {
        level[v] = levelV;
        lca[v][0] = parent;

        for(int child : graph[v]) {
            if(child != parent) {
                dfs(child, levelV + 1, v);
            }
        }
    }

    private static int distance(int a, int b) {
        int levelLCA = level[getLCA(a, b)];
        return level[a] + level[b] - (2 * levelLCA);
    }

    private static int getLCA(int a, int b) {
        if(level[a] > level[b]) {
            return getLCA(b, a);
        }

        int d = level[b] - level[a];
        while (d > 0) {
            int i = (int) ((int) Math.log10(d)/Math.log10(2));
            b = lca[b][i];
            d -= (1 << i);
        }

        while(a != b) {
            a = lca[a][0];
            b = lca[b][0];
        }

        return a;
    }




}
