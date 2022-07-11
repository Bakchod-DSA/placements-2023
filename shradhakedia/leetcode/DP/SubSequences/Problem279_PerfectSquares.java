// https://leetcode.com/problems/perfect-squares/

package leetcode.DP.SubSequences;

import java.util.*;

public class Problem279_PerfectSquares {
    public int numSquares(int n) {
        // unbounded knapsack
        List<Integer> sq = new ArrayList<>();
        int i = 1;
        while(i * i <= n) {
            sq.add(i * i);
            i++;
        }

        return unboundedKnapsack(sq, n);
    }

    private int unboundedKnapsack(List<Integer> wt, int W) {
        // return recursion(wt, wt.size() - 1, W);

        int n = wt.size();
        int[][] dp = new int[n][W + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return topDown(wt, n - 1, W, dp);
    }

    private int recursion(List<Integer> wt, int ind, int W) {
        if(ind == 0) {
            if(W >= wt.get(0)) return W / wt.get(0);
            else return 0;
        }

        int notPick = recursion(wt, ind - 1, W);
        int pick = Integer.MAX_VALUE;
        if(wt.get(ind) <= W) pick = 1 + recursion(wt, ind, W - wt.get(ind));

        return Math.min(pick, notPick);
    }

    private int topDown(List<Integer> wt, int ind, int W, int[][] dp) {
        if(ind == 0) {
            if(W >= wt.get(0)) return W / wt.get(0);
            else return 0;
        }
        if(dp[ind][W] != -1) return dp[ind][W];

        int notPick = topDown(wt, ind - 1, W, dp);
        int pick = Integer.MAX_VALUE;
        if(wt.get(ind) <= W) pick = 1 + topDown(wt, ind, W - wt.get(ind), dp);

        dp[ind][W] = Math.min(pick, notPick);
        return dp[ind][W];
    }
}
