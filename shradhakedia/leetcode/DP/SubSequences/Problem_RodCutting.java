// https://www.codingninjas.com/codestudio/problems/rod-cutting-problem_800284

package leetcode.DP.SubSequences;

public class Problem_RodCutting {
    public static int cutRod(int price[], int n) {
// 		return recursion(price, n - 1, n);

//         int[][] dp = new int[n][n + 1];
//         for(int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -1);
//         }
//         return topDown(price, n - 1, n, dp);

        return bottomUp(price, n);
    }

    private static int recursion(int[] price, int ind, int W) {
        if(ind == 0) {
            if(W >= ind + 1) return (W / (ind + 1)) * price[0];
            else return 0;
        }

        int notPick = recursion(price, ind - 1, W);
        int pick = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if(W >= rodLength) pick = price[ind] + recursion(price, ind, W - rodLength);

        return Math.max(pick, notPick);
    }

    private static int topDown(int[] price, int ind, int W, int[][] dp) {
        if(ind == 0) {
            if(W >= ind + 1) return (W / (ind + 1)) * price[0];
            else return 0;
        }
        if(dp[ind][W] != -1) return dp[ind][W];

        int notPick = topDown(price, ind - 1, W, dp);
        int pick = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if(W >= rodLength) pick = price[ind] + recursion(price, ind, W - rodLength);

        dp[ind][W] = Math.max(pick, notPick);
        return dp[ind][W];
    }

    private static int bottomUp(int[] price, int n) {
        int[][] dp = new int[n][n + 1];
        for(int W = 1; W <= n; W++) {
            dp[0][W] = W * price[0];
        }

        for(int ind = 1; ind < n; ind++) {
            for(int W = 0; W <= n; W++) {
                int notPick = dp[ind - 1][W];
                int pick = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if(W >= rodLength) pick = price[ind] + dp[ind][W - rodLength];

                dp[ind][W] = Math.max(pick, notPick);
            }
        }

        return dp[n - 1][n];
    }
}
