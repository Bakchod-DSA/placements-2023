/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/minimum-path-sum/
 * Difficulty level: Medium
 */
package leetcode.DP;

public class Problem64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        // return approachOne(grid, m - 1, n - 1);

        // int m = grid.length, n = grid[0].length;
        // int[][] dp = new int[m][n];
        // for(int i = 0; i < m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return approachTwo(dp, grid, m - 1, n - 1);

        // return approachThree(grid);
        return approachFour(grid);
    }

    private int approachOne(int[][] grid, int m, int n) {
        /*  Approach: Recursion
            Time Complexity: O(2 ^ mn)
            Space Complexity: O(mn + m - 1 + n - 1), mn for dp array, rest is the no. of paths.
        */

        // positive base case
        if(m == 0 && n == 0) return grid[0][0];
        // negative base case
        if(m < 0 || n < 0) return Integer.MAX_VALUE;

        int up = approachOne(grid, m - 1, n);
        int left = approachOne(grid, m, n - 1);
        return grid[m][n] + Math.min(up, left);
    }

    private int approachTwo(int[][] dp, int[][] grid, int m, int n) {
        /*  Approach: Recursion + Memoization
            Time Complexity: O(mn)
            Space Complexity: O(mn + m - 1 + n - 1), mn for dp array, rest is the no. of paths for recursion stack.
        */

        // positive base case
        if(m == 0 && n == 0) return grid[0][0];
        // negative base case
        if(m < 0 || n < 0) return Integer.MAX_VALUE;

        if(dp[m][n] != -1) return dp[m][n];

        int up = approachOne(grid, m - 1, n);
        int left = approachOne(grid, m, n - 1);
        dp[m][n] = grid[m][n] + Math.min(up, left);
        return dp[m][n];
    }

    private int approachThree(int[][] grid) {
        /*  Approach: Tabulation
            Time Complexity: O(mn)
            Space Complexity: O(mn), mn for dp array
        */

        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else {
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if(i > 0) up = dp[i - 1][j];
                    if(j > 0) left = dp[i][j - 1];
                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    private int approachFour(int[][] grid) {
        /*  Approach: Tabulation
            Time Complexity: O(mn)
            Space Complexity: O(mn), mn for dp array
        */

        int m = grid.length, n = grid[0].length;
        int[] prev = new int[n];

        for(int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) curr[j] = grid[i][j];
                else {
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if(i > 0) up = prev[j];
                    if(j > 0) left = curr[j - 1];
                    curr[j] = grid[i][j] + Math.min(up, left);
                }
            }
            prev = curr;
        }

        return prev[n - 1];
    }
}
