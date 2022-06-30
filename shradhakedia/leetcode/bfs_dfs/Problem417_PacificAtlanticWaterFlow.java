/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/pacific-atlantic-water-flow/
 * Difficulty level: Medium
 */
package leetcode.bfs_dfs;

import java.util.*;

public class Problem417_PacificAtlanticWaterFlow {
    int[] dx, dy;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        dx = new int[] {-1, 1, 0, 0};
        dy = new int[] {0, 0, -1, 1};

        for(int i = 0; i < m; i++) {
            // vertical
            dfs(i, 0, pacific, heights);
            dfs(i, n - 1, atlantic, heights);
        }

        for(int i = 0; i < n; i++) {
            // horizontal
            dfs(0, i, pacific, heights);
            dfs(m - 1, i, atlantic, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return res;
    }

    private void dfs(int x, int y, boolean[][] visited, int[][] heights) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isValid(nx, ny, visited, heights) && heights[nx][ny] >= heights[x][y]) {
                dfs(nx, ny, visited, heights);
            }
        }
    }

    private boolean isValid(int x, int y, boolean[][] visited, int[][] heights) {
        if(x < 0 || x >= heights.length || y < 0 || y >= heights[0].length || visited[x][y]) return false;
        return true;
    }
}
