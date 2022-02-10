package LeetCode.dynamivProgramming;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Difficulty level : Easy
 */
public class problem121_BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        // return bestTime(prices);
        return approachTwo(prices);
    }

    /**
     Khadane Algorithm
     Time  : O(N)
     Space : constant
     Algo  : We are keeping track of what maximumprofit we have till ith element
     e.g. prices = [7, 3, 6, 8, 1, 3, 9]
     dp = [0, 0, 3, 5, 0, 2, 8]
     In the jth step, it computes the subarray with the max profit ending at j in currMax
     Moreover, it computes the subarray with the largest sum anywhere in A[1 ... j] in maxSoFar
     */
    private int approachTwo(int[] prices) {
        int maxSoFar = 0;
        int currMax = 0;
        for (int i = 1; i < prices.length; i++) {
            currMax = Math.max(currMax + prices[i] - prices[i - 1], 0);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }

    /**
     Here, we are keeping track of values at which we brought and sold the stock
     profit is storing maximum profit we get i.e. lastSell - lastBuy, profit
     */
    private int bestTime(int[] prices) {
        int lastBuy = Integer.MAX_VALUE;
        int lastSell = -1;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lastBuy) {
                lastBuy = prices[i];
                lastSell = -1;
            }
            if (lastSell < prices[i]) {
                lastSell = prices[i];
                profit = Math.max(lastSell - lastBuy, profit);
            }
        }
        return profit;
    }
}
