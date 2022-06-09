/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/house-robber-ii/
 * Difficulty level: Medium
 */
package leetcode.DP;

import java.util.Arrays;

public class Problem213_HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] excludeFirstHouse = Arrays.copyOfRange(nums, 1, n);
        int[] excludeLastHouse = Arrays.copyOfRange(nums, 0, n - 1);
        return Math.max(robNonCircularHouse(excludeFirstHouse), robNonCircularHouse(excludeLastHouse));
    }

    private int robNonCircularHouse(int[] nums) {
        /*  House Robber 1
            Approach: tabulation (bottom up), optimized in space
            Time Complexity: O(n)
            Space Complexity: O(1)
        */
        int n = nums.length;
        if(n == 1) return nums[0];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
