/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/unique-paths-ii/
 * Difficulty level: Medium
 */
package leetcode.DP.Grids;

public class Problem63_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // for(int i = 0; i < obstacleGrid.length; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return approachTwo(dp, obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);

        // return approachOne(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);

        // return approachThree(obstacleGrid);

        return approachFour(obstacleGrid);
    }

    private int approachOne(int[][] obstacleGrid, int m, int n) {
        /*  Approach: Recursion
            Time Complexity: O(2 ^ mn)
            Space Complexity: O(mn + m - 1 + n - 1), mn for dp array, rest is the no. of paths.
        */
        if(m < 0 || n < 0 || obstacleGrid[m][n] == 1) {
            return 0;
        }
        if(m == 0 && n == 0) {
            return 1;
        }
        return approachOne(obstacleGrid, m - 1, n) + approachOne(obstacleGrid, m, n - 1);
    }

    private int approachTwo(int[][] dp, int[][] obstacleGrid, int m, int n) {
        /*  Approach: Recursion + Memoization
            Time Complexity: O(mn)
            Space Complexity: O(mn + m - 1 + n - 1), mn for dp array, rest is the no. of paths for recursion stack.
        */
        if(m < 0 || n < 0 || obstacleGrid[m][n] == 1) {
            return 0;
        }
        if(m == 0 && n == 0) {
            return 1;
        }
        if(dp[m][n] != -1) return dp[m][n];
        dp[m][n] = approachTwo(dp, obstacleGrid, m - 1, n) + approachTwo(dp, obstacleGrid, m, n - 1);
        return dp[m][n];
    }

    private int approachThree(int[][] obstacleGrid) {
        /*  Approach: Tabulation
            Time Complexity: O(mn)
            Space Complexity: O(mn), mn for dp array
        */

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = 0, left = 0;
                    if(i > 0 && obstacleGrid[i - 1][j] != 1) up = dp[i -1][j];
                    if(j > 0 && obstacleGrid[i][j - 1] != 1) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    private int approachFour(int[][] obstacleGrid) {
        /*  Approach: Tabulation
            Time Complexity: O(mn)
            Space Complexity: O(n), n for dp array
        */
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        int[] prev = new int[n];
        for(int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1) temp[j] = 0;
                else if(i == 0 && j == 0) temp[j] = 1;
                else {
                    int up = prev[j], left = 0;
                    if(j > 0) left = temp[j - 1];
                    temp[j] = up + left;
                }
            }
            prev = temp;
        }

        return prev[n - 1];
    }
}
