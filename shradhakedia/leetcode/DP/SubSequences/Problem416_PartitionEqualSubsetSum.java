/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/partition-equal-subset-sum/
 * Difficulty level: Medium
 */
package leetcode.DP.SubSequences;

import java.util.Arrays;

public class Problem416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        // return ((sum & 1) == 1)? false : approachOne(nums, nums.length - 1, sum >> 1);

        if((sum & 1) == 1) {
            return false;
        }

        int n = nums.length;
        int[][] dp = new int[n][sum/2 + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return approachTwo(dp, nums, n - 1, sum/2);
    }

    private boolean approachOne(int[] nums, int n, int k) {
        // recursion
        if(k == 0) return true;
        if(n == 0) return (nums[0] == k);

        boolean notTake = approachOne(nums, n - 1, k);
        boolean take = false;
        if(k >= nums[n]) take = approachOne(nums, n - 1, k - nums[n]);

        return take | notTake;
    }

    private boolean approachTwo(int[][] dp, int[] nums, int n, int k) {
        // recursion + memoization
        if(k == 0) return true;
        if(n == 0) return (nums[0] == k);

        if(dp[n][k] != -1) return dp[n][k] == 1;

        boolean notTake = approachTwo(dp, nums, n - 1, k);
        boolean take = false;
        if(k >= nums[n]) take = approachTwo(dp, nums, n - 1, k - nums[n]);

        boolean result = take | notTake;
        dp[n][k] = (result)? 1 : 0;
        return result;
    }
}
