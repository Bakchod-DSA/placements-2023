// https://leetcode.com/problems/wildcard-matching/
package leetcode.DP.Strings;

public class Problem44_WildCardMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        // return recursion(s, p, n - 1, m - 1);

//         int[][] dp = new int[n][m];
//         for(int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return topDown(s, p, n - 1, m - 1, dp);

        return bottomUp(s, p);

    }

    private boolean recursion(String s, String p, int i, int j) {
        if(i < 0 && j < 0) return true;
        if(i < 0) return isPatternAllStar(p.substring(0, j + 1));
        if(j < 0) return false;

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return recursion(s, p, i - 1, j - 1);
        } else if(p.charAt(j) == '*') {
            return recursion(s, p, i - 1, j) || recursion(s, p, i, j - 1);
        } else {
            return false;
        }
    }

    private boolean isPatternAllStar(String p) {
        for(char ch : p.toCharArray()) {
            if(ch != '*') {
                return false;
            }
        }

        return true;
    }

    private boolean topDown(String s, String p, int i, int j, int[][] dp) {
        if(i < 0 && j < 0) return true;
        if(i < 0) return isPatternAllStar(p.substring(0, j + 1));
        if(j < 0) return false;

        if(dp[i][j] != -1) return dp[i][j] == 1;

        boolean match;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            match = topDown(s, p, i - 1, j - 1, dp);
        } else if(p.charAt(j) == '*') {
            match = topDown(s, p, i - 1, j, dp) || topDown(s, p, i, j - 1, dp);
        } else {
            match = false;
        }

        dp[i][j] = (match)? 1 : 0;
        return match;
    }

    private boolean bottomUp(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        for(int j = 1; j <= m; j++) {
            dp[0][j] = isPatternAllStar(p.substring(0, j));
        }
        for(int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

}
