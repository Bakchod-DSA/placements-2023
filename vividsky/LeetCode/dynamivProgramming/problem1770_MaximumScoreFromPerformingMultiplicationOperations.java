package LeetCode.dynamivProgramming;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
 * Difficulty level : Medium
 */
public class problem1770_MaximumScoreFromPerformingMultiplicationOperations {
    int[][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {

        int m = multipliers.length;
        // Since total computations is never going to exceed m (as these are the only operations we can perform)
        // hence DP table will be of m * m

        // here we are taking m + 1 * m + 1 so that we can use it in iterative approach too
        dp = new int[m + 1][m + 1];

        // return approachOne(nums, multipliers, 0, 0);
        return approachTwo(nums, multipliers);
    }

    /**
     we need to return once we have no multipliers left i.e. that will be our base case

     left = current leftMost element of nums, right = current rightMost elemet of nums

     this is a problem of 0 1 knapsack either to include left or not; if we include it,
     for next recursive call, we will be out of left
     if we are not inclunding it(we are including right) then left will be available in next recursive call too

     Since we want to maximize our score, we should choose the side that gives more points.
     This gives us our recurrence relation:
     dp(i, left) = max(mult * nums[left] + dp(i + 1, left + 1), mult * nums[right] + dp(i + 1, left))

     Where mult * nums[left] + dp(i + 1, left + 1) represents the points we gain by taking from the left end of nums
     plus the maximum points we can get from the remaining nums array and
     mult * nums[right] + dp(i + 1, left) represents the points we gain by taking from the right end of nums
     plus the maximum points we can get from the remaining nums array.
     */
    private int approachOne(int[] nums, int[] multipliers, int mult, int left) {

        if (mult == multipliers.length) {
            return 0;
        }

        int right = nums.length - 1 - (mult - left);
        if (dp[left][mult] == 0) {
            dp[left][mult] =  Math.max(approachOne(nums, multipliers, mult + 1, left + 1) + nums[left]  * multipliers[mult],
                    approachOne(nums, multipliers, mult + 1, left)     + nums[right] * multipliers[mult]) ;
        }

        return dp[left][mult];
    }



    private int approachTwo(int[] nums, int[] multipliers) {

        int n = nums.length;
        int m = multipliers.length;

        /* Since total computations is never going to exceed m (as these are the only operations we can perform)
           hence DP table will be of m * m, but to avoid out of bound of our index, we take it as (m + 1) * (m + 1)
           here (m + 1) * (m + 1) will store our base case same as top down approach
           int[][] dp = new int[m + 1][m + 1];
        */


        for (int i = m - 1; i >= 0; i--) {
            /* At worst we can take all left elements from nums
               here incrementing left means we have taken left element where incrementing i represents we have taken right element
             */

            for (int left = i; left >= 0; left--) {
                int right = n - 1 - (i - left);
                int mult = multipliers[i];
                dp[i][left] = Math.max(dp[i + 1][left + 1] + nums[left] * mult,
                        dp[i + 1][left] + nums[right] * mult);
            }

        }
        return dp[0][0];
    }
}
