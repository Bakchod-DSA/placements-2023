/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/sort-colors/
 * Difficulty level: Medium
 */

package leetcode.TwoPointers;

public class Problem75_SortColors {

    public void sortColors(int[] nums) {

        /*
        // Approach 1: Naive; Time complexity: O(n), Space Complexity: O(1)
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i : nums) {
            if(i == 0) {
                count0++;
            } else if(i == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        for(int i = 0; i < nums.length; ) {
            while(count0 > 0) {
                nums[i++] = 0;
                count0--;
            }

            while(count1 > 0) {
                nums[i++] = 1;
                count1--;
            }

            while(count2 > 0) {
                nums[i++] = 2;
                count2--;
            }
        }
        */

        /*
        // Approach 2: Two Pointers;
        int i = sort(nums, 0, 0);
        sort(nums, i, 1);
        */

        /*
        // Approach 3: Three Pointers;(two from start one from end)
        for(int i = 0, j= 0, k = nums.length - 1; j <= k; ) {
            if(nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else if(nums[j] == 2) {
                swap(nums, j, k);
                k--;
            } else {
                j++;
            }
        }
        */

        // Approach 4: Three pointer;(all from from start)
        int pointer0 = -1, pointer1 = -1, pointer2 = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                pointer2++;
                pointer1++;
                pointer0++;
                nums[pointer2] = 2;
                nums[pointer1] = 1;
                nums[pointer0] = 0;
            }
            else if(nums[i] == 1) {
                pointer2++;
                pointer1++;
                nums[pointer2] = 2;
                nums[pointer1] = 1;
            }
            else {
                pointer2++;
                nums[pointer2] = 2;
            }
        }

    }

    private int sort(int[] nums, int i, int val) {
        for(int j = nums.length - 1; i < j; ) {
            if(nums[i] != val && nums[j] == val) {
                swap(nums, i, j);
                i++;
                j--;
            }
            if(nums[i] == val) {
                i++;
            }
            if(nums[j] != val) {
                j--;
            }
        }
        if(i < nums.length && nums[i] == val) return i + 1;
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        if(i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}

/**
 * Approach 1: Counting sort; Time Complexity: O(2n), Space Complexity: O(1)
 *             Intuition: count 0's,1's,2,s in one pass and place them ony by one 0's, 1's ,2's in the order.
 * Approach 2: Two Pointers; Time Complexity: O(2n), Space Complexity: O(1)
 *             Intuition: firstly place all 0's in the beginning and unsorted 1's 2's after all 0's then
 *                        0's are sort in the second pass we will start from first 1's index and place 1's  before 2's
 *                        now 2's are automatically sorted at last.
 *
 * Approach 3: Three Pointers(two from start one from end); Time Complexity: O(n), Space Complexity: O(1)
 *             Intuition: put two pointers(i, j) in the beginning and one(k) in the end, now if at index j we have 2,
 *                        swap it with the end and decrement the end pointer, now if at j we have 0, swap it with element at i.
 *                        and increment i, j both.
 * Approach 4: Three Pointers(all three from start); Time Complexity: O(n), Space Complexity: O(1)
 *              Intuition: put two pointers(i, j, k) at -1 now, the idea is to shift one element further and create space for one.
 *                         as we encounter 0, we try to shift two to right and overwrite 2 there then one to right and overwrite 1
 *                         and then zero to right and overwrite 0.
 *                         if we encounter 1, we shift only 2 and overwrite 2 and then shift one to right and write 1.
 *                         if we encounter 2, we shift only 2 and overwrite 2.
 */