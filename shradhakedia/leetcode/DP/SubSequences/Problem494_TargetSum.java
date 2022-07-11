// https://leetcode.com/problems/target-sum/
package leetcode.DP.SubSequences;

import java.util.Arrays;

public class Problem494_TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int totSum = 0;
        for(int num : nums) totSum += num;

        if(totSum + target < 0 || (totSum + target) % 2 == 1) return 0;
        int n = nums.length;

        // tar can be (totSum - target) / 2 also.
        int tar = (totSum + target) / 2;

        // return recursion(nums, nums.length - 1, tar);


        int[][] dp = new int[n][tar + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return topDown(nums, n - 1, tar, dp);
    }

    private int recursion(int[] nums, int ind, int target) {
        if(ind == 0) {
            if(nums[0] == 0 && target == 0) {
                return 2;
            }
            if(target == 0 || nums[0] == target) {
                return 1;
            }
            return 0;
        }

        int notPick = recursion(nums, ind - 1, target);
        int pick = 0;
        if(target >= nums[ind]) pick = recursion(nums, ind - 1, target - nums[ind]);

        return pick + notPick;
    }

    private int topDown(int[] nums, int ind, int target, int[][] dp) {
        if(ind == 0) {
            if(nums[0] == 0 && target == 0) {
                return 2;
            }
            if(target == 0 || nums[0] == target) {
                return 1;
            }
            return 0;
        }

        if(dp[ind][target] != -1) return dp[ind][target];

        int notPick = topDown(nums, ind - 1, target, dp);
        int pick = 0;
        if(target >= nums[ind]) pick = topDown(nums, ind - 1, target - nums[ind], dp);

        dp[ind][target] = pick + notPick;
        return dp[ind][target];
    }
}
