/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 * Difficulty level: Medium
 */
package leetcode.HashTable;

import java.util.*;

public class Problem1658_MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        return approachOne(nums, x);
    }

    private int approachOne(int[] nums, int x) {
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        totalSum -= x;
        if(totalSum == 0) return nums.length;

        int len = maximumLengthSubarraySumWithK(nums, totalSum);

        return (len == -1)? -1 : nums.length - len;
    }

    private int maximumLengthSubarraySumWithK(int[] nums, int target) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();

        int n = nums.length;
        for(int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        // if no subarray exists len is -1.
        int maxLength = -1;
        for(int i = 0; i < n; i++) {
            if(nums[i] == target) {
                maxLength = i + 1;
            } else {
                if(sumToIndex.containsKey(nums[i] - target)) {
                    maxLength = Math.max(maxLength, i - sumToIndex.get(nums[i] - target));
                }
            }

            if(!sumToIndex.containsKey(nums[i])) {
                sumToIndex.put(nums[i], i);
            }
        }

        return maxLength;
    }
}
