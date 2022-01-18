/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/remove-element/
 * Difficulty level: Easy
 */


package leetcode.TwoPointers;

public class Problem27_RemoveElement {
    public int removeElement(int[] nums, int val) {

        /*
        // Approach 1: Two Pointers
        int i, j;
        for(i = 0, j = nums.length - 1; i <= j; ) {
            if(nums[i] == val) {
                if(nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
                j--;
            } else {
                i++;
            }
        }
        return i;
        */

        // Approach 2: Brute Force
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}

/**
 * Approach 1: Two Pointers; Time Complexity: O(n), Space Complexity: O(1)
 * Approach 2: Brute Force; Time Complexity: O(n), Space Complexity: O(1)
 */
