// https://leetcode.com/problems/paint-house-iii/
package leetcode.DP;

public class Problem1473_PaintHouseIII {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        Integer[][][] dp = new Integer[m][target + 1][n + 1];

        int ans = topDown(houses, cost, target, 0, 0, 0, dp);
        return ans == (int) 1e9? -1 : ans;
    }

    private int recursion(int[] houses, int[][] cost, int target, int ind, int nbdCount, int prevColor) {
        if(ind == houses.length) {
            return nbdCount == target? 0 : (int) 1e9;
        }
        if(nbdCount > target) {
            return (int) 1e9;
        }

        int minCost = (int) 1e9;
        if(houses[ind] != 0) {
            nbdCount = nbdCount + (houses[ind] != prevColor? 1 : 0);
            minCost = recursion(houses, cost, target, ind + 1, nbdCount, houses[ind]);
        } else {
            int totalColors = cost[0].length;
            for(int clr = 1; clr <= totalColors; clr++) {
                int newNbdCount = nbdCount + (clr != prevColor? 1 : 0);
                int currCost = cost[ind][clr - 1] + recursion(houses, cost, target, ind + 1, newNbdCount, clr);
                minCost = Math.min(minCost, currCost);
            }
        }

        return minCost;
    }

    private int topDown(int[] houses, int[][] cost, int target, int ind, int nbdCount, int prevColor, Integer[][][] dp) {
        if(ind == houses.length) {
            return nbdCount == target? 0 : (int) 1e9;
        }
        if(nbdCount > target) {
            return (int) 1e9;
        }
        if(dp[ind][nbdCount][prevColor] != null) return dp[ind][nbdCount][prevColor] ;

        int minCost = (int) 1e9;
        if(houses[ind] != 0) {
            int newNbdCount = nbdCount + (houses[ind] != prevColor? 1 : 0);
            minCost = topDown(houses, cost, target, ind + 1, newNbdCount, houses[ind], dp);
        } else {
            int totalColors = cost[0].length;
            for(int clr = 1; clr <= totalColors; clr++) {
                int newNbdCount = nbdCount + (clr != prevColor? 1 : 0);
                int currCost = cost[ind][clr - 1] + topDown(houses, cost, target, ind + 1, newNbdCount, clr, dp);
                minCost = Math.min(minCost, currCost);
            }
        }

        dp[ind][nbdCount][prevColor] = minCost;
        return dp[ind][nbdCount][prevColor] ;
    }
}
