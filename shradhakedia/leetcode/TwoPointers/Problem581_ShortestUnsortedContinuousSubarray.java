/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 * Difficulty level: Medium
 */

package leetcode.TwoPointers;

public class Problem581_ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {

        /*
        // Approach 1: Brute Force
        int flag1 = 0, flag2 = 0;
        int i, j;
        for(i = 0; i < nums.length; i++) {
            for(int k = i + 1; k < nums.length; k++) {
                if(nums[i] > nums[k]) {
                    flag1 = 1;
                    break;
                }
            }
            if(flag1 == 1) {
                    break;
            }
        }
        for(j = nums.length - 1; j >= 0; j--) {
            for(int k = j - 1; k >= 0; k--) {
                if(nums[j] < nums[k]) {
                    flag2 = 1;
                    break;
                }
            }
            if(flag2 == 1) {
                    break;
            }
        }

        if(flag1 == 0 && flag2 == 0) return 0;
        return j - i + 1;
        */

        // Approach 2: Two Pointers
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int beg = 0, end = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                min = Math.min(min, nums[i]);
            }
        }
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] > nums[i + 1]) {
                max = Math.max(max, nums[i]);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > min) {
                beg = i;
                break;
            }

        }
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] < max) {
                end = i;
                break;
            }
        }
        if(beg == end) return 0;
        return end - beg + 1;
    }
}

/**
 * Approach 1: Brute Force; Time Complexity: O(2n^2), Space Complexity: O(1)
 *             Intuition: traversing the loop from the beginning, we are searching for an element that is smaller than
 *                        the current index element(means array is unsorted from this index) (say, i) and then one loop from the end,
 *                        trying to find an element that is greater than the current index element (say j). output = j - i + 1
 *
 * Approach 2: Sorting; Time Complexity: O(nlog(n) + n), Space Complexity: O(n)
 *             Intuition: make a copy and sort the array and match it with unsorted one, the index where the mismatch
 *                        first starts is begin index and similarly from end where the first mismatch is end index.
 *
 * Approach 3: Two pointers; Time Complexity: O(4n), Space Complexity: O(1)
 *             Intuition: we go in 4 pass; firstly, we try to find the min element (smaller than previous thus making array unsorted)
 *                        in the array after the first element.
 *                        secondly, we find max element (greater than the later elements thus making array unsorted) in the array before
 *                        last element.
 *                        thirdly, in next pass we find the index(beg) where that min element had to be placed.
 *                        fourthly, in last pass we find the index(end) where that max element had to be placed.
 */