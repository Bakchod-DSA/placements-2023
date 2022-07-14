// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
package leetcode.Greedy;

public class Problem122_BestTimeToBuyAndSellStock {
    private int greedy(int[] prices) {
        int n = prices.length, profit = 0;
        for(int i = 0; i < n; i++) {
            while(i + 1 < n && prices[i + 1] < prices[i]) {
                i++;
            }
            int buy = prices[i];
            while(i + 1 < n && prices[i + 1] > prices[i]) {
                i++;
            }
            profit += (prices[i] - buy);
        }

        return profit;
    }
}
