// https://www.codingninjas.com/codestudio/problems/matrix-chain-multiplication_975344
package leetcode.DP.Partitions;

public class Problem_MatrixChainMultiplication {
    public static int matrixMultiplication(int[] arr , int N) {
// 		return recursion(arr, 1, N - 1);

//         Integer[][] dp = new Integer[N][N];
//         return topDown(arr, 1, N - 1, dp);

        return bottomUp(arr);
    }

    private static int recursion(int[] arr, int i, int j) {
        if(i == j) return 0;

        int mini = Integer.MAX_VALUE;
        for(int k = i; k <= j - 1; k++) {
            int steps = (arr[i - 1] * arr[k] * arr[j]) + recursion(arr, i, k) + recursion(arr, k + 1, j);
            mini = Math.min(mini, steps);
        }

        return mini;
    }

    private static int topDown(int[] arr, int i, int j, Integer[][] dp) {
        // T.C.: O(n ^ 3), S.C.: O(n ^ 2) + O(n)
        if(i == j) return 0;
        if(dp[i][j] != null) return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;
        for(int k = i; k <= j - 1; k++) {
            int steps = (arr[i - 1] * arr[k] * arr[j]) + topDown(arr, i, k, dp) + topDown(arr, k + 1, j, dp);
            dp[i][j] = Math.min(dp[i][j], steps);
        }

        return dp[i][j];
    }

    private static int bottomUp(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for(int i = n - 1; i >= 1; i--) {
            for(int j = i + 1; j < n; j++) {
                // j loops from i + 1 because j is always on the right of i.
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k <= j - 1; k++) {
                    int steps = (arr[i - 1] * arr[k] * arr[j]) + dp[i][k] + dp[k + 1][j];
                    dp[i][j] = Math.min(dp[i][j], steps);
                }
            }
        }

        return dp[1][n - 1];
    }
}
