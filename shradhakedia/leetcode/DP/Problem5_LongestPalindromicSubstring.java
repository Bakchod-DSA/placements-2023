/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/longest-palindromic-substring/
 * Difficulty level: Medium
 */
package leetcode.DP;

import java.util.Arrays;

public class Problem5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        int[] ans = new int[] {0, 0};
        recursion(dp, s, 0, s.length() - 1, ans);

        return s.substring(ans[0], ans[1] + 1);
    }

    public boolean recursion(int[][] dp, String s, int left, int right, int[] ans) {

        if(left >= right) return true;

        if(dp[left][right] != -1) return dp[left][right] == 1;

        boolean isPalin = false;
        if(s.charAt(left) == s.charAt(right)) {
            isPalin = recursion(dp, s, left + 1, right - 1, ans);
            if(isPalin && (right - left > ans[1] - ans[0])) {
                ans[0] = left;
                ans[1] = right;
            }
        }

        recursion(dp, s, left + 1, right, ans);
        recursion(dp, s, left, right - 1, ans);

        dp[left][right] = (isPalin)? 1 : 0;
        return isPalin;
    }
}
