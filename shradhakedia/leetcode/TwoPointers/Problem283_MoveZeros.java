/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/move-zeroes/
 * Difficulty level: Easy
 */

package leetcode.TwoPointers;

public class Problem283_MoveZeros {

    public void moveZeroes(int[] nums) {

        // Approach 1: Two Pointers
        for(int i = 0, j = 1; i < nums.length && j < nums.length; ) {
            if(nums[i] == 0 && nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
            } else if(nums[i] != 0) {
                i++;
                j++; // for sure j is not 0 here due to if condition above, so we increment it.
            } else if(nums[j] == 0) {
                j++;
            }
        }
    }
}

/**
 * Approach 1: Two Pointers; Time Complexity: O(n), Space Complexity: O(1)
 *             Intuition: we start with two pointers one at 0, the other at 1, we start iterating as soon as we get 0,
 *                        we swap it with j, if that's not 0. else we increment j if its 0.
 */

