package LeetCode.dynamivProgramming;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/maximal-square/
 * Difficulty level : Medium
 */
public class problem221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        return maximal(matrix);
    }

    private int maximal(char[][] matrix) {

        int r = matrix.length;
        int col = matrix[0].length;
        int val = 0;
        int[][] dp = new int[r + 1][col + 1];

        for (int i = 1; i <= r; i++) {

            for (int j = 1; j <= col; j++) {
                if ( matrix[i - 1][j - 1] - '0' == 1) {
                    int prevDiag = dp[i - 1][j - 1];
                    int prevCol = dp[i][j - 1];
                    int prevRow = dp[i - 1][j];

                    int sqSide = Math.min(Math.min(prevRow, prevDiag), prevCol);

                    dp[i][j] = 1 + sqSide;

                    val = Math.max(val, dp[i][j]);
                }
            }
        }
        return val * val;
    }
}
