/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/jungle-run/
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_JungleRun {

    static String[][] graph;
    static int[][] visited;
    static int[][] dis;
    static int[] dx, dy;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n  = Integer.parseInt(br.readLine());

        graph = new String[n][n];
        visited = new int[n][n];
        dis = new int[n][n];
        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0, -1};

        int srcX = 0, srcY = 0, desX = 0, desY = 0;
        for(int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                graph[i][j] = row[j];
                if(row[j].equals("S")) {
                    srcX = i;
                    srcY = j;
                }
                if(row[j].equals("E")) {
                    desX = i;
                    desY = j;
                }
            }
        }

        bfs(srcX, srcY);

        System.out.println(dis[desX][desY]);
    }

    private static void bfs(int srcX, int srcY) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(srcX, srcY));
        visited[srcX][srcY] = 1;

        while(!queue.isEmpty()) {
            Pair node = queue.remove();
            int x = node.first;
            int y = node.second;

            for(int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(isValid(newX, newY)) {
                    visited[newX][newY] = 1;
                    dis[newX][newY] = dis[x][y] + 1;
                    queue.add(new Pair(newX, newY));
                }
            }
        }

    }

    private static boolean isValid(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }

        if(graph[x][y].equals("T") || visited[x][y] == 1) {
            return false;
        }

        return true;
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
