/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://cses.fi/problemset/task/1192/
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_CountingRooms {

    static int[] dx, dy;
    static int[][] visited;
    static int[][] graph;
    static int m, n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0, -1};
        graph = new int[n][m];
        visited = new int[n][m];
        for(int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                if(row.charAt(j) == '.') graph[i][j] = 1;
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);
    }


    private static void dfs(int x, int y) {
        visited[x][y] = 1;

        for(int i = 0; i < 4; i++) {
            if(isValid(x + dx[i], y + dy[i])) {
                dfs(x + dx[i], y + dy[i]);
            }
        }

    }

    private static boolean isValid(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }

        if(visited[x][y] == 1 || graph[x][y] == 0) {
            return false;
        }
        return true;
    }

}
