// https://leetcode.com/problems/longest-increasing-subsequence/
package leetcode.DP.LIS;

import java.util.*;

public class Problem300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // return recursion(nums, 0, -1);

//         int n = nums.length;
//         int[][] dp = new int[n][n + 1];
//         for(int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return topDown(nums, 0, -1, dp);

        return binarySearch(nums);
    }

    private int recursion(int[] nums, int ind, int prevInd) {
        if(ind == nums.length) return 0;

        int notPick = recursion(nums, ind + 1, prevInd);
        int pick = Integer.MIN_VALUE;
        if(prevInd == -1 || nums[prevInd] < nums[ind]) {
            pick = 1 + recursion(nums, ind + 1, ind);
        }

        return Math.max(notPick, pick);
    }

    private int topDown(int[] nums, int ind, int prevInd, int[][] dp) {
        if(ind == nums.length) return 0;
        if(dp[ind][prevInd + 1] != -1) return dp[ind][prevInd + 1];

        int notPick = topDown(nums, ind + 1, prevInd, dp);
        int pick = Integer.MIN_VALUE;
        if(prevInd == -1 || nums[prevInd] < nums[ind]) {
            pick = 1 + topDown(nums, ind + 1, ind, dp);
        }

        dp[ind][prevInd + 1] = Math.max(notPick, pick);
        return dp[ind][prevInd + 1];
    }

    private int bottomUp(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for(int ind = n - 1; ind >= 0; ind--) {
            for(int prevInd = ind - 1; prevInd >= -1; prevInd--) {
                int notPick = dp[ind + 1][prevInd + 1];
                int pick = Integer.MIN_VALUE;
                if(prevInd == -1 || nums[prevInd] < nums[ind]) {
                    pick = 1 + dp[ind + 1][ind + 1];
                }

                dp[ind][prevInd + 1] = Math.max(notPick, pick);
            }
        }

        return dp[0][0];
    }

    private int bottomUpSpaceOptimized(int[] nums) {
        int n = nums.length;
        int[] next = new int[n + 1];

        for(int ind = n - 1; ind >= 0; ind--) {
            int[] curr = new int[n + 1];
            for(int prevInd = ind - 1; prevInd >= -1; prevInd--) {
                int notPick = next[prevInd + 1];
                int pick = Integer.MIN_VALUE;
                if(prevInd == -1 || nums[prevInd] < nums[ind]) {
                    pick = 1 + next[ind + 1];
                }

                curr[prevInd + 1] = Math.max(notPick, pick);
            }

            next = curr;
        }

        return next[0];
    }

    private int binarySearch(int[] nums) {
        // T.C.: O(n log n)
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i = 1; i < nums.length; i++) {
            int ele = nums[i];
            int ind = upperBound(list, ele);
            if(ind == -1) list.add(ele);
            else list.set(ind, ele);
        }

        return list.size();
    }

    private int upperBound(List<Integer> list, int ele) {
        int low = 0, high = list.size() - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(list.get(mid) < ele) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (low == list.size() - 1 && list.get(low) < ele)? -1 : high;
    }

    private int bottomUpApproachTwo(int[] nums) {
        // used in printing LIS.

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        for(int i = 0; i < n; i++) {
            hash[i] = i;
        }

        for(int ind = 0; ind < n; ind++) {
            for(int prevInd = 0; prevInd < ind; prevInd++) {
                if(nums[ind] > nums[prevInd] && dp[ind] < 1 + dp[prevInd]) {
                    dp[ind] = 1 + dp[prevInd];
                    hash[ind] = prevInd;
                }
            }
        }

        // ans is len of LIS.
        int ans = 1, ind = 0;
        for(int i = 0; i < n; i++) {
            if(ans < dp[i]) {
                ans = dp[i];
                ind = i;
            }
        }

        System.out.println(printLIS(nums, hash, ind));
        return ans;
    }

    private List<Integer> printLIS(int[] nums, int[] hash, int ind) {
        List<Integer> lis = new ArrayList<>();
        while(hash[ind] != ind) {
            lis.add(nums[ind]);
            ind = hash[ind];
        }
        lis.add(nums[ind]);
        Collections.reverse(lis);
        return lis;
    }}
