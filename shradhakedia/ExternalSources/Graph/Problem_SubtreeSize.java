package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class Problem_SubtreeSize {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer>[] adjacencyList = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

        for (int i = 1; i < n; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);

            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        int[] visited = new int[n + 1];
        int[] treeSize = new int[n + 1];
        dfs(1, treeSize, visited, adjacencyList);

        System.out.println(Arrays.toString(Arrays.copyOfRange(treeSize, 1, treeSize.length)));
    }

    private static int dfs(int v, int[] treeSize, int[] visited, LinkedList<Integer>[] adjacencyList) {
        visited[v] = 1;

        int size = 0;
        for (int child : adjacencyList[v]) {
            if(visited[child] == 0) {
                size += dfs(child, treeSize, visited, adjacencyList);
            }
        }

        treeSize[v] = size + 1;
        return size + 1;
    }
}
