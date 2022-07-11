// https://leetcode.com/problems/best-team-with-no-conflicts/
package leetcode.DP.LIS;

import java.util.Arrays;

public class Problem1626_BestTeamWithNoConflicts {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] combined = new int[n][2];
        for(int i = 0; i < n; i++) {
            combined[i][0] = ages[i];
            combined[i][1] = scores[i];
        }
        Arrays.sort(combined, (a, b) -> (a[0] != b[0])? a[0] - b[0] : a[1] - b[1]);

        // return recursion(combined, 0, -1);

        int[][] dp = new int[n][n + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return topDown(combined, 0, -1, dp);
    }

    private int recursion(int[][] combined , int ind, int prev) {
        if(ind == combined.length) return 0;

        int notPick = recursion(combined, ind + 1, prev);
        int pick = Integer.MIN_VALUE;
        if(prev == -1 || combined[ind][0] == combined[prev][0] || combined[ind][1] >= combined[prev][1]) {
            pick = combined[ind][1] + recursion(combined, ind + 1, ind);
        }

        return Math.max(notPick, pick);
    }

    private int topDown(int[][] combined , int ind, int prev, int[][] dp) {
        if(ind == combined.length) return 0;
        if(dp[ind][prev + 1] != -1) return dp[ind][prev + 1];

        int notPick = topDown(combined, ind + 1, prev, dp);
        int pick = Integer.MIN_VALUE;
        if(prev == -1 || combined[ind][0] == combined[prev][0] || combined[ind][1] >= combined[prev][1]) {
            pick = combined[ind][1] + topDown(combined, ind + 1, ind, dp);
        }

        dp[ind][prev + 1] = Math.max(notPick, pick);
        return dp[ind][prev + 1];
    }
}
