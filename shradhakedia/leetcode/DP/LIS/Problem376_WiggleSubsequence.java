// https://leetcode.com/problems/wiggle-subsequence/
package leetcode.DP.LIS;

import java.util.Arrays;

public class Problem376_WiggleSubsequence {
    private static final int INCREASING = 0;
    private static final int DECREASING = 1;
    private static final int NOT_DECIDED = 2;

    public int wiggleMaxLength(int[] nums) {
        // return recursion(nums, 0, -1, NOT_DECIDED);

        int n = nums.length;
        int[][][] dp = new int[n][n + 1][3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return topDown(nums, 0, -1, NOT_DECIDED, dp);
    }


    private int recursion(int[] nums, int ind, int prev, int flag) {
        if(ind == nums.length) return 0;

        int notPick = recursion(nums, ind + 1, prev, flag);
        int pick = Integer.MIN_VALUE;
        if(prev == -1) {
            pick = 1 + Math.max(recursion(nums, ind + 1, ind, DECREASING), recursion(nums, ind + 1, ind, INCREASING));
        } else if(nums[ind] > nums[prev] && flag == INCREASING) {
            pick = 1 + recursion(nums, ind + 1, ind, DECREASING);
        } else if(nums[ind] < nums[prev] && flag == DECREASING) {
            pick = 1 + recursion(nums, ind + 1, ind, INCREASING);
        }

        return Math.max(pick, notPick);
    }

    private int topDown(int[] nums, int ind, int prev, int flag, int[][][] dp) {

        if(ind == nums.length) return 0;
        if(dp[ind][prev + 1][flag] != -1) return dp[ind][prev + 1][flag];

        int notPick = topDown(nums, ind + 1, prev, flag, dp);
        int pick = Integer.MIN_VALUE;
        if(prev == -1) {
            pick = 1 + Math.max(topDown(nums, ind + 1, ind, DECREASING, dp), topDown(nums, ind + 1, ind, INCREASING, dp));
        } else if(nums[ind] > nums[prev] && flag == INCREASING) {
            pick = 1 + topDown(nums, ind + 1, ind, DECREASING, dp);
        } else if(nums[ind] < nums[prev] && flag == DECREASING) {
            pick = 1 + topDown(nums, ind + 1, ind, INCREASING, dp);
        }


        dp[ind][prev + 1][flag] = Math.max(pick, notPick);
        return dp[ind][prev + 1][flag];
    }
}
