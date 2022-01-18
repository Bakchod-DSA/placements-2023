/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/next-permutation/
 * Difficulty level : Medium
 */

package leetcode.TwoPointers;

import java.util.*;

public class Problem31_NextPermutation {

    public void nextPermutation(int[] nums) {

        /*
        // Approach 1: Time Complexity: O(n^2), Space Complexity: O(1)
        int i;
        for(i = nums.length - 2; i >= 0; i--) {
            int index = minGreaterNumIndex(nums, i);
            if(index != -1) {
                swap(nums, index, i);
                break;
            }
        }
        Arrays.sort(nums, i + 1, nums.length);
        */

        // Approach 2: Time Complexity: O(n^2), Space Complexity: O(1)
        int i, j;
        for(i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                break;
            }
        }
        if(i >= 0) {
            for(j = nums.length - 1; j >= i; j--) {
                if(nums[j] > nums[i]) {
                    break;
                }
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private int minGreaterNumIndex(int[] nums, int start) {
        int minGreaterNumber = Integer.MAX_VALUE;
        int index = -1;
        for(int i = start + 1; i < nums.length; i++) {
            if(nums[start] < nums[i] && nums[i] < minGreaterNumber) {
                minGreaterNumber = nums[i];
                index = i;
            }
        }
        return index;
    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
