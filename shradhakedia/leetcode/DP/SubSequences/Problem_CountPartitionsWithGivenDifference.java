// https://www.codingninjas.com/codestudio/problems/partitions-with-given-difference_3751628
package leetcode.DP.SubSequences;

import java.util.Arrays;

public class Problem_CountPartitionsWithGivenDifference {
    public static int countPartitions(int n, int d, int[] arr) {
        int totSum = 0;
        for(int i = 0; i < arr.length; i++) {
            totSum += arr[i];
        }

        if((totSum + d) % 2 == 1) return 0;
        int target = (totSum + d)/2;

        int[][] dp = new int[n][target + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return countSubsetsWithSumK(arr, n - 1, target, dp);
    }

    private static int countSubsetsWithSumK(int[] arr, int ind, int target, int[][] dp) {
        // TC O(mn), SC (mn + n), m = target, n = arr.length
        if(ind == 0) {
            if(target == 0 && arr[0] == 0) return 2;
            if(target == 0 || arr[0] == target) return 1;
            return 0;
        }
        if(dp[ind][target] != -1) return dp[ind][target];

        int notPick = countSubsetsWithSumK(arr, ind - 1, target, dp);
        int pick = 0;
        if(target >= arr[ind]) pick = countSubsetsWithSumK(arr, ind - 1, target - arr[ind], dp);

        dp[ind][target] = (pick + notPick) % 1000000007;
        return dp[ind][target];
    }
}
