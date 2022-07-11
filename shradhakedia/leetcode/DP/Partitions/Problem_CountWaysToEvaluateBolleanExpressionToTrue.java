// https://www.codingninjas.com/codestudio/problems/problem-name-boolean-evaluation_1214650
package leetcode.DP.Partitions;

public class Problem_CountWaysToEvaluateBolleanExpressionToTrue {
    public static int evaluateExp(String exp) {
//         return recursion(exp, 0, exp.length() - 1, 1);

        int n = exp.length();
        Integer[][][] dp = new Integer[n][n][2];
        return topDown(exp, 0, n - 1, 1, dp);

    }

    private static int recursion(String exp, int i, int j, int isTrue) {
        if(i > j) return 0;
        if(i == j) {
            if(isTrue == 1) return exp.charAt(i) == 'T'? 1 : 0;
            else return exp.charAt(i) == 'F'? 1 : 0;
        }

        int ways = 0;
        for(int k = i + 1; k <= j - 1; k += 2) {
            int lT = recursion(exp, i, k - 1, 1);
            int lF = recursion(exp, i, k - 1, 0);
            int rT = recursion(exp, k + 1, j, 1);
            int rF = recursion(exp, k + 1, j, 0);

            char ch = exp.charAt(k);
            if(ch == '&') {
                if(isTrue == 1) ways += lT * rT;
                else ways += (lF * rF + lF * rT + lT * rF);
            } else if(ch == '|') {
                if(isTrue == 1) ways += (lT * rT + lF * rT + lT * rF);
                else ways += lF * rF;
            } else {
                if(isTrue == 1) ways += (lT * rF + lF * rT);
                else ways += (lT * rT + lF * rF);
            }
        }
        return ways;
    }

    private static int topDown(String exp, int i, int j, int isTrue, Integer[][][] dp) {
        if(i > j) return 0;
        if(i == j) {
            if(isTrue == 1) return exp.charAt(i) == 'T'? 1 : 0;
            else return exp.charAt(i) == 'F'? 1 : 0;
        }
        if(dp[i][j][isTrue] != null) return dp[i][j][isTrue];

        long ways = 0;
        for(int k = i + 1; k <= j - 1; k += 2) {
            long lT = topDown(exp, i, k - 1, 1, dp);
            long lF = topDown(exp, i, k - 1, 0, dp);
            long rT = topDown(exp, k + 1, j, 1, dp);
            long rF = topDown(exp, k + 1, j, 0, dp);

            char ch = exp.charAt(k);
            if(ch == '&') {
                if(isTrue == 1) ways = (ways + (lT * rT) % 1000000007)  % 1000000007;
                else ways = (ways + (lF * rF + lF * rT + lT * rF) % 1000000007) % 1000000007;
            } else if(ch == '|') {
                if(isTrue == 1) ways = (ways + (lT * rT + lF * rT + lT * rF) % 1000000007)  % 1000000007;
                else ways = (ways + (lF * rF) % 1000000007)  % 1000000007;
            } else {
                if(isTrue == 1) ways = (ways + (lT * rF + lF * rT) % 1000000007)  % 1000000007;
                else ways = (ways + (lT * rT + lF * rF) % 1000000007)  % 1000000007;
            }
        }

        return dp[i][j][isTrue] = (int) ways;
    }
}
