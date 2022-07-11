package leetcode.DP.Strings;

import java.util.Arrays;

public class Problem1312_MinimumInsertionsStepsToMakeAStringPalindrome {
    public int minInsertions(String s) {
        int n = s.length();
        int len = lengthOfLongestPalindromicSubsequence(s);

        return n - len;
    }

    private int lengthOfLongestPalindromicSubsequence(String s) {
        // return bottomUp(s);

        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = n - 1; i >= 0; i--) {
            Arrays.fill(dp[i], -1);
        }

        return topDown(s, 0, n - 1, dp);
    }

    private int topDown(String s, int i, int j, int[][] dp) {
        if(i > j) return 0;
        if(i == j) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + topDown(s, i + 1, j - 1, dp);
        } else {
            dp[i][j] = Math.max(topDown(s, i + 1, j, dp), topDown(s, i, j - 1, dp));
        }

        return dp[i][j];
    }

    private int bottomUp(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for(int j = i + 1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
