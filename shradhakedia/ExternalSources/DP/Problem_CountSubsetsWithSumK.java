/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532
 * Difficulty level: Medium
 */
package ExternalSources.DP;

import java.util.Arrays;

public class Problem_CountSubsetsWithSumK {
    public static int findWays(int num[], int tar) {
        int[][] dp = new int[num.length][tar + 1];
        for(int i = 0; i < num.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return approachOne(dp, num, num.length - 1, tar);
    }

    private static int approachOne(int[][] dp, int[] arr, int ind, int target) {
        if(target == 0) return 1;
        if(ind == 0) return (arr[ind] == target)? 1 : 0;

        if(dp[ind][target] != -1) return dp[ind][target];
        int excludeInd = approachOne(dp, arr, ind - 1, target);
        int includeInd = 0;
        if(target >= arr[ind]) includeInd = approachOne(dp, arr, ind - 1, target - arr[ind]);
        dp[ind][target] = includeInd + excludeInd;
        return dp[ind][target];
    }
}
