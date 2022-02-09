package LeetCode.dynamivProgramming;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/maximum-subarray/
 * Difficulty level : Easy
 */
public class problem53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        return approachOne(nums);
    }

    /**
     Kadane Algorithm
     Time  : O(N)
     Space : constant
     Algo  : We are trying to find max sum of sub-array till ith index if we include ith index element to our sub-array
     e.g. nums = [-2, 1,-3, 4,-1, 2, 1,-5, 4]
     dp = [-2, 1,-2, 4, 3, 5, 6, 1, 5]
     if max sum till (i - 1)th element + ith element > ith element hat means including previous
     elements will increase our maxSum, otherwise,
     addying previous sub-array sum will only reduce curr sub-array sum,
     hence we will not include previous sum (when we go from -3 to 4 -> prev Sum was -2
     but only 4 can provide sum greater thn addying previous sum to current element
     hence its better to have a subarray having element 4 only instead of array having max sum as -2 + 4 = 2)
     */
    public int approachOne(int[] nums) {

        int maxSum = nums[0];
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prev = Math.max(prev + nums[i], nums[i]);
            maxSum = Math.max(prev, maxSum);
        }
        return maxSum;
    }
}
