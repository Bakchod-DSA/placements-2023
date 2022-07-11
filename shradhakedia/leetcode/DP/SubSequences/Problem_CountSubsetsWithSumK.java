/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532
 * Difficulty level: Medium
 */
package leetcode.DP.SubSequences;

import java.util.Arrays;

public class Problem_CountSubsetsWithSumK {
    public static int findWays(int num[], int tar) {
//         int[][] dp = new int[num.length][tar + 1];
//         for(int i = 0; i < num.length; i++) {
//             Arrays.fill(dp[i], -1);
//         }
//         return topDown(dp, num, num.length - 1, tar);

        return bottomUp(num, tar);
    }

    private static int topDown(int[][] dp, int[] arr, int ind, int target) {
        // TC O(2 ^ n), SC O(n)
        if(target == 0) return 1;
        if(ind == 0) return (arr[ind] == target)? 1 : 0;

        if(dp[ind][target] != -1) return dp[ind][target];
        int excludeInd = topDown(dp, arr, ind - 1, target);
        int includeInd = 0;
        if(target >= arr[ind]) includeInd = topDown(dp, arr, ind - 1, target - arr[ind]);
        dp[ind][target] = includeInd + excludeInd;
        return dp[ind][target];
    }

    private static int bottomUp(int[] arr, int tar) {
        int n = arr.length;
        int[][] dp = new int[n][tar + 1];
        for(int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if(arr[0] <= tar) dp[0][arr[0]] = 1;

        for(int ind = 1; ind < n; ind++) {
            for(int target = 1; target <= tar; target++) {
                int notPick = dp[ind - 1][target];
                int pick = 0;
                if(arr[ind] <= target) pick = dp[ind - 1][target - arr[ind]];
                dp[ind][target] = pick + notPick;
            }
        }

        return dp[n - 1][tar];
    }
}
