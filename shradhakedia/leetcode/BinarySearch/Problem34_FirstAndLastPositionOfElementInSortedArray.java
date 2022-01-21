/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Difficulty level : Medium
 */

package leetcode.BinarySearch;

public class Problem34_FirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        return approachTwo(nums, target);
    }

    private int[] approachOne(int[] nums, int target) {
        // Approach 1: Two Pointers;
        // Time Complexity : O(n/2) in worst case, Space Complexity: O(1)

        int[] result = new int[]{-1, -1};
        for(int i = 0, j = nums.length - 1; i <= j; ) {
            if(nums[i] == target && nums[j] == target) {
                result[0] = i;
                result[1] = j;
                break;
            }
            if(nums[i] < target) {
                i++;
            }
            if(nums[j] > target) {
                j--;
            }
        }
        return result;
    }

    private int[] approachTwo(int[] nums, int target) {
        // Approach 2: Binary Search;
        // Time Complexity : O(2log n), Space Complexity: O(1)

        int first = findFirstOrLastOccurrence(nums, target, 0);
        return (first == -1)? new int[] {-1,-1} :  new int[] {first, findFirstOrLastOccurrence(nums, target, 1)};
    }

    private int findFirstOrLastOccurrence(int[] nums, int target, int type) {

        int ans  = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {

            int mid = low + ((high - low) >> 1);
            if(nums[mid] == target) {
                ans = mid;
                if(type == 0) {
                    // first occurence
                    high = mid - 1;
                }
                else {
                    // last occurence
                    low = mid + 1;
                }
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
