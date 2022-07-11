// https://leetcode.com/problems/super-egg-drop/

package leetcode.DP;

import java.util.Arrays;

public class Problem887_SuperEggDrop {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for(int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], -1);
        }

        return topDownBS(k, n, dp);
    }

    private int topDown(int e, int f, int[][] dp) {
        if(f == 0 || f == 1) return f;
        if(e == 1) return f;
        if(dp[e][f] != -1) return dp[e][f];

        int min = Integer.MAX_VALUE;
        for(int k = 1; k <= f; k++) {
            int eggBroken = topDown(e - 1, k - 1, dp);
            int eggNotBroken = topDown(e, f - k, dp);

            // System.out.println(eggBroken + " " + eggNotBroken);
            int temp = 1 + Math.max(eggBroken, eggNotBroken); // due to worst case we take maximum of both the cases.
            min = Math.min(min, temp);
        }

        dp[e][f] = min;
        return min;
    }

    private int topDownBS(int e, int f, int[][] dp) {
        if(f == 0 || f == 1) return f;
        if(e == 1) return f;
        if(dp[e][f] != -1) return dp[e][f];

        int min = Integer.MAX_VALUE, low = 1, high = f;
        while(low <= high) {
            int mid = low + (high - low)/2;
            int eggBroken = topDownBS(e - 1, mid - 1, dp);
            int eggNotBroken = topDownBS(e, f - mid, dp);

            int temp = 1 + Math.max(eggBroken, eggNotBroken); // due to worst case we take maximum of both the cases.

            if(eggBroken < eggNotBroken) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            min = Math.min(min, temp);
        }

        dp[e][f] = min;
        return min;
    }
}
