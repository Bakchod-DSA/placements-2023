// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
package leetcode.DP.Stocks;

public class Problem188_BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        // Approach 1: exactly same as best time to buy and sell stock III.
        // Approach 2: use one state, 'transaction' instead of buy and cap.

        // return recursion(k, prices, 0, 0);

        // int n = prices.length;
        // int[][] dp = new int[n][2 * k];
        // for(int i = 0; i < n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return topDown(k, prices, 0, 0, dp);

        // return bottomUp(k, prices);

        return bottomUpSpaceOptimized(k, prices);
    }

    private int recursion(int k, int[] prices, int ind, int transaction) {
        if(ind == prices.length || transaction == 2 * k) {
            return 0;
        }

        int profit = 0;
        if(transaction % 2 == 0) {
            // buy
            int bought = - prices[ind] + recursion(k, prices, ind + 1, transaction + 1);
            int notBought = 0 + recursion(k, prices, ind + 1, transaction);

            profit = Math.max(bought, notBought);
        } else {
            // sell
            int sold = prices[ind] + recursion(k, prices, ind + 1, transaction + 1);
            int notSold = 0 + recursion(k, prices, ind + 1, transaction);
            profit = Math.max(sold, notSold);
        }

        return profit;
    }

    private int topDown(int k, int[] prices, int ind, int transaction, int[][] dp) {
        if(ind == prices.length || transaction == 2 * k) {
            return 0;
        }
        if(dp[ind][transaction] != -1)
            return dp[ind][transaction];

        int profit = 0;
        if(transaction % 2 == 0) {
            // buy
            int bought = - prices[ind] + topDown(k, prices, ind + 1, transaction + 1, dp);
            int notBought = 0 + topDown(k, prices, ind + 1, transaction, dp);

            profit = Math.max(bought, notBought);
        } else {
            // sell
            int sold = prices[ind] + topDown(k, prices, ind + 1, transaction + 1, dp);
            int notSold = 0 + topDown(k, prices, ind + 1, transaction, dp);
            profit = Math.max(sold, notSold);
        }

        dp[ind][transaction] = profit;
        return dp[ind][transaction];
    }

    private int bottomUp(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2 * k + 1];

        // base case, although not required, just for understanding how to covert base cases of top down to bottom up.
        /*
        for(int transaction = 0; transaction <= 2 * k; transaction++) {
            dp[n][transaction] = 0;
        }
        for(int ind = 0; ind <= n; ind++) {
            dp[ind][2 * k] = 0;
        }
        */

        int profit = 0;
        for(int ind = n - 1; ind >= 0; ind--) {
            for(int transaction = 2 * k - 1; transaction >= 0; transaction--) {
                if(transaction % 2 == 0) {
                    // buy
                    int bought = - prices[ind] + dp[ind + 1][transaction + 1];
                    int notBought = 0 + dp[ind + 1][transaction];

                    profit = Math.max(bought, notBought);
                } else {
                    // sell
                    int sold = prices[ind] + dp[ind + 1][transaction + 1];
                    int notSold = 0 + dp[ind + 1][transaction];

                    profit = Math.max(sold, notSold);
                }

                dp[ind][transaction] = profit;
            }
        }

        return dp[0][0];
    }

    private int bottomUpSpaceOptimized(int k, int[] prices) {
        int n = prices.length;
        int[] ahead = new int[2 * k + 1];
        int[] curr = new int[2 * k + 1];

        // base case, although not required, just for understanding how to covert base cases of top down to bottom up.
        /*
        for(int transaction = 0; transaction <= 2 * k; transaction++) {
            ahead[transaction] = 0;
        }
        ahead[2 * k] = 0;
        */

        int profit = 0;
        for(int ind = n - 1; ind >= 0; ind--) {
            for(int transaction = 2 * k - 1; transaction >= 0; transaction--) {
                if(transaction % 2 == 0) {
                    // buy
                    int bought = - prices[ind] + ahead[transaction + 1];
                    int notBought = 0 + ahead[transaction];

                    profit = Math.max(bought, notBought);
                } else {
                    // sell
                    int sold = prices[ind] + ahead[transaction + 1];
                    int notSold = 0 + ahead[transaction];

                    profit = Math.max(sold, notSold);
                }

                curr[transaction] = profit;
            }

            ahead = curr;
        }

        return ahead[0];
    }
}
