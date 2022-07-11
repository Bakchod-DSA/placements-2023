// https://www.codingninjas.com/codestudio/problems/0-1-knapsack_920542
package leetcode.DP.SubSequences;

import java.util.Arrays;

public class Problem_01Knapsack {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        // return recursion(weight, value, n - 1, maxWeight);

        int[][] dp = new int[n][maxWeight + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

//         return topDown(weight, value, n - 1, maxWeight, dp);
        return bottomUp(weight, value, n, maxWeight);
    }

    static int recursion(int[] wt, int[] val, int ind, int W) {
        if(ind == 0) {
            if(wt[0] <= W) return val[0];
            else return 0;
        }

        int notPick = recursion(wt, val, ind - 1, W);
        int pick = 0;
        if(W >= wt[ind]) {
            pick = val[ind] + recursion(wt, val, ind - 1, W - wt[ind]);
        }

        return Math.max(notPick, pick);
    }

    static int topDown(int[] wt, int[] val, int ind, int W, int[][] dp) {
        if(ind == 0) {
            if(wt[0] <= W) return val[0];
            else return 0;
        }
        if(dp[ind][W] != -1) return dp[ind][W];

        int notPick = topDown(wt, val, ind - 1, W, dp);
        int pick = 0;
        if(W >= wt[ind]) {
            pick = val[ind] + topDown(wt, val, ind - 1, W - wt[ind], dp);
        }

        dp[ind][W] = Math.max(notPick, pick);
        return dp[ind][W];
    }

    static int bottomUp(int[] wt, int[] val, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];

        for(int W = wt[0]; W <= maxWeight; W++) {
            dp[0][W] = val[0];
        }

        for(int ind = 1; ind < n; ind++) {
            for(int W = 0; W <= maxWeight; W++) {
                int notPick = dp[ind - 1][W];
                int pick = 0;
                if(W >= wt[ind]) pick = val[ind] + dp[ind - 1][W - wt[ind]];
                dp[ind][W] = Math.max(pick, notPick);
            }
        }

        return dp[n - 1][maxWeight];
    }
}
