// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
package leetcode.DP.Stocks;

public class Problem121_BestTimeToBuyAnsSellStock {
    public int maxProfit(int[] prices) {
        return dp(prices);
    }

    private int approachOne(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > buy) {
                profit = Math.max(prices[i] - buy, profit);
            } else {
                buy = prices[i];
            }
        }
        return profit;
    }

    private int dp(int[] prices) {
        int profit = 0;
        int minBuy = prices[0];

        for(int i = 1; i < prices.length; i++) {
            int cost = prices[i];
            profit = Math.max(profit, cost - minBuy);
            minBuy = Math.min(minBuy, cost);
        }

        return profit;
    }
}
