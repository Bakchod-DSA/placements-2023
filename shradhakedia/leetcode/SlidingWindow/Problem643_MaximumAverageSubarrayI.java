/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/maximum-average-subarray-i/
 * Difficulty level : Easy
 */

package leetcode.SlidingWindow;

public class Problem643_MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {

        // Approach 1: Cumulative Sum; Time Complexity: O(n), Space Complexity: O(n)
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int max = sum[k - 1];
        for(int i = k; i < nums.length; i++) {
            max = Math.max(max, sum[i] - sum[i - k]);
        }
        return (double) max / k;

        /*
        // Approach 2: Sliding Window; Time Complexity: O(n), Space Complexity: O(1)
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            if(j - i + 1 == k) {
                max = Math.max(max, sum);
                sum -= nums[i++];
            }
        }
        return (double) max / k;
        */
    }
}
