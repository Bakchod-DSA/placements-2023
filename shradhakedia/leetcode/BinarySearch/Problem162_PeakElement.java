/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-peak-element/
 * Difficulty level : Medium
 */

package leetcode.BinarySearch;

public class Problem162_PeakElement {

    public int findPeakElement(int[] nums) {
        return approachOne(nums);
    }

    private int approachOne(int[] nums) {
        // Approach 1: Binary Search;
        // Time Complexity: O(log n), Space Complexity: O(1)
        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = low + ((high - low) >> 1);
            if(nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
