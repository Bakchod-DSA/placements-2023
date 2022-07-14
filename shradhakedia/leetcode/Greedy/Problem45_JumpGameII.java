// https://leetcode.com/problems/jump-game-ii/
package leetcode.Greedy;

public class Problem45_JumpGameII {
    public int jump(int[] nums) {
        // return recursion(nums, 0);

        // int n = nums.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        // return topDown(nums, 0, dp);

        return greedy(nums);
    }

    private int recursion(int[] nums, int ind) {
        if(ind >= nums.length - 1) return 0;

        int k = nums[ind], mini = (int) 1e7;
        for(int i = 0; i < Math.min(k, nums.length); i++) {
            mini = Math.min(mini, 1 + recursion(nums, ind + i + 1));
        }

        return mini;
    }

    private int topDown(int[] nums, int ind, int[] dp) {
        if(ind >= nums.length - 1) return 0;
        if(dp[ind] != -1) return dp[ind];

        int k = nums[ind];
        dp[ind] = (int) 1e7;
        for(int i = 0; i < Math.min(k, nums.length); i++) {
            dp[ind] = Math.min(dp[ind], 1 + topDown(nums, ind + i + 1, dp));
        }

        return dp[ind];
    }

    private int greedy(int[] nums) {
        int n = nums.length, op = 1;
        if(n == 1) return 0;

        int i = 0, start = 1;
        while(true) {
            if(nums[i] + i >= n - 1) return op;

            int maxJump = 0, next = 0;
            while(start <= nums[i] + i) {
                if(maxJump < nums[start] + start) {
                    maxJump = start + nums[start];
                    next = start;
                }
                start++;
            }
            start = nums[i] + i + 1;
            i = next;
            op++;
        }
    }
}
