// https://leetcode.com/problems/jump-game-vi/
package leetcode.DP.Fibonacci;

import java.util.*;

public class Problem1696_JumpGameVI {
    public int maxResult(int[] nums, int k) {
        // return recursion(nums, k, nums.length - 1);

        // int[] dp = new int[nums.length];
        // Arrays.fill(dp, Integer.MIN_VALUE);
        // return topDown(nums, k, nums.length - 1, dp);

        return bottomUp(nums, k);
    }

    private int recursion(int[] nums, int k, int ind) {
        // TLE
        if(ind == 0) return nums[0];

        int maxScore = Integer.MIN_VALUE;
        for(int steps = 1; steps <= k; steps++) {
            if(ind - steps >= 0) {
                maxScore = Math.max(maxScore, nums[ind] + recursion(nums, k, ind - steps));
            }
        }

        return maxScore;
    }

    private int topDown(int[] nums, int k, int ind, int[] dp) {
        // TLE
        if(ind == 0) return nums[0];
        if(dp[ind] != Integer.MIN_VALUE) return dp[ind];

        for(int steps = 1; steps <= k; steps++) {
            if(ind - steps >= 0) {
                dp[ind] = Math.max(dp[ind], nums[ind] + topDown(nums, k, ind - steps, dp));
            }
        }

        return dp[ind];
    }

    private int bottomUp(int[] nums, int k) {
        int n = nums.length;
        Queue<int[]> pq = new PriorityQueue<>(k, (x, y) -> y[1] - x[1]);
        pq.add(new int[] {0, nums[0]});

        int max = nums[0];
        for(int ind = 1; ind < n; ind++) {
            while (pq.peek()[0] < ind - k) {
                pq.poll();
            }

            max = nums[ind] + pq.peek()[1];
            pq.add(new int[] {ind, max});
        }

        return max;
    }
}
