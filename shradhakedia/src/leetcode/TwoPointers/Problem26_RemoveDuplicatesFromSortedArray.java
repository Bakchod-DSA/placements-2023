/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Difficulty level: Easy
 */

package leetcode.TwoPointers;

public class Problem26_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        // Approach: 2 pointers, till we get duplicates we move forward
        // as we get a new number we put it at kth index and change i to that new num location to check further duplicates
        int k = 1;
        for(int i = 0, j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                nums[k++] = nums[j];
                i = j;
            }
        }
        return k;
    }
}
