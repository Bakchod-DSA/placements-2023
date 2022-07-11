// https://leetcode.com/problems/coin-change/

package leetcode.DP.SubSequences;

public class Problem322_MinimumCoins {
    public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int[][] dp = new int[n][amount + 1];
//         for(int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         int minCoins =  topDown(coins, coins.length - 1, amount, dp);
//         if(minCoins >= (int) 1e9) return -1;
//         return minCoins;

        return bottomUp(coins, amount);
    }

    private int recursion(int[] coins, int ind, int amt) {
        if(ind == 0) {
            if(amt % coins[0] == 0) return amt / coins[0];
            return (int) 1e9;
        }

        int notPick = recursion(coins, ind - 1, amt);
        int pick = Integer.MAX_VALUE;
        if(coins[ind] <= amt) pick = 1 + recursion(coins, ind, amt - coins[ind]);

        return Math.min(pick, notPick);
    }

    private int topDown(int[] coins, int ind, int amt, int[][] dp) {
        if(ind == 0) {
            if(amt % coins[0] == 0) return amt / coins[0];
            return (int) 1e9;
        }
        if(dp[ind][amt] != -1) return dp[ind][amt];

        int notPick = topDown(coins, ind - 1, amt, dp);
        int pick = Integer.MAX_VALUE;
        if(coins[ind] <= amt) pick = 1 + topDown(coins, ind, amt - coins[ind], dp);

        dp[ind][amt] = Math.min(pick, notPick);
        return dp[ind][amt];
    }

    private int bottomUp(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for(int amt = 0; amt <= amount; amt++) {
            if(amt % coins[0] == 0) dp[0][amt] = amt / coins[0];
            else dp[0][amt] = (int) 1e9;
        }

        for(int ind = 1; ind < n; ind++) {
            for(int amt = 0; amt <= amount; amt++) {
                int notPick = dp[ind - 1][amt];
                int pick = Integer.MAX_VALUE;
                if(coins[ind] <= amt) pick = 1 + dp[ind][amt - coins[ind]];

                dp[ind][amt] = Math.min(notPick, pick);
            }
        }

        int minCoins = dp[n - 1][amount];
        if(minCoins >= (int) 1e9) return -1;
        return minCoins;
    }
}
