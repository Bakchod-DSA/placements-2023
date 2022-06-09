/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Difficulty level: Medium
 */
package leetcode.Array;

public class Problem121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        /*  Approach: Array Intuitive
            Time Complexity: O(n)
            Space complexity: O(1)
        */
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
}
