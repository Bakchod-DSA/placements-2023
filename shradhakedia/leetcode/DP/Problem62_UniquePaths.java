/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/unique-paths/
 * Difficulty level: Medium
 */
package leetcode.DP;

public class Problem62_UniquePaths {
    public int uniquePaths(int m, int n) {

        /*  Basic recursive Approach take time Complexity of O(mn * mn)
            and Space complexity of O(m + n)
        */

        // int dp[][] = new int[m][n];
        // return approachOne(m - 1, n - 1, dp);
        return approachThree(m, n);
    }

    private int approachOne(int m, int n, int[][] dp) {
        /*  Approach: Recursion + memoization
            Time Complexity: O(m * n)
            Space Complexity: O(m + n + m * n); m + n recursion stack(depth of tree), mn is dp table space.
        */

        if(m == 0 && n == 0) {
            dp[m][n] = 1;
            return dp[m][n];
        }
        if(m < 0 || n < 0) {
            return 0;
        }

        if(dp[m][n] == 0) {
            // topUniquePaths + leftUniquePaths
            dp[m][n] = approachOne(m - 1, n, dp) + approachOne(m, n - 1, dp);
        }

        return dp[m][n];
    }

    private int approachTwo(int m, int n) {
        /*  Approach: Tabulation
            Time Complexity: O(mn)
            Space Complexity: O(mn)
        */
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = 0, left = 0;
                    if(i > 0) up = dp[i - 1][j];
                    if(j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m - 1][n -1];
    }

    private int approachThree(int m, int n) {
        /*  Approach: Tabulation
            Time Complexity: O(mn)
            Space Complexity: O(n)
        */
        int[] prev = new int[n];
        prev[0] = 1;
        for(int i = 0; i < m; i++) {
            int[] temp = new int[n];
            temp[0] = 1;
            for(int j = 0; j < n; j++) {
                int left = 0, up = prev[j];
                if(j > 0) left = temp[j - 1];
                temp[j] = left + up;
            }
            prev = temp;
        }
        return prev[n - 1];
    }
}
