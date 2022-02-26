/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/two-sum/
 * Difficulty level: Easy
 */

package leetcode.HashTable;

import java.util.*;

public class Problem1_TwoSum {

    public int[] twoSum(int[] nums, int target) {

        return approachOne(nums, target);
    }

    private int[] approachOne(int[] nums, int target) {
        /*  Approach: Hash Table
            Time Complexity: O(n)
            Space Complexity: O(n), n = nums.length
        */

        int[] result = new int[2];

        Map<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(hash.containsKey(target - num) && i != hash.get(target - num)) {
                result[0] = i;
                result[1] = hash.get(target - num);
                break;
            }
        }

        return result;
    }

}
