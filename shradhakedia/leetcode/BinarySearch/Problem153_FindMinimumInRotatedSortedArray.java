/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Difficulty level : Medium
 */

package leetcode.BinarySearch;

public class Problem153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        return approachOne(nums);
    }

    private int approachOne(int[] nums) {
        /*  Approach 1: BinarySearch;
            Time Complexity: O(log n),
            Space complexity: O(1)
            Intuition: Index of min element tells how much time the array is rotated, it is guaranteed that one of the two,
                       [low, mid] or [mid, high] both inclusive, is sorted while the other is not.
                       min element lies on the side of unsorted array.
                       property of mid: it is always less then both of its neighbors.
        */

        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {

            //  base cases when search space reduced to one and two elements.
            if(low == high) return nums[low];
            if(low + 1 == high) return Math.min(nums[low], nums[high]);

            int mid = low + ((high - low) >> 1);
            // either right or left part is sorted, min element lies on the part of unsorted array
            if(nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1]) {
                return nums[mid]; // min element found
            } else if(nums[mid] < nums[mid + 1] && nums[mid] < nums[high]) {
                // if right part is sorted we go on left part
                high = mid - 1;
            } else {
                // this case means right part was not sorted so we go on right part
                low = mid + 1;
            }
        }

        return -1;
    }

    private int approachTwo(int[] nums) {
        /*  Approach 2: BinarySearch;
            Time Complexity: O(log n),
            Space complexity: O(1)
        */

        int low = 0;
        int high = nums.length - 1;
        while(low < high) {

            int mid = low + ((high - low) >> 1);
            if(nums[mid] < nums[high]) {
                // minimum can be either this mid element, or something left to it. but, not right
                // as elements will be greater than mid there.
                high = mid;
            } else {
                // nums[mid] > nums[high] note: they can never be equal as the array contains unique.
                // minimum cannot be on the left side for sure, as its cyclically sorted array,
                // its for sure left parts are greater tan right parts. and mid can never be a candidate of min. so, go right.
                low = mid + 1;
            }
        }

        return nums[high];
    }
}
