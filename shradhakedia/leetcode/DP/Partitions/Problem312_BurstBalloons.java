// https://leetcode.com/problems/burst-balloons/
package leetcode.DP.Partitions;

public class Problem312_BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;
        for(int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }

        // return recursion(balloons, 1, n);

        Integer[][] dp = new Integer[n + 1][n + 1];
        return topDown(balloons, 1, n, dp);
    }


    private int recursion(int[] balloons, int i, int j) {
        if(i > j) return 0;

        int maxi = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++) {
            int cost = (balloons[i - 1] * balloons[k] * balloons[j + 1]) + recursion(balloons, i, k - 1) + recursion(balloons, k + 1, j);
            maxi = Math.max(maxi, cost);
        }

        return maxi;
    }

    private int topDown(int[] balloons, int i, int j, Integer[][] dp) {
        if(i > j) return 0;
        if(dp[i][j] != null) return dp[i][j];

        dp[i][j] = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++) {
            int cost = (balloons[i - 1] * balloons[k] * balloons[j + 1]) + topDown(balloons, i, k - 1, dp) + topDown(balloons, k + 1, j, dp);
            dp[i][j] = Math.max(dp[i][j], cost);
        }

        return dp[i][j];
    }

    private int bottomUp(int[] balloons) {
        int n = balloons.length;
        int[][] dp = new int[n + 1][n + 1];

        for(int i = n - 2; i >= 1; i--) {
            for(int j = i; j <= n - 2; j++) {
                dp[i][j] = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++) {
                    int cost = (balloons[i - 1] * balloons[k] * balloons[j + 1]) + dp[i][k - 1] + dp[k + 1][j];
                    dp[i][j] = Math.max(dp[i][j], cost);
                }

            }
        }

        return dp[1][n - 2];
    }


}
