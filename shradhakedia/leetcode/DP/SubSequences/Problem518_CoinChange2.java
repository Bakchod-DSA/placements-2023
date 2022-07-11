// https://leetcode.com/problems/coin-change-2/

package leetcode.DP.SubSequences;

public class Problem518_CoinChange2 {
    public int change(int amount, int[] coins) {
        // return recursion(coins, coins.length - 1, amount);

//         int n = coins.length;
//         int[][] dp = new int[n][amount + 1];
//         for(int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return topDown(coins, n - 1, amount, dp);

        return bottomUp(coins, amount);
    }

    private int recursion(int[] coins, int ind, int amt) {
        if(ind == 0) {
            if(amt % coins[0] == 0) return 1;
            return 0;
        }

        int notPick = recursion(coins, ind - 1, amt);
        int pick = 0;
        if(amt >= coins[ind]) pick = recursion(coins, ind, amt - coins[ind]);

        return pick + notPick;
    }

    private int topDown(int[] coins, int ind, int amt, int[][] dp) {
        if(ind == 0) {
            if(amt % coins[0] == 0) return 1;
            return 0;
        }
        if(dp[ind][amt] != -1) return dp[ind][amt];

        int notPick = topDown(coins, ind - 1, amt, dp);
        int pick = 0;
        if(amt >= coins[ind]) pick = topDown(coins, ind, amt - coins[ind], dp);

        dp[ind][amt] = pick + notPick;
        return dp[ind][amt];
    }

    private int bottomUp(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for(int amt = 0; amt <= amount; amt++) {
            if(amt % coins[0] == 0) dp[0][amt] = 1;
            else dp[0][amt] = 0;
        }

        for(int ind = 1; ind < n; ind++) {
            for(int amt = 0; amt <= amount; amt++) {
                int notPick = dp[ind - 1][amt];
                int pick = 0;
                if(amt >= coins[ind]) pick = dp[ind][amt - coins[ind]];

                dp[ind][amt] = pick + notPick;
            }
        }

        return dp[n - 1][amount];
    }
}
