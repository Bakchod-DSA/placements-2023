/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/minimum-size-subarray-sum/
 * Difficulty level : Medium
 */

package leetcode.SlidingWindow;

public class Problem209_MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        return approachOne(target, nums);

    }

    private int approachOne(int target, int[] nums) {
        // Brute Force
        // Time Complexity: O(n^2), Space Complexity: O(1)
        int ans = nums.length + 1;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return (ans != nums.length + 1)? ans : 0;
    }


    private int approachTwo(int target, int[] nums) {
        // Binary Search
        // Time Complexity: O(nlog(n)), Space Complexity: O(n)
        int len = nums.length;
        int ans = len + 1;

        // calculate prefix sum
        int[] prefixSum = new int[len + 1];
        for(int i = 1; i < len + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int ub = upperBound(prefixSum, target);
        // when no ub found
        if(ub == -1) {
            return 0;
        }

        for(int i = ub; i < len + 1; i++) {
            int j = lowerBound(prefixSum, prefixSum[i] - target);
            ans = Math.min(ans, i - j);
        }

        return ans;
    }

    private int upperBound(int[] prefixSum, int target) {
        // Time Complexity: O(log(n)), Space Complexity: O(1)
        int low = 0;
        int high = prefixSum.length - 1;
        while(low < high) {
            int mid = low + ((high - low) >> 1);

            if(prefixSum[mid] == target) {
                return mid;
            }else if(prefixSum[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // if no upper bound then low keeps on increasing until it goes to last index of array
        if(low == prefixSum.length - 1 && prefixSum[low] < target) return -1;
        return high;
    }

    private int lowerBound(int[] prefixSum, int target) {
        // Time Complexity: O(log(n)), Space Complexity: O(1)
        int low = 0;
        int high = prefixSum.length - 1;
        while(low < high) {
            int mid = high - ((high - low) >> 1);
            if(prefixSum[mid] == target) {
                return mid;
            } else if(prefixSum[mid] < target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        // if no lower bound then high keeps on decreasing until it goes to first index of array
        if(high == 0 && prefixSum[high] > target) return -1;
        return low;
    }


    private int approachThree(int target, int[] nums) {
        // Sliding Window
        // Time Complexity: O(n), Space Complexity: O(1)
        int k = nums.length;
        int sum = 0;

        for(int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j]; // add calculations

            // the case when sum of all the elements of array that is window size = nums.length
            // still sum < target means no possible window can make the sum >= target.
            if((i == 0) && (j == nums.length - 1) && (sum < target)) {
                return 0;
            }

            // once we reached the goal get the ans and try to slide window from start to see if any of the
            // smaller windoe can make up to the target
            while(sum >= target) {
                k = Math.min(k, j - i + 1);
                sum -= nums[i]; // remove calculations
                i++;
            }
        }

        return k;
    }
}
