/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : problem: https://www.codechef.com/problems/PRGCUP01
 *          solution: https://www.codechef.com/viewsolution/63193231
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem_ChessKnightMove {

    static int[][] visited;
    static int[][]  dis;
    static int[] dx, dy;

    public static void main(String[] args) throws IOException {

        dx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        dy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {

            String[] se = br.readLine().split(" ");
            int srcX = se[0].charAt(0) - 'a';
            int srcY = se[0].charAt(1) - '1';
            int desX = se[1].charAt(0) - 'a';
            int desY = se[1].charAt(1) - '1';

            visited = new int[8][8];
            dis = new int[8][8];

            bfs(srcX, srcY);

            System.out.println(dis[desX][desY]);
        }
    }

    private static void bfs(int srcX, int srcY) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(srcX, srcY));
        visited[srcX][srcY] = 1;

        while (!queue.isEmpty()) {
            Pair node = queue.remove();
            int x = node.first;
            int y = node.second;

            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (isValid(newX, newY)) {
                    visited[newX][newY] = 1;
                    dis[newX][newY] = dis[x][y] + 1;
                    queue.add(new Pair(newX, newY));
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        if(x < 0 || x >= 8 || y < 0 || y >= 8) {
            return false;
        }

        if(visited[x][y] == 1) {
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
