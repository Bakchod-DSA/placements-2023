/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/house-robber/
 * Difficulty level: Medium
 */

package leetcode.DP;

import java.util.Arrays;

public class Problem198_HouseRobber {

    public int rob(int[] nums) {

        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        // return approachOne(nums, memo, nums.length - 1);
        return approachTwo(nums);
    }

    private int approachOne(int[] nums, int[] memo, int n) {
        /*  Approach: DP (Memoization) Top Down
            Time Complexity:  O(n)
            Space Complexity: O(n)
        */

        // Base cases
        if(n == 0) {
            return nums[0];
        }
        if(n == 1) {
            return Math.max(nums[0], nums[1]);
        }

        if(memo[n] == -1) {
            memo[n] = Math.max(approachOne(nums, memo, n - 1), approachOne(nums, memo, n - 2) + nums[n]); // recurrence relation
        }

        return memo[n];
    }


    private int approachTwo(int[] nums) {
        /*  Approach: DP (Tabulation) Bottom up
            Time Complexity:  O(n)
            Space Complexity: O(n)
        */

        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]); // recurrence relation
        }

        return dp[n - 1];

    }

}
