// https://leetcode.com/problems/count-square-submatrices-with-all-ones/
package leetcode.DP.Squares;

public class Problem1277_CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        int sum = 0;
        for(int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
            sum += dp[i][0];
        }
        for(int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
            sum += dp[0][j];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                // we choose min because we need to be sure that min of all will result in total number of square.
                int val = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);

                if(matrix[i][j] == 1) dp[i][j] = 1 + val;
                else dp[i][j] = 0;

                sum += dp[i][j];
            }
        }

        return sum - dp[0][0];  // since, dp[0][0] is counted twice in base case.
    }
}
