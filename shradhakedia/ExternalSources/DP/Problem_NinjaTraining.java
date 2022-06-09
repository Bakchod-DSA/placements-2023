/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003
 * Difficulty level: Medium
 */
package ExternalSources.DP;

public class Problem_NinjaTraining {
    public static int ninjaTraining(int n, int points[][]) {
        return calculateMaxPoints2(points, n);
        // Write your code here..
    }
    private static int calculateMaxPoints(int[][] points, int day, int last) {
        if(day == 0) return 0;
        int ans = 0;
        if(last == 0) {
            int second = calculateMaxPoints(points, day - 1, 1) + points[day][1];
            int third = calculateMaxPoints(points, day - 1, 2) + points[day][2];
            ans = Math.max(second, third);
        } else if (last == 1) {
            int first = calculateMaxPoints(points, day - 1, 0) + points[day][0];
            int third = calculateMaxPoints(points, day - 1, 2) + points[day][2];
            ans = Math.max(first, third);
        } else if(last == 2) {
            int first = calculateMaxPoints(points, day - 1, 0) + points[day][0];
            int third = calculateMaxPoints(points, day - 1, 2) + points[day][2];
            ans = Math.max(first, third);
        } else {
            int first = calculateMaxPoints(points, day - 1, 0) + points[day][0];
            int second = calculateMaxPoints(points, day - 1, 1) + points[day][1];
            int third = calculateMaxPoints(points, day - 1, 2) + points[day][2];
            ans = Math.max(first, second);
            ans = Math.max(ans, third);
        }
        return ans;
    }

    private static int calculateMaxPoints2(int[][] points, int n) {
        int[][] dp = new int[points.length][3];
        dp[0] = points[0];
        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + points[i][0];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + points[i][1];
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + points[i][2];
        }
        int ans = Math.max(dp[n - 1][0], dp[n - 1][1]);
        ans = Math.max(ans, dp[n - 1][2]);
        return ans;
    }
}
