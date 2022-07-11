// https://leetcode.com/problems/palindromic-substrings/
package leetcode.DP.Strings;

import java.util.Arrays;

public class Problem647_PalindromicSubstrings {
    // use dp array found by longest palindromic substring.
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        topDown(s, 0, n - 1, dp);


        return countPalindromicSubstrings(dp, n);
    }

    private boolean topDown(String s, int i, int j, int[][] dp) {
        if(i > j) return true;
        if(dp[i][j] != -1) return dp[i][j] == 1;

        boolean isPalin = false;
        if(s.charAt(i) == s.charAt(j)) {
            isPalin = topDown(s, i + 1, j - 1, dp);
        }

        topDown(s, i + 1, j, dp);
        topDown(s, i, j - 1, dp);

        dp[i][j] = (isPalin)? 1 : 0;
        return isPalin;
    }

    private int countPalindromicSubstrings(int[][] dp, int n) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            // System.out.println(Arrays.toString(dp[i]));

            for(int j = 0; j < n; j++) {
                if(dp[i][j] == 1) count++;
            }
        }

        return count;
    }
}
