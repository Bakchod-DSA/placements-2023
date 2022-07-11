// https://leetcode.com/problems/regular-expression-matching/
package leetcode.DP.Strings;

import java.util.Arrays;

public class Problem10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();

        // return recursion(s, p, n - 1, m - 1);

        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return topDown(s, p, n - 1, m - 1, dp);

    }

    private boolean recursion(String s, String p, int i, int j) {
        if(j < 0) return i < 0;

        if(i >= 0 && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) {
            return recursion(s, p, i - 1, j - 1);
        } else if(p.charAt(j) == '*') {
            if(j > 0 && i >= 0 && (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.')) {
                return recursion(s, p, i - 1, j) || recursion(s, p, i, j - 2);
            } else {
                return recursion(s, p, i, j -2);
            }
        } else {
            return false;
        }
    }

    private boolean topDown(String s, String p, int i, int j, int[][] dp) {
        if(j < 0) return i < 0;
        if(i >= 0 && dp[i][j] != -1) return dp[i][j] == 1;

        boolean match;
        if(i >= 0 && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) {
            match = topDown(s, p, i - 1, j - 1, dp);
        } else if(p.charAt(j) == '*') {
            if(j > 0 && i >= 0 && (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.')) {
                match = topDown(s, p, i - 1, j, dp) || topDown(s, p, i, j - 2, dp);
            } else {
                match = topDown(s, p, i, j - 2, dp);
            }
        } else {
            match = false;
        }

        if(i >= 0) dp[i][j] = match? 1 : 0;
        return match;
    }
}
