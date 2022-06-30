/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 * Difficulty level: Medium
 */
package leetcode.BinarySearch;

public class Problem1283_FindTheSmallestDivisorGivenAThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int high = findMax(nums);
        int smallestDivisor = binarySearch(nums, high, threshold);
        return smallestDivisor;
    }

    private int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    private int binarySearch(int[] nums, int high, int threshold) {
        int low = 1;

        while(low < high) {
            int mid = low + (high - low)/2;
            int sum = findSum(nums, mid);
            if(sum <= threshold) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    private int findSum(int[] nums, int mid) {
        int sum = 0;
        for(int num : nums) {
            sum += Math.ceil((double) num/mid);
        }
        return sum;
    }
}
