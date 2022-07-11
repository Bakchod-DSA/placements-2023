// https://leetcode.com/problems/longest-palindromic-subsequence/
package leetcode.DP.Strings;

public class Problem516_LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        // approach 1 : same as longest common subsequence, find lcs of s and revS


        // return recursion(s, 0, s.length() - 1);

//         int n = s.length();
//         int[][] dp = new int[n][n];
//         for(int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return topDown(s, 0, n - 1, dp);

        return bottomUp(s);
    }

    private int recursion(String s, int i, int j) {
        if(i > j) return 0;

        if(s.charAt(i) == s.charAt(j)) {
            return (i == j)? 1 + recursion(s, i + 1, j - 1) : 2 + recursion(s, i + 1, j - 1);
        } else {
            return Math.max(recursion(s, i + 1, j), recursion(s, i, j - 1));
        }
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
