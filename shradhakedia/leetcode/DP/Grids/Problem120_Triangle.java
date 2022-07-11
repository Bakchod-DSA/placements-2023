/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/triangle/
 * Difficulty level: Medium
 */
package leetcode.DP.Grids;

import java.util.*;

public class Problem120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        // return approachOne(triangle, 0, 0);

        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        // return approachTwo(dp, triangle, 0, 0);
        // return approachThree(triangle);
        return approachFour(triangle);
    }

    private int approachOne(List<List<Integer>> triangle, int row, int i) {
        /*  Approach: Recursion (TLE)
            Time Complexity: O(2 ^ (1 + 2 + ... + n))
            Space Complexity: O(n)
        */
        if(row == triangle.size() - 1) return triangle.get(row).get(i);

        int down = approachOne(triangle, row + 1, i);
        int diag = approachOne(triangle, row + 1, i + 1);
        return triangle.get(row).get(i) + Math.min(down, diag);
    }

    private int approachTwo(int[][] dp, List<List<Integer>> triangle, int row, int i) {
        /*  Approach: Recursion + memoization (TLE)
            Time Complexity: O((1 + 2 + ... + n))
            Space Complexity: O(n + n ^ 2)
        */
        if(row == triangle.size() - 1) return triangle.get(row).get(i);
        if(dp[row][i] != -1) return dp[row][i];
        int down = approachOne(triangle, row + 1, i);
        int diag = approachOne(triangle, row + 1, i + 1);
        dp[row][i] = triangle.get(row).get(i) + Math.min(down, diag);
        return dp[row][i];
    }

    private int approachThree(List<List<Integer>> triangle) {
        /*  Approach: Tabulation
            Time Complexity: O(n ^ 2)
            Space Complexity: O(n ^ 2)
        */
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int j = 0; j < n; j++) {
            // base case
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                int down = dp[i + 1][j];
                int diag = dp[i + 1][j + 1];
                dp[i][j] = triangle.get(i).get(j) + Math.min(down, diag);
            }
        }
        return dp[0][0];
    }

    private int approachFour(List<List<Integer>> triangle) {
        /*  Approach: Tabulation
            Time Complexity: O(n ^ 2)
            Space Complexity: O(n)
        */
        int n = triangle.size();
        int[] next = new int[n];
        for(int j = 0; j < n; j++) {
            // base case
            next[j] = triangle.get(n - 1).get(j);
        }

        for(int i = n - 2; i >= 0; i--) {
            int[] curr = new int[n];
            for(int j = 0; j < triangle.get(i).size(); j++) {
                int down = next[j];
                int diag = next[j + 1];
                curr[j] = triangle.get(i).get(j) + Math.min(down, diag);
            }
            next = curr;
        }
        return next[0];
    }
}
