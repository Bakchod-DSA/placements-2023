/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/move-zeroes/
 * Difficulty level: Easy
 */

package leetcode.TwoPointers;

public class Problem283_MoveZeros {
    public void moveZeroes(int[] nums) {
        for(int i = 0, j = 1; i < nums.length && j < nums.length; ) {
            if(nums[i] == 0 && nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
            } else if(nums[i] != 0) {
                i++;
                j++;
            } else if(nums[j] == 0) {
                j++;
            }
        }
    }
}
