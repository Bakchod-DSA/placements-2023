package LeetCode.binarySearch;

/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * Difficulty level : Medium
 */
public class problem_0154_find_minimum_in_rotated_sorted_array_II {
    public int findMin(int[] nums) {
        int index =  findRotation(nums);
        return nums[index];

    }
    // To find rotations
    private int findRotation(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                for (int i = low; i < high; i++) {
                    if (nums[i] > nums[i + 1]) {
                        return i + 1;
                    }
                }
                return low;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;

    }
}
