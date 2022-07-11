// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
package leetcode.DP.Stocks;

public class Problem714_BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        // return recursion(prices, fee, 0, 1);

        // int n = prices.length;
        // int[][] dp = new int[n][2];
        // for(int i = 0; i < n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return topDown(prices, fee, 0, 1, dp);

        // return bottomUp(prices, fee);

        return bottomUpSpaceOptimized(prices, fee);

    }

    private int recursion(int[] prices, int fee, int ind, int buy) {
        if(ind >= prices.length) return 0;

        int profit = 0;
        if(buy == 1) {
            int bought = -prices[ind] + recursion(prices, fee, ind + 1, 0);
            int notBought = 0 + recursion(prices, fee, ind + 1, 1);

            profit = Math.max(bought, notBought);
        } else {
            int sold = prices[ind] -fee + recursion(prices, fee, ind + 1, 1);
            int notSold = 0 + recursion(prices, fee, ind + 1, 0);

            profit = Math.max(sold, notSold);
        }

        return profit;
    }

    private int topDown(int[] prices, int fee, int ind, int buy, int[][] dp) {
        if(ind >= prices.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;
        if(buy == 1) {
            int bought = -prices[ind] + topDown(prices, fee, ind + 1, 0, dp);
            int notBought = 0 + topDown(prices, fee, ind + 1, 1, dp);

            profit = Math.max(bought, notBought);
        } else {
            int sold = prices[ind] - fee + topDown(prices, fee, ind + 1, 1, dp);
            int notSold = 0 + topDown(prices, fee, ind + 1, 0, dp);

            profit = Math.max(sold, notSold);
        }

        dp[ind][buy] = profit;
        return dp[ind][buy];
    }

    private int bottomUp(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for(int ind = n - 1; ind >= 0; ind--) {
            for(int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if(buy == 1) {
                    int bought = -prices[ind] + dp[ind + 1][0];
                    int notBought = 0 + dp[ind + 1][1];

                    profit = Math.max(bought, notBought);
                } else {
                    int sold = prices[ind] - fee + dp[ind + 1][1];
                    int notSold = 0 + dp[ind + 1][0];

                    profit = Math.max(sold, notSold);
                }

                dp[ind][buy] = profit;
            }
        }

        return dp[0][1];
    }

    private int bottomUpSpaceOptimized(int[] prices, int fee) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] curr = new int[2];

        for(int ind = n - 1; ind >= 0; ind--) {
            for(int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if(buy == 1) {
                    int bought = -prices[ind] + ahead[0];
                    int notBought = 0 + ahead[1];

                    profit = Math.max(bought, notBought);
                } else {
                    int sold = prices[ind] - fee + ahead[1];
                    int notSold = 0 + ahead[0];

                    profit = Math.max(sold, notSold);
                }

                curr[buy] = profit;
            }

            ahead = curr;
        }

        return ahead[1];
    }
}
