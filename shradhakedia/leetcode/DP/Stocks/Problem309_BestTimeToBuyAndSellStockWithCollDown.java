// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
package leetcode.DP.Stocks;

public class Problem309_BestTimeToBuyAndSellStockWithCollDown {
    public int maxProfit(int[] prices) {
        // return recursion(prices, 0, 1);

        // int n = prices.length;
        // int[][] dp = new int[n][2];
        // for(int i = 0; i < n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return topDown(prices, 0, 1, dp);

        return bottomUp(prices);

        // cannot space optimize it because we depend on dp[i + 1] and dp[i + 2] both.
    }

    private int recursion(int[] prices, int ind, int buy) {
        if(ind >= prices.length) return 0;

        int profit = 0;
        if(buy == 1) {
            int bought = -prices[ind] + recursion(prices, ind + 1, 0);
            int notBought = 0 + recursion(prices, ind + 1, 1);

            profit = Math.max(bought, notBought);
        } else {
            int sold = prices[ind] + recursion(prices, ind + 2, 1);
            int notSold = 0 + recursion(prices, ind + 1, 0);

            profit = Math.max(sold, notSold);
        }

        return profit;
    }

    private int topDown(int[] prices, int ind, int buy, int[][] dp) {
        if(ind >= prices.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;
        if(buy == 1) {
            int bought = -prices[ind] + topDown(prices, ind + 1, 0, dp);
            int notBought = 0 + topDown(prices, ind + 1, 1, dp);

            profit = Math.max(bought, notBought);
        } else {
            int sold = prices[ind] + topDown(prices, ind + 2, 1, dp);
            int notSold = 0 + topDown(prices, ind + 1, 0, dp);

            profit = Math.max(sold, notSold);
        }

        dp[ind][buy] = profit;
        return dp[ind][buy];
    }

    private int bottomUp(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for(int ind = n - 1; ind >= 0; ind--) {
            for(int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if(buy == 1) {
                    int bought = -prices[ind] + dp[ind + 1][0];
                    int notBought = 0 + dp[ind + 1][1];

                    profit = Math.max(bought, notBought);
                } else {
                    int sold = prices[ind] + dp[ind + 2][1];
                    int notSold = 0 + dp[ind + 1][0];

                    profit = Math.max(sold, notSold);
                }

                dp[ind][buy] = profit;
            }
        }

        return dp[0][1];
    }
}
