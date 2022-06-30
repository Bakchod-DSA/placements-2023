/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/longest-string-chain/
 * Difficulty level: Medium
 */
package leetcode.DP;

import java.util.*;

public class Problem1048_LongestStringChain {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());

        int n = words.length;
        int[][] dp = new int[n][n + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return topDown(dp, words, 0, -1);
    }


    private int topDown(int[][] dp, String[] words, int index, int prevIndex) {
        if(index == words.length) return 0;

        if(dp[index][prevIndex + 1] != -1) return dp[index][prevIndex + 1];

        int notPick = topDown(dp, words, index + 1, prevIndex);
        int pick = 0;
        if(prevIndex == -1 || compare(words[index], words[prevIndex])) {
            pick = 1 + topDown(dp, words, index + 1, index);
        }

        dp[index][prevIndex + 1] = Math.max(pick, notPick);
        return dp[index][prevIndex + 1];
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
