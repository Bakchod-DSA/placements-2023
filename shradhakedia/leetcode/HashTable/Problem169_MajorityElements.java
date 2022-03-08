/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/majority-element/
 * Difficulty level: Easy
 * Solution(Must Read): https://leetcode.com/problems/majority-element/solution/
 */

package leetcode.HashTable;

import java.util.*;

public class Problem169_MajorityElements {

    public int majorityElement(int[] nums) {
        // return approachOne(nums);
        return approachTwo(nums);
    }

    private int approachOne(int[] nums) {
        /*  Approach: HashTable
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > nums.length/2) {
                return entry.getKey();
            }
        }

        return -1;
    }

    private int approachTwo(int[] nums) {
        /*  Approach: Boyer-Moore Voting Algorithm
            Time Complexity: O(n)
            Space Complexity: O(1)
        */

        int count = 0;
        Integer candidate = null;

        for(int num : nums) {
            if(count == 0) {
                candidate = num;
            }
            if(num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

}
