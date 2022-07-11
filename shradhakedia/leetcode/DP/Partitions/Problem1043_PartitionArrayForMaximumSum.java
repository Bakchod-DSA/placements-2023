// https://leetcode.com/problems/partition-array-for-maximum-sum/
package leetcode.DP.Partitions;

public class Problem1043_PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // return recursion(arr, k, 0);

        // Integer[] dp = new Integer[arr.length];
        // return topDown(arr, k, 0, dp);

        return bottomUp(arr, k);
    }

    private int recursion(int[] arr, int k, int i) {
        if(i == arr.length) return 0;

        int maxSum = Integer.MIN_VALUE, val = 0;
        for(int j = i; j < Math.min(i + k, arr.length); j++) {
            val = Math.max(val, arr[j]);
            int sum = val * (j - i + 1) + recursion(arr, k, j + 1);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    private int topDown(int[] arr, int k, int i, Integer[] dp) {
        if(i == arr.length) return 0;
        if(dp[i] != null) return dp[i];

        int maxSum = Integer.MIN_VALUE, val = 0;
        for(int j = i; j < Math.min(i + k, arr.length); j++) {
            val = Math.max(val, arr[j]);
            int sum = val * (j - i + 1) + topDown(arr, k, j + 1, dp);
            maxSum = Math.max(maxSum, sum);
        }

        return dp[i] = maxSum;
    }

    private int bottomUp(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for(int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            int val = 0;
            for(int j = i; j < Math.min(i + k, arr.length); j++) {
                val = Math.max(val, arr[j]);
                int sum = val * (j - i + 1) + dp[j + 1];
                dp[i] = Math.max(dp[i], sum);
            }
        }
        return dp[0];
    }

}
