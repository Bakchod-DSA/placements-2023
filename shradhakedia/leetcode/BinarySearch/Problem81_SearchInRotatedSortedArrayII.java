/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * Difficulty level : Medium
 */

package leetcode.BinarySearch;

public class Problem81_SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        return approachOne(nums, target);
    }

    private boolean approachOne(int[] nums, int target) {
        /* same as approach 1 of problem 33. Search in Rotated Sorted Array
           only difference is to skip low, high if they are equal to mid
           Approach: Binary Search
           Time Complexity: O(log(n)) best case, O(n) worst case; Space Complexity: O(1)
        */

        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);

            if(nums[mid] == target) {
                return true;
            }

            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high --;
            } else if(nums[mid] <= nums[high]) {
                if(target < nums[mid]) {
                    high = mid - 1;
                } else if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                } else if(target > nums[mid] && target > nums[high]) {
                    high = mid - 1;

                }
            } else {  // nums[mid] > nums[high]
                if(target > nums[mid]) {
                    low = mid + 1;
                } else if(target < nums[mid] && target <= nums[high]){
                    low = mid + 1;
                } else if(target < nums[mid] && target > nums[high]) {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    private boolean approachTwo(int[] nums, int target) {
        /* Approach: Binary Search
           Time Complexity: O(2n) in worst case {O(n) to find number of rotations},
                            O(log n) in best case {when all unique elements}.
           Space Complexity: O(1)
        */
        int rot = numberOfRotation(nums);
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int calculatedMid = low + ((high - low) >> 1);
            int realMid = (calculatedMid + rot) % nums.length;

            if(nums[realMid] < target) {
                low = calculatedMid + 1;
            } else if(nums[realMid] == target) {
                return true;
            } else { //nums[realMid] > target
                high = calculatedMid - 1;
            }
        }
        return false;
    }

    private int numberOfRotation(int[] nums) {
        /* Approach: Binary Search
           Time Complexity: O(n) in worst case, O(log n) in best case(when all unique elements)
           Space Complexity: O(1)
        */

        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = low + ((high - low) >> 1);

            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                int flag = -1;
                for(int i = low; i < mid; i++) {
                    // check if left part is unsorted.
                    if(nums[i] > nums[i + 1]) {
                        flag = 0;
                        break;
                    }
                }
                for(int i = mid; i < high; i++) {
                    // left part was unsorted, this makes sure right part is sorted
                    if(flag == 0) {
                        break;
                    }
                    // check if right part is unsorted.
                    if(nums[i] > nums[i + 1]) {
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0) {
                    high = mid;
                } else if(flag == 1) {
                    low = mid + 1;
                } else {
                    return low;
                }
            }
            else if(nums[mid] <= nums[high]) {
                high = mid;
            } else { // nums[mid] > nums[high]
                low = mid + 1;
            }
        }
        return high;
    }
}