// https://leetcode.com/problems/delete-operation-for-two-strings/
package leetcode.DP.Strings;

public class Problem583_DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int len = longestCommonSubsequence(word1, word2);
        return n + m - 2 * len;
    }

    private int longestCommonSubsequence(String s1, String s2) {
//         int n = s1.length(), m = s2.length();
//         int[][] dp = new int[n][m];

//         for(int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return topDown(s1, s2, n - 1, m - 1, dp);

        return bottomUp(s1, s2);
    }

    private int topDown(String s1, String s2, int ind1, int ind2, int[][] dp) {
        if(ind1 < 0 || ind2 < 0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(s1.charAt(ind1) == s2.charAt(ind2)) {
            dp[ind1][ind2] = 1 + topDown(s1, s2, ind1 - 1, ind2 - 1, dp);
        } else {
            dp[ind1][ind2] = Math.max(topDown(s1, s2, ind1 - 1, ind2, dp), topDown(s1, s2, ind1, ind2 - 1, dp));
        }

        return dp[ind1][ind2];
    }

    private int bottomUp(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int ind2 = 0; ind2 <= m; ind2++) {
            dp[0][ind2] = 0;
        }
        for(int ind1 = 0; ind1 <= n; ind1++) {
            dp[ind1][0] = 0;
        }

        for(int ind1 = 1; ind1 <= n; ind1++) {
            for(int ind2 = 1; ind2 <= m; ind2++) {
                if(s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }

        return dp[n][m];
    }
}
