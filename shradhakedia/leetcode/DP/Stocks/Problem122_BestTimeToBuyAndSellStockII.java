// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
package leetcode.DP.Stocks;

public class Problem122_BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        // return recursion(prices, 0, 1);

//         int n = prices.length;
//         int[][] dp = new int[n][2];
//         for(int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

        // return topDown(prices, 0, 1, dp);

        // return bottomUp(prices);

        return bottomUpSpaceOptimized(prices);
    }

    private int recursion(int[] prices, int ind, int buy) {
        if(ind == prices.length) return 0;

        int profit = 0;
        if(buy == 1) { // allowed to buy

            // bought, so need to give price. therefore minus and further call it with buy = 0 because cannot buy now.
            int bought = -prices[ind] + recursion(prices, ind + 1, 0);
            // not bought, and call further to allowed to buy with buy = 1.
            int notBought = 0 + recursion(prices, ind + 1, 1);

            profit = Math.max(bought, notBought);
        } else { // allowed to sell

            // sold. so, again allowed to buy now, therfeore buy = 1 is send further.
            int sold = prices[ind] + recursion(prices, ind + 1, 1);
            // not sold, so not allowed to buy further.
            int notSold = 0 + recursion(prices, ind + 1, 0);

            profit = Math.max(sold, notSold);
        }

        return profit;
    }

    private int topDown(int[] prices, int ind, int buy, int[][] dp) {
        if(ind == prices.length) return 0;

        if(dp[ind][buy] != -1) return dp[ind][buy];

        if(buy == 1) {
            // allowed to buy
            int bought = -prices[ind] + topDown(prices, ind + 1, 0, dp);
            int notBought = 0 + topDown(prices, ind + 1, 1, dp);

            dp[ind][buy] = Math.max(bought, notBought);
        } else {
            // allowed to sell
            int sold = prices[ind] + topDown(prices, ind + 1, 1, dp);
            int notSold = 0 + topDown(prices, ind + 1, 0, dp);

            dp[ind][buy] = Math.max(sold, notSold);
        }

        return dp[ind][buy];
    }

    private int bottomUp(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        // base case
        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int ind = n - 1; ind >= 0; ind--) {
            for(int buy = 0; buy <= 1; buy++) {
                if(buy == 0) {
                    int sold = prices[ind] + dp[ind + 1][1];
                    int notSold = dp[ind + 1][0];

                    dp[ind][buy] = Math.max(sold, notSold);
                } else {
                    int bought = -prices[ind] + dp[ind + 1][0];
                    int notBought = dp[ind + 1][1];

                    dp[ind][buy] = Math.max(bought, notBought);
                }
            }
        }

        return dp[0][1];
    }

    private int bottomUpSpaceOptimized(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[2];

        // base case
        ahead[0] = 0;
        ahead[1] = 0;

        for(int ind = n - 1; ind >= 0; ind--) {
            int[] curr = new int[2];

            for(int buy = 0; buy <= 1; buy++) {
                if(buy == 0) {
                    int sold = prices[ind] + ahead[1];
                    int notSold = ahead[0];

                    curr[buy] = Math.max(sold, notSold);
                } else {
                    int bought = -prices[ind] + ahead[0];
                    int notBought = ahead[1];

                    curr[buy] = Math.max(bought, notBought);
                }
            }
            ahead = curr;
        }

        return ahead[1];
    }
}
