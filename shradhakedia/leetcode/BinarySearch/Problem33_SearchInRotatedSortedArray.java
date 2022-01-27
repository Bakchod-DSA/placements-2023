/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Difficulty level : Medium
 */

package leetcode.BinarySearch;

public class Problem33_SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        return approachOne(nums, target);
    }

    private int approachOne(int[] nums, int target) {
        /*  Approach 1: BinarySearch;
            Time Complexity: O(log n),
            Space complexity: O(1)
        */

        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + ((high  - low) >> 1);

            if(nums[mid] < nums[high]) {
                if(target < nums[mid]) {
                    high = mid - 1;
                } else if(target == nums[mid]){
                    return mid;
                } else {
                    if(target > nums[high]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            } else {
                // nums[mid] > nums[high]
                // # note: since, distinct elements, can never be equal.
                if(target > nums[mid]) {
                    low = mid + 1;
                } else if(target == nums[mid]){
                    return mid;
                } else {
                    if(target > nums[high]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }

        return -1;
    }

    private int approachTwo(int[] nums, int target) {
        /*  Approach 2: BinarySearch;
            Time Complexity: O(2log n),
            Space complexity: O(1)
        */

        int rotation = findNumberOfRotations(nums);
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int calculatedMid = low + ((high - low) >> 1);
            int realMid = (calculatedMid + rotation) % nums.length;

            if(nums[realMid] < target) {
                low = calculatedMid + 1;
            } else if(nums[realMid] == target) {
                return realMid;
            } else {
                high = calculatedMid - 1;
            }
        }
        return -1;
    }

    private int findNumberOfRotations(int[] nums) {
        /*  Approach: BinarySearch;
            Time Complexity: O(log n),
            Space complexity: O(1)
        */

        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = low + ((high - low) >> 1);
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            } else { // nums[mid] > nums[high]
                high = mid;
            }
        }

        // low == high
        return high;

    }
}
