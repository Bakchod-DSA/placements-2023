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
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // return approachOne(nums, dp, n - 1);
        // return approachTwo(nums);
        return approachThree(nums);
    }

    private int approachOne(int[] nums, int[] dp, int n) {
        /*  Approach: Recursion + memoization (top down)
            Time Complexity: O(n)
            Space Complexity: O(2n)
        */
        if(n == 0) return nums[0];
        if(n == 1) return Math.max(nums[0], nums[1]);
        if(dp[n - 1] == -1) dp[n - 1] = approachOne(nums, dp, n - 1);
        if(dp[n - 2] == -1) dp[n - 2] = approachOne(nums, dp, n - 2);
        dp[n] = Math.max(dp[n - 1], dp[n - 2] + nums[n]);
        return dp[n];
    }

    private int approachTwo(int[] nums) {
        /*  Approach: tabulation (bottom up)
            Time Complexity: O(n)
            Space Complexity: O(n)
        */
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    private int approachThree(int[] nums) {
        /*  Approach: tabulation (bottom up), optimized in space
            Time Complexity: O(n)
            Space Complexity: O(1)
        */
        int n = nums.length;
        if(n == 1) return nums[0];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
