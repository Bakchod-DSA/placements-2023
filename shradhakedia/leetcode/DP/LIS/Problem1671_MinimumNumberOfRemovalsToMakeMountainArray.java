// https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/
package leetcode.DP.LIS;

import java.util.Arrays;

public class Problem1671_MinimumNumberOfRemovalsToMakeMountainArray {
    public int minimumMountainRemovals(int[] arr) {
        int n = arr.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp1[i] < dp1[j] + 1) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        for(int i = n - 2; i >= 0; i--) {
            for(int j = n - 1; j > i; j--) {
                if(arr[i] > arr[j] && dp2[i] < dp2[j] + 1) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }

        int maxLen = 3; // as we will get atleast 3 sized mountain array.
        for(int i = 0; i < n; i++) {
            // "it works only when there is a mountain array."
            if(dp1[i] > 1 && dp2[i] > 1) {
                maxLen = Math.max(maxLen, dp1[i] + dp2[i] - 1);
            }
        }

        return arr.length - maxLen;
    }
}
