/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/path-with-minimum-effort/
 * Difficulty level: Medium
 */
package leetcode.bfs_dfs;

import java.util.*;

public class Problem1631_PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};

        int[][] dis = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(0, 0));
        dis[0][0] = 0;

        while(!queue.isEmpty()) {
            Cell cell = queue.remove();
            int x = cell.x;
            int y = cell.y;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(isValid(nx, ny, heights) && dis[nx][ny] > dis[x][y]) {
                    dis[nx][ny] = Math.min(dis[nx][ny], Math.max(dis[x][y], Math.abs(heights[nx][ny] - heights[x][y])));
                    queue.add(new Cell(nx, ny));
                }
            }
        }

        return dis[m - 1][n - 1];
    }

    private boolean isValid(int x, int y, int[][] heights) {
        if(x < 0 || x >= heights.length || y < 0 || y >= heights[0].length) return false;
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
