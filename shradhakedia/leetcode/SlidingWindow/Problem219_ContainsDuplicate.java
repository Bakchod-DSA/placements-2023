/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/contains-duplicate-ii/
 * Difficulty level : Easy
 */

package leetcode.SlidingWindow;

import java.util.*;

public class Problem219_ContainsDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        // return approachOne(nums,k);

        return approachTwo(nums, k);

    }

    private boolean approachOne(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0, j = 0; j < nums.length; j++) {
            if(j - i < k + 1) {
                if(set.contains(nums[j])) {
                    return true;
                }
                set.add(nums[j]);
            }
            else if(j - i == k + 1) {
                set.remove(nums[i]);
                if(set.contains(nums[j])) {
                    return true;
                }
                set.add(nums[j]);
                i++;
            }
        }
        return false;
    }

    private boolean approachTwo(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length && i < k + 1; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        for(int i = k + 1; i < nums.length; i++) {
            set.remove(nums[i - k - 1]);
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}

/**
 * Approach 1, 2: Sliding Window; Time Complexity: O(n), Space Complexity: O(n)
 */