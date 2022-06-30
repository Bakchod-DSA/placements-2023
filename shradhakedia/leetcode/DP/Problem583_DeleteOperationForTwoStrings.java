/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/delete-operation-for-two-strings/
 * Difficulty level: Medium
 */
package leetcode.DP;

import java.util.Arrays;

public class Problem583_DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i = 0; i < word1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return approachTwo(dp, word1, word2, 0, 0);
    }

    private int approachOne(String s1, String s2, int s1Index, int s2Index) {
        // recursion
        if(s1.length() == s1Index && s2.length() == s2Index) {
            return 0;
        }
        if(s1.length() == s1Index) {
            return s2.length() - s2Index;
        }
        if(s2.length() == s2Index) {
            return s1.length() - s1Index;
        }

        if(s1.charAt(s1Index) != s2.charAt(s2Index)) {
            int removeS1Char = 1 + approachOne(s1, s2, s1Index + 1, s2Index);
            int removeS2Char = 1 + approachOne(s1, s2, s1Index, s2Index + 1);
            return Math.min(removeS1Char, removeS2Char);
        } else {
            return approachOne(s1, s2, s1Index + 1, s2Index + 1);
        }
    }

    private int approachTwo(int[][] dp, String s1, String s2, int s1Index, int s2Index) {
        // recursion + memo -> top down
        if(s1.length() == s1Index && s2.length() == s2Index) {
            return 0;
        }
        if(s1.length() == s1Index) {
            return s2.length() - s2Index;
        }
        if(s2.length() == s2Index) {
            return s1.length() - s1Index;
        }

        if(dp[s1Index][s2Index] != -1) return dp[s1Index][s2Index];

        if(s1.charAt(s1Index) != s2.charAt(s2Index)) {
            int removeS1Char = 1 + approachTwo(dp, s1, s2, s1Index + 1, s2Index);
            int removeS2Char = 1 + approachTwo(dp, s1, s2, s1Index, s2Index + 1);
            dp[s1Index][s2Index] = Math.min(removeS1Char, removeS2Char);
        } else {
            dp[s1Index][s2Index] = approachTwo(dp, s1, s2, s1Index + 1, s2Index + 1);
        }

        return dp[s1Index][s2Index];
    }
}
