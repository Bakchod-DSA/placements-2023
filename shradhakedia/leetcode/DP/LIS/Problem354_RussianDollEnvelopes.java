// https://leetcode.com/problems/russian-doll-envelopes/
package leetcode.DP.LIS;

import java.util.*;

public class Problem354_RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0])? b[1] - a[1] : a[0] - b[0]);

        // return getLISRecursion(envelopes, 0, -1);

        int n = envelopes.length;

        // int[][] dp = new int[n][n + 1];
        // for(int i = 0; i < n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return getLISTopDown(envelopes, 0, -1, dp);

        // return getLISBottomUp(envelopes);

        return getLISBinarySearch(envelopes);
    }

    private int getLISRecursion(int[][] envelopes, int ind, int prev) {
        // TLE
        if(ind == envelopes.length) return 0;

        int notPick = getLISRecursion(envelopes, ind + 1, prev);
        int pick = Integer.MIN_VALUE;
        if(prev == -1 || (envelopes[ind][0] != envelopes[prev][0] && envelopes[ind][1] > envelopes[prev][1])) {
            pick = 1 + getLISRecursion(envelopes, ind + 1, ind);
        }

        return Math.max(notPick, pick);
    }

    private int getLISTopDown(int[][] envelopes, int ind, int prev, int[][] dp) {
        // MLE
        if(ind == envelopes.length) return 0;
        if(dp[ind][prev + 1] != -1) return dp[ind][prev + 1];

        int notPick = getLISTopDown(envelopes, ind + 1, prev, dp);
        int pick = Integer.MIN_VALUE;
        if(prev == -1 || (envelopes[ind][0] != envelopes[prev][0] && envelopes[ind][1] > envelopes[prev][1])) {
            pick = 1 + getLISTopDown(envelopes, ind + 1, ind, dp);
        }

        return dp[ind][prev + 1] = Math.max(notPick, pick);
    }

    private int getLISBottomUp(int[][] envelopes) {
        // MLE
        int n = envelopes.length;
        int[][] dp = new int[n + 1][n + 1];

        for(int ind = n - 1; ind >= 0; ind--) {
            for(int prev = n - 1; prev >= -1; prev--) {
                int notPick = dp[ind + 1][prev + 1];
                int pick = Integer.MIN_VALUE;
                if(prev == -1 || (envelopes[ind][0] != envelopes[prev][0] && envelopes[ind][1] > envelopes[prev][1])) {
                    pick = 1 + dp[ind + 1][ind + 1];
                }

                dp[ind][prev + 1] = Math.max(notPick, pick);
            }
        }

        return dp[0][0];
    }

    private int getLISBinarySearch(int[][] envelopes) {
        // T.C: O(n logn)
        int n = envelopes.length;
        List<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);

        for(int i = 1; i < n; i++) {
            int ub = Collections.binarySearch(list, envelopes[i][1]);
            if(ub < 0) {
                int index = (-(ub) - 1);
                if(index == list.size()) {
                    list.add(envelopes[i][1]);
                } else {
                    list.set(index, envelopes[i][1]);
                }
            }
        }

        return list.size();
    }
}
