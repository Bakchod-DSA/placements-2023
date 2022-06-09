/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/range-sum-query-2d-immutable/
 * Difficulty level: Medium
 */
package leetcode.Array;

public class Problem304_RangeSumQuery2D_Immutable {
    class NumMatrix {

        int[][] dp;
        public NumMatrix(int[][] matrix) {

            int m = matrix.length;
            int n = matrix[0].length;
            if(m == 0 || n == 0) return;

            dp = new int[m + 1][n + 1];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    dp[i + 1][j + 1] = matrix[i][j] + dp[i + 1][j] + dp[i][j + 1] - dp[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
        }
    }

}
