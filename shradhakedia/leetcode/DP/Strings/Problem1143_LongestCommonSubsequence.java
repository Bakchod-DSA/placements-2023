// https://leetcode.com/problems/longest-common-subsequence/
package leetcode.DP.Strings;

public class Problem1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        // return recursion(text1, text2, text1.length() - 1, text2.length() - 1);

//         int m = text1.length();
//         int n = text2.length();
//         int[][] dp = new int[m + 1][n + 1];
//         for(int i = 0; i <= m; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return topDown(text1, text2, m, n, dp);

        // return bottomUp(text1, text2);

        return bottomUpSpaceOptimized(text1, text2);
    }

    private int recursion(String text1, String text2, int ind1, int ind2) {
        if(ind1 < 0 || ind2 < 0) return 0;

        if(text1.charAt(ind1) == text2.charAt(ind2)) {
            return 1 + recursion(text1, text2, ind1 - 1, ind2 - 1);
        }

        return Math.max(recursion(text1, text2, ind1 - 1, ind2), recursion(text1, text2, ind1, ind2 - 1));
    }

    private int topDown(String text1, String text2, int ind1, int ind2, int[][] dp) {
        if(ind1 == 0 || ind2 == 0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1)) {
            dp[ind1][ind2] = 1 + topDown(text1, text2, ind1 - 1, ind2 - 1, dp);
        } else {
            dp[ind1][ind2] = Math.max(topDown(text1, text2, ind1 - 1, ind2, dp), topDown(text1, text2, ind1, ind2 - 1, dp));
        }
        return dp[ind1][ind2];
    }

    private int bottomUp(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        // no need to write base case, as we put 0 only which is there by default.

        for(int ind1 = 1; ind1 <= m; ind1++) {
            for(int ind2 = 1; ind2 <= n; ind2++) {
                if(text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] =  1 + dp[ind1 - 1][ind2 - 1];
                } else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }

        return dp[m][n];
    }

    private int bottomUpSpaceOptimized(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[] prev = new int[n + 1];

        // no need to write base case, as we put 0 only which is there by default.

        for(int ind1 = 1; ind1 <= m; ind1++) {
            int[] curr = new int[n + 1];
            for(int ind2 = 1; ind2 <= n; ind2++) {
                if(text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1)) {
                    curr[ind2] =  1 + prev[ind2 - 1];
                } else {
                    curr[ind2] = Math.max(prev[ind2], curr[ind2 - 1]);
                }
            }
            prev = curr;
        }

        return prev[n];
    }
}
