// https://leetcode.com/problems/largest-divisible-subset/
package leetcode.DP.LIS;

import java.util.*;

public class Problem368_LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        for(int i = 0; i < n; i++) {
            hash[i] = i;
        }

        int maxLen = 1, index = 0;
        for(int ind = 1; ind < n; ind++) {
            for(int prev = 0; prev < ind; prev++) {
                if(nums[ind] % nums[prev] == 0 && dp[ind] < 1 + dp[prev]) {
                    dp[ind] = 1 + dp[prev];
                    hash[ind] = prev;
                }
            }
            if(maxLen < dp[ind]) {
                maxLen = dp[ind];
                index = ind;
            }
        }

        return getLDS(nums, hash, index);
    }

    private List<Integer> getLDS(int[] nums, int[] hash, int index) {
        List<Integer> ans = new ArrayList<>();
        while(index != hash[index]) {
            ans.add(nums[index]);
            index = hash[index];
        }
        ans.add(nums[index]);

        return ans;
    }
}
