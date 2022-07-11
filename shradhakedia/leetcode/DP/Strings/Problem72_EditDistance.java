// https://leetcode.com/problems/edit-distance/https://leetcode.com/problems/edit-distance/
package leetcode.DP.Strings;

public class Problem72_EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        // return recursion(word1, word2, n, m);

//         int[][] dp = new int[n + 1][m + 1];
//         for(int i = 0; i <= n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return topDown(word1, word2, n, m, dp);

        return bottomUp(word1, word2);
    }

    private int recursion(String word1, String word2, int i, int j) {
        if(i == 0) return j;
        if(j == 0) return i;

        if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return recursion(word1, word2, i - 1, j - 1);
        } else {
            int insert = 1 + recursion(word1, word2, i, j - 1);
            int delete = 1 + recursion(word1, word2, i - 1, j);
            int replace = 1 + recursion(word1, word2, i - 1, j - 1);
            return Math.min(Math.min(insert, delete), replace);
        }
    }

    private int topDown(String word1, String word2, int i, int j, int[][] dp) {
        if(i == 0) return j;
        if(j == 0) return i;
        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
            dp[i][j] = topDown(word1, word2, i - 1, j - 1, dp);
        } else {
            int insert = 1 + topDown(word1, word2, i, j - 1, dp);
            int delete = 1 + topDown(word1, word2, i - 1, j, dp);
            int replace = 1 + topDown(word1, word2, i - 1, j - 1, dp);
            dp[i][j] = Math.min(Math.min(insert, delete), replace);
        }

        return dp[i][j];
    }

    private int bottomUp(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for(int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(Math.min(insert, delete), replace);
                }
            }
        }

        return dp[n][m];
    }
}
