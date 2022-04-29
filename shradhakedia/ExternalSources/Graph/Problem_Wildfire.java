/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://binarysearch.com/problems/Wildfire
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.util.*;

public class Problem_Wildfire {

    int ans = 0;
    int[][] visited;
    int[] dx, dy;
    Queue<Pair> queue;

    public int solve(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;

        int n = matrix[0].length;
        visited = new int[m][n];
        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0, -1};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = -1;
            }
        }

        queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 2) {
                    visited[i][j] = 0;
                    queue.add(new Pair(i, j));
                }
            }
        }
        bfs(matrix);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == -1 && matrix[i][j] == 1) {
                    return -1;
                }
                ans = Math.max(ans, visited[i][j]);
            }
        }

        return ans;
    }

    private void bfs(int[][] matrix) {

        while(!queue.isEmpty()) {
            Pair node = queue.remove();
            int x = node.first;
            int y = node.second;
            int day = visited[x][y];

            for(int j = 0; j < 4; j++) {
                int newX = x + dx[j];
                int newY = y + dy[j];
                if(isValid(newX, newY, matrix)) {
                    visited[newX][newY] = day + 1;
                    queue.add(new Pair(newX, newY));
                }
            }
        }
    }

    private boolean isValid(int x, int y, int[][] matrix) {
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
            return false;
        }

        if(visited[x][y] != -1 || matrix[x][y] == 0 || matrix[x][y] == 2) {
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
