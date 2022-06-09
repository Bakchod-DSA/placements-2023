/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.codingninjas.com/codestudio/problems/maximum-path-sum-in-the-matrix_797998
 * Difficulty level: Medium
 */

package ExternalSources.DP;

public class Problem_MaximumPathSumInMatrix {
    public static int getMaxPathSum(int[][] matrix) {
		/*
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int maxi = Integer.MIN_VALUE;
        for(int j = 0; j < matrix[0].length; j++) {
            maxi = Math.max(maxi, approachTwo(dp, matrix, matrix.length - 1, j));
        }
        return maxi;
        */

//         return approachThree(matrix);
        return approachFour(matrix);

    }

    private static int approachOne(int[][] matrix, int i, int j) {
        if(j < 0 || j > matrix[0].length - 1) return Integer.MIN_VALUE;
        if(i == 0) return matrix[0][j];

        int up = approachOne(matrix, i - 1, j);
        int diagL = approachOne(matrix, i - 1, j - 1);
        int diagR = approachOne(matrix, i - 1, j + 1);

        return matrix[i][j] + Math.max(up, Math.max(diagL, diagR));
    }

    private static int approachTwo(int[][] dp, int[][] matrix, int i, int j) {
        if(j < 0 || j > matrix[0].length - 1) return Integer.MIN_VALUE;
        if(i == 0) return matrix[0][j];

        if(dp[i][j] != -1) return dp[i][j];
        int up = approachOne(matrix, i - 1, j);
        int diagL = approachTwo(dp, matrix, i - 1, j - 1);
        int diagR = approachTwo(dp, matrix, i - 1, j + 1);

        dp[i][j] = matrix[i][j] + Math.max(up, Math.max(diagL, diagR));
        return dp[i][j];
    }

    private static int approachThree(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j];
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int up = Integer.MIN_VALUE, diagL = Integer.MIN_VALUE, diagR = Integer.MIN_VALUE;
                up = dp[i - 1][j];
                if(j - 1 >= 0) diagL = dp[i - 1][j - 1];
                if(j + 1 < matrix[0].length) diagR = dp[i - 1][j + 1];
                dp[i][j] = matrix[i][j] + Math.max(up, Math.max(diagL, diagR));
            }
        }

        int maxi = Integer.MIN_VALUE;
        for(int j = 0; j < matrix[0].length; j++) {
            maxi = Math.max(maxi, dp[matrix.length - 1][j]);
        }
        return maxi;
    }


    private static int approachFour(int[][] matrix) {

        int[] prev = new int[matrix[0].length];
        for(int j = 0; j < matrix[0].length; j++) {
            prev[j] = matrix[0][j];
        }

        for(int i = 1; i < matrix.length; i++) {
            int[] curr = new int[matrix[0].length];
            for(int j = 0; j < matrix[0].length; j++) {
                int up = Integer.MIN_VALUE, diagL = Integer.MIN_VALUE, diagR = Integer.MIN_VALUE;
                up = prev[j];
                if(j - 1 >= 0) diagL = prev[j - 1];
                if(j + 1 < matrix[0].length) diagR = prev[j + 1];
                curr[j] = matrix[i][j] + Math.max(up, Math.max(diagL, diagR));
            }
            prev = curr;
        }

        int maxi = Integer.MIN_VALUE;
        for(int j = 0; j < matrix[0].length; j++) {
            maxi = Math.max(maxi, prev[j]);
        }
        return maxi;
    }
}

