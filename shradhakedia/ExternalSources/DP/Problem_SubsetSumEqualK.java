/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954
 * Difficulty level: Medium
 */
package ExternalSources.DP;

import java.util.Arrays;

public class Problem_SubsetSumEqualK {
    public static boolean subsetSumToK(int n, int k, int arr[]){

        // return approachOne(arr, n - 1, k);
        int[][] dp = new int[n][k + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

//         return approachTwo(dp, arr, n - 1, k);
        return approachThree(arr, n, k);
    }

    private static boolean approachOne(int[] arr, int ind, int target) {
        if(target == 0) return true;
        if(ind == 0) return (arr[ind] == target);

        boolean excludeInd = approachOne(arr, ind - 1, target);
        boolean includeInd = false;
        if(target >= arr[ind]) includeInd = approachOne(arr, ind - 1, target - arr[ind]);
        return includeInd || excludeInd;
    }

    private static boolean approachTwo(int[][] dp, int[] arr, int ind, int target) {
        if(target == 0) return true;
        if(ind == 0) return (arr[ind] == target);

        if(dp[ind][target] != -1) {
            return (dp[ind][target] == 0)? false : true;
        }

        boolean excludeInd = approachTwo(dp, arr, ind - 1, target);
        boolean includeInd = false;
        if(target >= arr[ind]) includeInd = approachTwo(dp, arr, ind - 1, target - arr[ind]);
        boolean res = includeInd | excludeInd;
        dp[ind][target] = (res)? 1 : 0;
        return res;
    }

    private static boolean approachThree(int[] arr, int n, int k) {
        boolean[][] dp = new boolean[n][k + 1];
        for(int i = 0; i < n; i++) {
            // transformation of if(target == 0) return true;
            dp[i][0] = true;
        }

        // transformation of if(ind == 0) return (arr[ind] == target);
        if(arr[0] <= k) dp[0][arr[0]] = true;

        for(int ind = 1; ind < n; ind++) {
            for(int target = 1; target <= k; target++) {
                boolean excludeInd = dp[ind - 1][target];
                boolean includeInd = false;
                if(target >= arr[ind]) includeInd = dp[ind - 1][target - arr[ind]];
                dp[ind][target] = includeInd || excludeInd;
            }
        }

        return dp[n - 1][k];
    }
}
