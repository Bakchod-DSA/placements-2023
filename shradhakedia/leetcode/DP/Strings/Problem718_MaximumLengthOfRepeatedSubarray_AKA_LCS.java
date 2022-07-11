// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
package leetcode.DP.Strings;

public class Problem718_MaximumLengthOfRepeatedSubarray_AKA_LCS {
    public int findLength(int[] nums1, int[] nums2) {
        return bottomUpSpaceOptimized(nums1, nums2);
    }

    private int bottomUp(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];

        // base case
        for(int j = 0; j <= m; j++) dp[0][j] = 0;
        for(int i = 0; i <= n; i++) dp[i][0] = 0;

        int maxLen = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLen;
    }

    private int bottomUpSpaceOptimized(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] prev = new int[m + 1];

        int maxLen = 0;
        for(int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];

            for(int j = 1; j <= m; j++) {
                if(nums1[i - 1] == nums2[j - 1]) {
                    curr[j] = 1 + prev[j - 1];
                    maxLen = Math.max(maxLen, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            prev = curr;
        }

        return maxLen;
    }
}
