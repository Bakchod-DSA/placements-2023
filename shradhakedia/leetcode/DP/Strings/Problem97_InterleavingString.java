// https://leetcode.com/problems/interleaving-string/
package leetcode.DP.Strings;

import java.util.Arrays;

public class Problem97_InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        // return recursion(s1, s2, s3, 0, 0, 0);

        int m = s1.length(), n = s2.length(), k = s3.length();
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return topDown(s1, s2, s3, 0, 0, 0, dp);
    }

    private boolean recursion(String s1, String s2, String s3, int ind1, int ind2, int ind3) {
        if(ind3 == s3.length()) {
            return ind1 == s1.length() && ind2 == s2.length();
        }
        if(ind1 == s1.length()) {
            return s2.substring(ind2).equals(s3.substring(ind3));
        }
        if(ind2 == s2.length()) {
            return s1.substring(ind1).equals(s3.substring(ind3));
        }


        if(s1.charAt(ind1) == s2.charAt(ind2) && s1.charAt(ind1) == s3.charAt(ind3)) {
            boolean chooseS1 = recursion(s1, s2, s3, ind1 + 1, ind2, ind3 + 1);
            boolean chooseS2 = recursion(s1, s2, s3, ind1, ind2 + 1, ind3 + 1);
            return chooseS1 | chooseS2;
        }

        if(s1.charAt(ind1) == s3.charAt(ind3)) {
            return recursion(s1, s2, s3, ind1 + 1, ind2, ind3 + 1);
        } else if(s2.charAt(ind2) == s3.charAt(ind3)) {
            return recursion(s1, s2, s3, ind1, ind2 + 1, ind3 + 1);
        } else {
            return false;
        }

    }

    private boolean topDown(String s1, String s2, String s3, int ind1, int ind2, int ind3, int[][] dp) {
        if(ind3 == s3.length()) {
            return ind1 == s1.length() && ind2 == s2.length();
        }
        if(ind1 == s1.length()) {
            return s2.substring(ind2).equals(s3.substring(ind3));
        }
        if(ind2 == s2.length()) {
            return s1.substring(ind1).equals(s3.substring(ind3));
        }
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2] == 1;

        if(s1.charAt(ind1) == s2.charAt(ind2) && s1.charAt(ind1) == s3.charAt(ind3)) {
            boolean chooseS1 = topDown(s1, s2, s3, ind1 + 1, ind2, ind3 + 1, dp);
            boolean chooseS2 = topDown(s1, s2, s3, ind1, ind2 + 1, ind3 + 1, dp);
            dp[ind1][ind2] = (chooseS1 | chooseS2)? 1 : 0;
        } else if(s1.charAt(ind1) == s3.charAt(ind3)) {
            dp[ind1][ind2] = topDown(s1, s2, s3, ind1 + 1, ind2, ind3 + 1, dp)? 1 : 0;
        } else if(s2.charAt(ind2) == s3.charAt(ind3)) {
            dp[ind1][ind2] = topDown(s1, s2, s3, ind1, ind2 + 1, ind3 + 1, dp)? 1 : 0;
        } else {
            dp[ind1][ind2] = 0;
        }

        return dp[ind1][ind2] == 1;
    }
}
