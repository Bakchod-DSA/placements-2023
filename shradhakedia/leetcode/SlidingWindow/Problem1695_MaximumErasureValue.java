/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/maximum-erasure-value/
 * Difficulty level: Medium
 */
package leetcode.SlidingWindow;

import java.util.*;

public class Problem1695_MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        int slow, fast, sum = 0, maxSum = 0;
        for(slow = 0, fast = 0; fast < nums.length; fast++) {
            if(numToIndex.containsKey(nums[fast])) {
                int lastSeenIndex = numToIndex.get(nums[fast]);
                while(slow <= lastSeenIndex) {
                    numToIndex.remove(nums[slow]);
                    sum -= nums[slow];
                    slow++;
                }
            }
            sum += nums[fast];
            maxSum = Math.max(maxSum, sum);
            numToIndex.put(nums[fast], fast);
        }

        return maxSum;
    }


    private int findSum(int[] nums, int start, int end) {
        int sum = 0;
        for(int i = start; i < end; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
