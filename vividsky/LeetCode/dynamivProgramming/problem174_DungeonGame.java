package LeetCode.dynamivProgramming;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/dungeon-game/
 * Difficulty level : Hard
 */
public class problem174_DungeonGame {
    int[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        dp = new int[dungeon.length][dungeon[0].length];

        int minHealthReq = minimumHealth(dungeon, 0, 0);
        return minHealthReq <= 0 ? 1 : minHealthReq;

    }

    private int minimumHealth(int[][] dungeon, int r, int c) {
        if (r >= dungeon.length || c >= dungeon[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        if (r == dungeon.length - 1 && c == dungeon[0].length - 1) {
            if (dungeon[r][c] <= 0) {
                dp[r][c] = 1 - dungeon[r][c];
            } else {
                dp[r][c] = 1;
            }
        }
        else {
            int curr = dungeon[r][c];
            int down = minimumHealth(dungeon, r + 1, c);
            int right =  minimumHealth(dungeon, r, c + 1);
            int min = Math.min(down, right);
            if (min - curr <= 0) {
                dp[r][c] = 1;
            } else {
                dp[r][c] = min - curr;
            }
        }
        return dp[r][c];
    }
}
