// https://practice.geeksforgeeks.org/problems/find-optimum-operation4504/1/?category
package leetcode.Greedy;

public class Problem_MinimumOperations {
    public int minOperation(int n)
    {
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);

        // return topDown(n, dp);

        return greedy(n);
    }

    private int topDown(int n, int[] dp) {
        // T.C.: O(n)
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];

        int minusOne = topDown(n - 1, dp);
        int byTwo = Integer.MAX_VALUE;
        if(n % 2 == 0) byTwo = topDown(n/2, dp);

        dp[n] = 1 + Math.min(minusOne, byTwo);
        return dp[n];
    }

    private int greedy(int n) {
        // T.C.: O(log n)
        int op = 0;

        while(n != 0) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
            op++;
        }

        return op;
    }
}
