/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/minimum-size-subarray-sum/
 * Difficulty level: Medium
 */
package leetcode.BinarySearch;

public class Problem209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        return approachTwo(target, nums);
    }

    private int approachTwo(int target, int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for(int i = 1; i < n + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int ub = upperBound(prefixSum, target);
        if(ub == -1) return 0;

        int ws = Integer.MAX_VALUE;
        for(int i = ub; i < n + 1; i++) {
            int lb = lowerBound(prefixSum, prefixSum[i] - target);
            ws = Math.min(ws, i - lb);
        }
        return ws;
    }

    private int upperBound(int[] prefixSum, int target) {
        int low = 0, high = prefixSum.length - 1;
        while(low < high) {
            int mid = low + (high - low)/2;
            if(prefixSum[mid] < target) {
                low = mid + 1;
            } else if(prefixSum[mid] == target) {
                return mid;
            } else {
                high = mid;
            }
        }

        return (low == prefixSum.length - 1 && prefixSum[low] < target)? -1 : high;
    }

    private int lowerBound(int[] prefixSum, int target) {
        int low = 0, high = prefixSum.length - 1;
        while(low < high) {
            int mid = high - (high - low)/2;
            if(prefixSum[mid] < target) {
                low = mid;
            } else if(prefixSum[mid] == target) {
                return mid;
            } else {
                high = mid - 1;
            }
        }

        return (high == 0 && prefixSum[high] > target)? -1 : low;
    }
}
