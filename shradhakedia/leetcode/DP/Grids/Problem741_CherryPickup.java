// https://leetcode.com/problems/cherry-pickup/

package leetcode.DP.Grids;

import java.util.Arrays;

public class Problem741_CherryPickup {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][][] dp = new int[n][n][n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        return Math.max(0, topDown(0, 0, 0, 0, n, grid, dp));
    }

    private int topDown(int i1, int j1, int i2, int j2, int n, int[][] grid, int[][][][] dp) {
        // we start both person from (0, 0) to (n - 1, n - 1) and move them simultaneously.
        // paths -> |
        //          V
        if(i1 >= n || i2 >= n || j1 >= n || j2 >= n) {
            return Integer.MIN_VALUE;
        }

        if(dp[i1][i2][j1][j2] != -1) return dp[i1][i2][j1][j2];

        if(grid[i1][j1] == -1 || grid[i2][j2] == -1) {
            return Integer.MIN_VALUE;
        }

        if(i1 == n - 1 && j1 == n - 1) {
            return grid[i1][j1];
        }

        if(i2 == n - 1 && j2 == n - 1) {
            return grid[i2][j2];
        }

        int cherries;
        if(i1 == i2 && j1 == j2) {
            cherries = grid[i1][j1];
        } else {
            cherries = grid[i1][j1] + grid[i2][j2];
        }

        cherries += Math.max(Math.max(topDown(i1 + 1, j1, i2 + 1, j2, n, grid, dp), topDown(i1 + 1, j1, i2, j2 + 1, n, grid, dp)),
                Math.max(topDown(i1, j1 + 1, i2 + 1, j2, n, grid, dp), topDown(i1, j1 + 1, i2, j2 + 1, n, grid, dp)));

        dp[i1][i2][j1][j2] = cherries;
        return cherries;

    }
}
