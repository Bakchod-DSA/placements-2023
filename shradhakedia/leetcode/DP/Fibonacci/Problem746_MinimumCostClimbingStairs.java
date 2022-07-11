/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/min-cost-climbing-stairs/
 * Difficulty level: Medium
 */

package leetcode.DP.Fibonacci;

import java.util.*;

public class Problem746_MinimumCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        // HashMap<Integer, Integer> memo = new HashMap<>();

        // return approachOne(cost, memo, cost.length);
        // return approachTwo(cost);
        return approachThree(cost);
    }

    private int approachOne(int[] cost, HashMap<Integer, Integer> memo, int n) {
        /*  Approach: DP (recursion + memoization) Top Down
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        if(n <= 1) {
            return 0;
        }
        if(n == 2) {
            return Math.min(cost[0], cost[1]);
        }

        if(!memo.containsKey(n)) {
            int minCost = Math.min(approachOne(cost, memo, n - 1) + cost[n - 1], approachOne(cost, memo, n - 2) + cost[n - 2]);
            memo.put(n, minCost);
        }

        return memo.get(n);
    }

    private int approachTwo(int[] cost) {
        /*  Approach: DP (tabulation) Bottom Up
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        int n = cost.length;

        if(n == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[n + 1];
        dp[2] = Math.min(cost[0], cost[1]);
        for(int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);

        }

        return dp[n];
    }

    private int approachThree(int[] cost) {
        /*  Approach: DP (tabulation) Bottom Up
            Time Complexity: O(n)
            Space Complexity: O(1)
        */

        int n = cost.length;

        if(n == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int one = 0;
        int two = Math.min(cost[0], cost[1]);
        for(int i = 3; i <= n; i++) {
            int minCost = Math.min(one + cost[i - 2], two + cost[i - 1]);
            one = two;
            two = minCost;
        }

        return two;
    }

}
