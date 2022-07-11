// https://leetcode.com/problems/longest-string-chain/
package leetcode.DP.LIS;

import java.util.Arrays;

public class Problem1048_LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());

        // return recursion(words, 0, -1);

        // int n = words.length;
        // int[][] dp = new int[n][n + 1];
        // for(int i = 0; i < n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return topDown(words, 0, -1, dp);

        return bottomUp(words);
    }

    private int recursion(String[] words, int ind, int prev) {
        if(ind == words.length) return 0;

        int notPick = recursion(words, ind + 1, prev);
        int pick = Integer.MIN_VALUE;
        if(prev == -1 || compare(words[ind], words[prev])) {
            pick = 1 + recursion(words, ind + 1, ind);
        }

        return Math.max(pick, notPick);
    }

    private int topDown(String[] words, int ind, int prev, int[][] dp) {
        if(ind == words.length) return 0;
        if(dp[ind][prev + 1] != -1) return dp[ind][prev + 1];

        int notPick = topDown(words, ind + 1, prev, dp);
        int pick = Integer.MIN_VALUE;
        if(prev == -1 || compare(words[ind], words[prev])) {
            pick = 1 + topDown(words, ind + 1, ind, dp);
        }

        dp[ind][prev + 1] = Math.max(pick, notPick);
        return dp[ind][prev + 1];
    }

    private int bottomUp(String[] words) {
        int n = words.length;
        int[][] dp = new int[n + 1][n + 1];

        for(int ind = n - 1; ind >= 0; ind--) {
            for(int prev = ind - 1; prev >= -1; prev--) {
                int notPick = dp[ind + 1][prev + 1];
                int pick = Integer.MIN_VALUE;
                if(prev == -1 || compare(words[ind], words[prev])) {
                    pick = 1 + dp[ind + 1][ind + 1];
                }

                dp[ind][prev + 1] = Math.max(pick, notPick);
            }
        }

        return dp[0][0];
    }

    private boolean compare(String s1, String s2) {
        // words[index] > words[prevIndex]
        if(s1.length() - s2.length() != 1) return false;

        for(int i = 0, j = 0; i < s2.length();) {
            if(j == s1.length()) return false;

            if(s1.charAt(j) == s2.charAt(i)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return true;
    }
}
