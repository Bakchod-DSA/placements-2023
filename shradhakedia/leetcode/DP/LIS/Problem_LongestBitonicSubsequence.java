// https://www.codingninjas.com/codestudio/problems/longest-bitonic-sequence_1062688
package leetcode.DP.LIS;

import java.util.Arrays;

public class Problem_LongestBitonicSubsequence {
    public static int longestBitonicSequence(int[] arr, int n) {
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        dp1[0] = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp1[i] < dp1[j] + 1) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        dp2[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--) {
            for(int j = n - 1; j > i; j--) {
                if(arr[i] > arr[j] && dp2[i] < dp2[j] + 1) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }

        int maxLen = 1;
        for(int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, dp1[i] + dp2[i] - 1);
        }

        return maxLen;
    }}
