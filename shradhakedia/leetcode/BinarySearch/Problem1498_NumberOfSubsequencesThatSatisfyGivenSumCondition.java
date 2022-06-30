/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
 * Difficulty level : Medium
 */
package leetcode.BinarySearch;

import java.util.Arrays;

public class Problem1498_NumberOfSubsequencesThatSatisfyGivenSumCondition {
    public int numSubseq(int[] nums, int target) {
        return approachOne(nums, target);
    }

    private int approachOne(int[] nums, int target) {
        /*  Approach: Sorting + Binary Search
            Time Complexity: O(n logn)
            Space Complexity: O(n), for pow
        */

        Arrays.sort(nums);
        int n = nums.length;

        // precompute 2 power
        int mod = (int) 1e9 + 7;
        int[] pow = new int[n];
        pow[0] = 1;
        for(int i = 1; i < n; i++) {
            pow[i] = (2 * pow[i - 1]) % mod;
        }

        // compute no. of sequences
        int res = 0;
        for(int i = 0; i < n; i++) {
            int j = lowerBound(nums, i, target - nums[i]);
            if(j != -1) {
                res = (res + pow[j - i]) % mod;
            }
        }

        return res;
    }

    private int lowerBound(int[] nums, int start, int target) {
        int low = start, high = nums.length - 1;
        while(low < high) {
            int mid = high - (high - low)/2;
            if(nums[mid] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        if(high == start && nums[high] > target) return -1;
        return low;
    }

}
