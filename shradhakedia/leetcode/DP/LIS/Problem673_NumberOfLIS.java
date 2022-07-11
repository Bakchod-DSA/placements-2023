// https://leetcode.com/problems/number-of-longest-increasing-subsequence/
package leetcode.DP.LIS;

import java.util.Arrays;

public class Problem673_NumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        int maxLen = 0;
        for(int ind = 0; ind < n; ind++) {
            for(int prev = 0; prev < ind; prev++) {
                if(nums[ind] > nums[prev]) {
                    if(dp[ind] < dp[prev] + 1) {
                        dp[ind] = dp[prev] + 1;
                        // inherit
                        cnt[ind] = cnt[prev];
                    } else if(dp[ind] == dp[prev] + 1) {
                        // increase the count
                        cnt[ind] += cnt[prev];
                    }
                }
            }

            maxLen = Math.max(maxLen, dp[ind]);
        }


        int numOfLIS = 0;
        for(int i = 0; i < nums.length; i++) {
            if(dp[i] == maxLen) {
                numOfLIS += cnt[i];
            }
        }

        return numOfLIS;
    }
}
