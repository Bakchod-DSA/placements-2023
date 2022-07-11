// https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/

package leetcode.DP;

public class Problem1884_EggDropWith2Eggs {
    public int twoEggDrop(int n) {
        int[][] dp = new int[3][n + 1];
        for(int i = 0; i <= n; i++) {
            dp[0][i] = -1;
            dp[1][i] = -1;
            dp[2][i] = -1;
        }

        return recursion(2, n, dp);
    }

    private int recursion(int e, int f, int[][] dp) {
        if(f == 0 || f == 1) return f;
        if(e == 1) return f;
        if(dp[e][f] != -1) return dp[e][f];

        int min = Integer.MAX_VALUE;
        for(int k = 1; k <= f; k++) {
            int eggBroken = recursion(e - 1, k - 1, dp);
            int eggNotBroken = recursion(e, f - k, dp);

            int temp = 1 + Math.max(eggBroken, eggNotBroken); // due to worst case we take maximum of both the cases.
            min = Math.min(min, temp);
        }

        dp[e][f] = min;
        return min;
    }
}
