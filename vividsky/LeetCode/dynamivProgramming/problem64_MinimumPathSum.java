package LeetCode.dynamivProgramming;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/minimum-path-sum/
 * Difficulty level : Medium
 */
public class problem64_MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        // return minPath(grid, 0, 0, dp);
        return approachTwo(grid, dp);
    }

    /**
     Iterative DP
     Time  : O(N^2);
     Space : O(N^2)
     */
    private int approachTwo(int[][] grid, int[][] dp) {
        int r = grid.length;
        int c = grid[0].length;

        dp[r - 1][c - 1] = grid[r - 1][c - 1];

        for (int i = r - 2; i >= 0; i--) {
            dp[i][c - 1] = dp[i + 1][c - 1] + grid[i][c - 1];
        }

        for (int i = c - 2; i >= 0; i--) {
            dp[r - 1][i] = dp[r - 1][i + 1] + grid[r - 1][i];
        }

        for (int i = r - 2; i >= 0; i--) {
            for (int j = c - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }

    /**
     Recursive DP
     Time  : O(N^2)
     Space : O(N^2) + recursive stack
     */
    private int minPath(int[][] grid, int r, int c, int[][] dp) {
        if (r >= grid.length || c >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            dp[r][c] = grid[r][c];
        } else {
            dp[r][c] = Math.min(minPath(grid, r + 1, c, dp), minPath(grid, r, c + 1, dp)) + grid[r][c];
        }
        return dp[r][c];
    }
}
