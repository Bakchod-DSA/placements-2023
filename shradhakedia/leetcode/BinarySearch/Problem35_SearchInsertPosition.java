/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/search-insert-position/
 * Difficulty level : Easy
 */

package leetcode.BinarySearch;

public class Problem35_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        return upperBound(nums, target);
    }

    private int upperBound(int[] nums, int target) {
        // Approach 1: Binary Search
        // Time Complexity: O(log(n)), Space Complexity: O(1)
        int low = 0;
        int high = nums.length - 1;

        while(low < high) {
            int mid = low + ((high - low) >> 1);
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // the case when high + 1 is to be returned is when there was no upper bound of target; array = [1,3,5,6], target: 7
        return (high == nums.length - 1 && nums[high] < target)? high + 1 : high;

    }
}
