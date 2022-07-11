// https://www.codingninjas.com/codestudio/problems/frog-jump_3621012

package leetcode.DP.Fibonacci;

import java.util.Arrays;

public class Problem_FrogJump {
    static int[] dp;

    public static int frogJump(int n, int heights[]) {
        dp = new int[n];
        Arrays.fill(dp, -1);

        return recursion(n - 1, heights);
    }

    private static int recursion(int n, int heights[]) {
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];

        int oneStepBack = recursion(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);

        int twoStepBack = Integer.MAX_VALUE;
        if(n > 1) twoStepBack = recursion(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);

        dp[n] = Math.min(oneStepBack, twoStepBack);
        return dp[n];
    }
}
