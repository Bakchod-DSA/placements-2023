/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.codingninjas.com/codestudio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494
 * Difficulty level: Medium
 */
package leetcode.DP.SubSequences;

public class Problem_PartitionSubsetWithMinimumDifference {
    public static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum = 0;
        for(int num : arr) {
            totalSum += num;
        }

        boolean[] dp = subsetSumEqualToK(arr, totalSum);
        int min = Integer.MAX_VALUE;
        for(int s1 = 0; s1 <= totalSum; s1++) {
            int s2 = totalSum - s1;
            if(dp[s1]) min = Math.min(min, Math.abs(s2 - s1));
        }

        return min;
    }


    private static boolean[] subsetSumEqualToK(int[] arr, int totalSum) {

        int n = arr.length;
        // dp[n - 1][totalSum] indicating if total sum is possible or not.
        boolean[] prev = new boolean[totalSum + 1];
        prev[0] = true;
        if(arr[0] <= totalSum) prev[arr[0]] = true;

        for(int i = 1; i < n; i++) {
            boolean[] curr = new boolean[totalSum + 1];
            curr[0] = true;
            for(int target = 1; target <= totalSum; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if(arr[i] <= target) take = prev[target - arr[i]];
                curr[target] = take | notTake;
            }
            prev = curr;
        }

        return prev;
    }
}
