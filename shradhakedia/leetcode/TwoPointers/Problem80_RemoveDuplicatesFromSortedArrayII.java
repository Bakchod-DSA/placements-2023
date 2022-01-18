/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * Difficulty level: Medium
 */

package leetcode.TwoPointers;

public class Problem80_RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {

        /*
        // Approach 1: Two Pointers
        int k = 1;
        int count = 1;
        for(int i = 0, j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                nums[k++] = nums[j];
                i = j;
                count = 1;
            } else if(count < 2) {
                nums[k++] = nums[j];
                count++;
            }
        }
        return k;
        */


        // Approach 2: Two pointers; slow and fast
        // for allowing k duplicates, replace 2 with k
        int slow = 2;
        for(int fast = 2; fast < nums.length; fast++) {
            if(nums[slow - 2] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
