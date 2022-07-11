// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
package leetcode.DP.Partitions;

import java.util.Arrays;

public class Problem1547_MinimumCostToCutAStick {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        int[] cuts1 = new int[cuts.length + 2];
        cuts1[0] = 0;
        cuts1[cuts1.length - 1] = n;
        for(int i = 0; i < cuts.length; i++) {
            cuts1[i + 1] = cuts[i];
        }

        // return recursion(cuts1, 1, cuts.length);

        // Integer[][] dp = new Integer[cuts1.length][cuts1.length];
        // return topDown(cuts1, 1, cuts.length, dp);

        return bottomUp(cuts1);
    }

    private int recursion(int[] cuts1, int i, int j) {
        if(i > j) return 0;

        int mini = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++) {
            int cost = (cuts1[j + 1] - cuts1[i - 1]) + recursion(cuts1, i, k - 1) + recursion(cuts1, k + 1, j);
            mini = Math.min(mini, cost);
        }

        return mini;
    }

    private int topDown(int[] cuts1, int i, int j, Integer[][] dp) {
        if(i > j) return 0;
        if(dp[i][j] != null) return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++) {
            int cost = (cuts1[j + 1] - cuts1[i - 1]) + topDown(cuts1, i, k - 1, dp) + topDown(cuts1, k + 1, j, dp);
            dp[i][j] = Math.min(dp[i][j], cost);
        }

        return dp[i][j];
    }

    private int bottomUp(int[] cuts1) {
        int n = cuts1.length;
        int[][] dp = new int[n][n];

        for(int i = n - 2; i >= 1; i--) {
            for(int j = i; j <= n - 2; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++) {
                    int cost = (cuts1[j + 1] - cuts1[i - 1]) + dp[i][k - 1] + dp[k + 1][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }

            }
        }


        return dp[1][n - 2];
    }
}
