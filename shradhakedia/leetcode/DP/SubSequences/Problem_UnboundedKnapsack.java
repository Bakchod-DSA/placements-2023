// https://www.codingninjas.com/codestudio/problems/unbounded-knapsack_1215029
package leetcode.DP.SubSequences;

public class Problem_UnboundedKnapsack {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
//         return recursion(weight, profit, n - 1, w);

//         int[][] dp = new int[n][w + 1];
//         for(int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return topDown(weight, profit, n - 1, w, dp);

        return bottomUp(n, weight, profit, w);
    }

    private static int recursion(int[] wt, int[] profit, int ind, int W) {
        if(ind == 0) {
            if(W >= wt[0]) return (W / wt[0]) * profit[0];
            else return 0;
        }

        int notPick = recursion(wt, profit, ind - 1, W);
        int pick = Integer.MIN_VALUE;
        if(W >= wt[ind]) pick = profit[ind] + recursion(wt, profit, ind, W - wt[ind]);

        return Math.max(pick, notPick);
    }

    private static int topDown(int[] wt, int[] profit, int ind, int W, int[][] dp) {
        if(ind == 0) {
            if(W >= wt[0]) return (W / wt[0]) * profit[0];
            else return 0;
        }
        if(dp[ind][W] != -1) return dp[ind][W];

        int notPick = topDown(wt, profit, ind - 1, W, dp);
        int pick = Integer.MIN_VALUE;
        if(W >= wt[ind]) pick = profit[ind] + topDown(wt, profit, ind, W - wt[ind], dp);

        dp[ind][W] = Math.max(pick, notPick);
        return dp[ind][W];
    }

    private static int bottomUp(int n, int[] wt, int[] profit, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];

        for(int W =  wt[0]; W <= maxWeight; W++) {
            dp[0][W] = (W / wt[0]) * profit[0];
        }

        for(int ind = 1; ind < n; ind++) {
            for(int W = 0; W <= maxWeight; W++) {
                int notPick = dp[ind - 1][W];
                int pick = Integer.MIN_VALUE;
                if(W >= wt[ind]) pick = profit[ind] + dp[ind][W - wt[ind]];

                dp[ind][W] = Math.max(pick, notPick);
            }
        }

        return dp[n - 1][maxWeight];
    }
}
