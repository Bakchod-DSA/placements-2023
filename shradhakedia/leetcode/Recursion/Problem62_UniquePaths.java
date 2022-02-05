/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/unique-paths/
 * Difficulty level: Medium
 */

package leetcode.Recursion;

public class Problem62_UniquePaths {

    public int uniquePaths(int m, int n) {

        /*  Basic recursive Approach take time Complexity of O(mn * mn) extra mn due to
            repetitive calculation  and Space complexity of O(m + n)
        */

        int[][] dp = new int[m][n];
        return approachOne(m - 1, n - 1, dp);
    }

    private int approachOne(int m, int n, int[][] dp) {
        /*  Approach: Recursion + memoization
            Time Complexity: O(m * n)
            Space Complexity: O(m + n + m * n); m + n recursion stack(depth of tree), mn is dp table space.
        */

        if(m == 0 && n == 0) {
            dp[m][n] = 1;
            return dp[m][n];
        }
        if(m < 0 || n < 0) {
            return 0;
        }

        if(dp[m][n] == 0) {
            // topUniquePaths + leftUniquePaths
            dp[m][n] = approachOne(m - 1, n, dp) + approachOne(m, n - 1, dp);
        }

        return dp[m][n];
    }

}
