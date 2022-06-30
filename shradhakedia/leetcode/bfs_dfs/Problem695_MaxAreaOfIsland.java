/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/max-area-of-island/
 * Difficulty level: Medium
 */
package leetcode.bfs_dfs;

public class Problem695_MaxAreaOfIsland {
    int[] dx;
    int[] dy;
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        dx = new int[] {-1, 1, 0, 0};
        dy = new int[] {0, 0, -1, 1};
        visited = new boolean[m][n];

        int maxArea = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(isValid(i, j, grid)) {
                    int area = dfs(i, j, grid);
                    maxArea = Math.max(maxArea, area + 1);
                }
            }
        }

        return maxArea;

    }

    private int dfs(int x, int y, int[][] grid) {
        int size = 0;

        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(isValid(newX, newY, grid)) {
                size += 1 + dfs(newX, newY, grid);
            }
        }

        return size;
    }

    private boolean isValid(int x, int y, int[][] grid) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || visited[x][y]) return false;
        return true;
    }
}
