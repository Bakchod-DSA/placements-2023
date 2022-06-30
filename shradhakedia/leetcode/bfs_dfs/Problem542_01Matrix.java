/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/01-matrix/
 * Difficulty level: Medium
 */
package leetcode.bfs_dfs;

import java.util.*;

public class Problem542_01Matrix {
    int[][] dist;
    boolean[][] visited;
    int[] dx, dy;

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        dx = new int[] {-1, 1, 0, 0};
        dy = new int[] {0, 0, -1, 1};
        dist = new int[m][n];
        visited = new boolean[m][n];

        Queue<Cell> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0 && !visited[i][j]) {
                    queue.add(new Cell(i, j));
                }
                if(mat[i][j] == 1) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        bfs(mat, queue);
        return dist;
    }

    private void bfs(int[][] mat, Queue<Cell> queue) {
        while(!queue.isEmpty()) {
            Cell cell = queue.remove();
            int x = cell.x;
            int y = cell.y;
            visited[x][y] = true;

            for(int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(isValid(newX, newY, mat)) {
                    dist[newX][newY] = Math.min(dist[newX][newY], 1 + dist[x][y]);
                    queue.add(new Cell(newX, newY));
                }
            }
        }
    }

    private boolean isValid(int x, int y, int[][] mat) {
        if(x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[x][y] == 0 || visited[x][y]) return false;
        return true;
    }

    class Cell {
        int x, y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
