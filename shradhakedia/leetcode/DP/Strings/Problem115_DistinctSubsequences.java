// https://leetcode.com/problems/distinct-subsequences/
package leetcode.DP.Strings;

public class Problem115_DistinctSubsequences {
    public int numDistinct(String s, String t) {
        // int n = s.length(), m = t.length();
        // int[][] dp = new int[n + 1][m + 1];
        // for(int i = 0; i <= n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return topDown(s, t, n, m, dp);

        return bottomUp(s, t);
    }

    private int topDown(String s, String t, int i, int j, int[][] dp) {
        if(j == 0) return 1;
        if(i == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i - 1) == t.charAt(j - 1)) {
            dp[i][j] = topDown(s, t, i - 1, j - 1, dp) + topDown(s, t, i - 1, j, dp);
        } else {
            dp[i][j] = topDown(s, t, i - 1, j, dp);
        }

        return dp[i][j];
    }

    private int bottomUp(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for(int j = 1; j <= m; j++) {
            dp[0][j] = 0;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
}
