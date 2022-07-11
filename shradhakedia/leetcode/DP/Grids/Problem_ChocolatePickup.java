// https://www.codingninjas.com/codestudio/problems/ninja-and-his-friends_3125885

package leetcode.DP.Grids;

import java.util.Arrays;

public class Problem_ChocolatePickup {
    static int[] dj;

    public static int maximumChocolates(int r, int c, int[][] grid) {
        dj = new int[] {-1, 0, 1};

        int[][][] dp = new int[r][c][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return topDown(0, 0, c - 1, grid, dp);
    }

    private static int topDown(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        if(j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length) {
            return Integer.MIN_VALUE;
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        if(i == grid.length - 1) {
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        int maxi = 0;
        for(int dj1 = -1; dj1 <= 1; dj1++) {
            for(int dj2 = -1; dj2 <= 1; dj2++) {
                int next = topDown(i + 1, j1 + dj1, j2 + dj2, grid, dp);
                if(j1 == j2) maxi = Math.max(next + grid[i][j1], maxi);
                else maxi = Math.max(next + grid[i][j1] + grid[i][j2], maxi);
            }
        }

        dp[i][j1][j2] = maxi;
        return maxi;
    }
}
