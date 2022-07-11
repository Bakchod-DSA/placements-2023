// https://leetcode.com/problems/longest-palindromic-substring/
package leetcode.DP.Strings;

import java.util.Arrays;

public class Problem5_LongestPalindromicSubstring {
    String ans;

    public String longestPalindrome(String s) {
        ans = "";
        int n = s.length();

        // recursion(s, 0, n - 1);

        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        topDown(s, 0, n - 1, dp);
        return ans;
    }

    private boolean recursion(String s, int i, int j) {
        if(i >= j) return true;

        boolean isPalin = false;
        if(s.charAt(i) == s.charAt(j)) {
            isPalin = recursion(s, i + 1, j - 1);
            if(isPalin && ans.length() < j - i + 1) ans = s.substring(i, j + 1);
        }

        recursion(s, i + 1, j);
        recursion(s, i, j - 1);

        return isPalin;
    }

    private boolean topDown(String s, int i, int j, int[][] dp) {
        if(i > j) return true;
        if(dp[i][j] != -1) return dp[i][j] == 1;

        boolean isPalin = false;
        if(s.charAt(i) == s.charAt(j)) {
            isPalin = topDown(s, i + 1, j - 1, dp);
            if(isPalin && ans.length() < j - i + 1) ans = s.substring(i, j + 1);
        }

        topDown(s, i + 1, j, dp);
        topDown(s, i, j - 1, dp);

        dp[i][j] = (isPalin)? 1 : 0;
        return isPalin;
    }
}
