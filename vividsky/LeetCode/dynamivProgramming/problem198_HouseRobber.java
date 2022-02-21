package LeetCode.dynamivProgramming;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/house-robber/
 * Difficulty level : Medium
 */
public class problem198_HouseRobber {
    public int rob(int[] nums) {

        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);

        return rob2(cache, nums, nums.length - 1);
    }

    /**
     Top-Down DP
     Time : O(N) linear to fill cache array + N recursive calls
     (where work is done in constant time i.e. finding max values in each recursive call)
     Space : O(N) + recursive stack
     cache memory to store previous optimal results to avoid time complexity for solving repeated sub                 problems
     Algo : keep a track of optimal values for last two houses,
     calculate optimal value for current house
     */
    public int rob2(int[] cache, int[] nums, int idx) {

        if (idx == 0) return nums[0];
        if (idx == 1) return Math.max(nums[0], nums[1]);

        if (cache[idx - 1] == -1)
            cache[idx - 1] = rob2(cache, nums, idx - 1);

        if (cache[idx - 2] == -1)
            cache[idx - 2] = rob2(cache, nums, idx - 2);


        return Math.max(cache[idx - 2] + nums[idx], cache[idx - 1]);

    }

    /**
     Bottom-Up DP
     Time : O(N)
     Space : constant (only two variables to store last two optimal values)
     Algo : keep a track of optimal values for last two houses,
     calculate optimal value for current house
     */
    private int rob1(int[] nums) {

        if (nums.length == 1) return nums[0];

        int one = nums[0];
        int two = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = one;
            one = two;
            two =  Math.max(temp + nums[i], two);
        }
        return two;
    }
}
