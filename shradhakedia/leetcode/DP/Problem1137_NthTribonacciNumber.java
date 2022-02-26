/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/n-th-tribonacci-number/
 * Difficulty level: Medium
 */

package leetcode.DP;

public class Problem1137_NthTribonacciNumber {

    public int tribonacci(int n) {

//         int[] memo = new int[n + 1];
//         Arrays.fill(memo, -1);

//         return approachOne(n, memo);
//         return approachTwo(n);
        return approachThree(n);

    }

    private int approachOne(int n, int[] memo) {
        /*  Approach: fibonacci series, DP (Recursion + memoization) Top Down
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        if(n == 0) {
            memo[0] = 0;
            return memo[0];
        }
        if(n == 1  || n == 2) {
            memo[n] = 1;
            return memo[n];
        }

        if(memo[n] == -1) {
            memo[n] = approachOne(n - 1, memo) + approachOne(n - 2, memo) + approachOne(n - 3, memo);
        }

        return memo[n];
    }

    private int approachTwo(int n) {
        /*  Approach: fibonacci series, DP (Tabulation) Bottom up
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        if(n == 0) {
            return 0;
        }
        if(n == 1  || n == 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    private int approachThree(int n) {
        /*  Approach: fibonacci series, DP (Tabulation) Bottom up
            Time Complexity: O(n)
            Space Complexity: O(1)
        */

        if(n == 0) {
            return 0;
        }
        if(n == 1  || n == 2) {
            return 1;
        }

        int tribMinus1 = 0;
        int tribMinus2 = 1;
        int tribMinus3 = 1;
        for(int i = 3; i <= n; i++) {
            int trib = tribMinus1 + tribMinus2 + tribMinus3;
            tribMinus1 = tribMinus2;
            tribMinus2 = tribMinus3;
            tribMinus3 = trib;
        }

        return tribMinus3;
    }

}
