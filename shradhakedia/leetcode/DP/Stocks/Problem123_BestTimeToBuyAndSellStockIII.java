// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
package leetcode.DP.Stocks;

public class Problem123_BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        // return recursion(prices, 0, 1, 2);

//         int n = prices.length;
//         int[][][] dp = new int[n][2][3];
//         for(int i = 0; i < n; i++) {
//             Arrays.fill(dp[i][0], -1);
//             Arrays.fill(dp[i][1], -1);
//         }

        // return topDown(prices, 0, 1, 2, dp);

        // return bottomUp(prices);

        return bottomUpSpaceOptimized(prices);
    }

    private int recursion(int[] prices, int ind, int buy, int cap) {
        if(cap == 0) return 0;
        if(ind == prices.length) return 0;

        int profit = 0;
        if(buy == 1) {
            int bought = -prices[ind] + recursion(prices, ind + 1, 0, cap);
            int notBought = 0 + recursion(prices, ind + 1, 1, cap);

            profit = Math.max(bought, notBought);
        } else {
            int sold = prices[ind] + recursion(prices, ind + 1, 1, cap - 1);
            int notSold = 0 + recursion(prices, ind + 1, 0, cap);

            profit = Math.max(sold, notSold);
        }

        return profit;
    }

    private int topDown(int[] prices, int ind, int buy, int cap, int[][][] dp) {
        if(cap == 0) return 0;
        if(ind == prices.length) return 0;

        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];

        int profit = 0;
        if(buy == 1) {
            int bought = -prices[ind] + topDown(prices, ind + 1, 0, cap, dp);
            int notBought = 0 + topDown(prices, ind + 1, 1, cap, dp);

            profit = Math.max(bought, notBought);
        } else {
            int sold = prices[ind] + topDown(prices, ind + 1, 1, cap - 1, dp);
            int notSold = 0 + topDown(prices, ind + 1, 0, cap, dp);

            profit = Math.max(sold, notSold);
        }

        dp[ind][buy][cap] = profit;
        return dp[ind][buy][cap];
    }

    private int bottomUp(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for(int ind = 0; ind <= n; ind++) {
            for(int buy = 0; buy <= 1; buy++) {
                // base case analogous to topDown: if(cap == 0) return 0;
                dp[ind][buy][0] = 0;
            }
        }

        for(int buy = 0; buy <= 1; buy++) {
            for(int cap = 0; cap <= 2; cap++) {
                // base case analogous to topDown: if(ind == prices.length) return 0;
                dp[n][buy][cap] = 0;
            }
        }

        int profit = 0;
        for(int ind = n - 1; ind >= 0; ind--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= 2; cap++) {
                    if(buy == 1) {
                        int bought = -prices[ind] + dp[ind + 1][0][cap];
                        int notBought = 0 + dp[ind + 1][1][cap];

                        profit = Math.max(bought, notBought);
                    } else {
                        int sold = prices[ind] + dp[ind + 1][1][cap - 1];
                        int notSold = 0 + dp[ind + 1][0][cap];

                        profit = Math.max(sold, notSold);
                    }

                    dp[ind][buy][cap] = profit;
                }
            }
        }

        return dp[0][1][2];
    }

    private int bottomUpSpaceOptimized(int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][3];
        int[][] curr = new int[2][3];

        for(int buy = 0; buy <= 1; buy++) {
            // base case analogous to topDown: if(cap == 0) return 0;
            ahead[buy][0] = 0;
        }

        for(int buy = 0; buy <= 1; buy++) {
            for(int cap = 0; cap <= 2; cap++) {
                // base case analogous to topDown: if(ind == prices.length) return 0;
                ahead[buy][cap] = 0;
            }
        }

        int profit = 0;
        for(int ind = n - 1; ind >= 0; ind--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= 2; cap++) {
                    if(buy == 1) {
                        int bought = -prices[ind] + ahead[0][cap];
                        int notBought = 0 + ahead[1][cap];

                        profit = Math.max(bought, notBought);
                    } else {
                        int sold = prices[ind] + ahead[1][cap - 1];
                        int notSold = 0 + ahead[0][cap];

                        profit = Math.max(sold, notSold);
                    }

                    curr[buy][cap] = profit;
                }
            }

            ahead = curr;
        }

        return ahead[1][2];
    }


}
