/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/subsets/
 * Difficulty level: Medium
 */

package leetcode.bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class Problem78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        // Approach 1: Bit manipulation
        List<List<Integer>> powerSet = new ArrayList<>();

        for(int i = 0; i < (1 << nums.length); i++) {

            List<Integer> subSet = new ArrayList<>();
            int indexOfElementToAdd = 0;

            int x = i;
            while(x != 0) {
                if((x & 1) == 1) {
                    subSet.add(nums[indexOfElementToAdd]);
                }
                x >>= 1;
                indexOfElementToAdd++;
            }
            powerSet.add(subSet);
        }

        return powerSet;

        /*
        // Approach 2: iterative
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < (1 << i); j++) {
                List<Integer> newList = new ArrayList<>(powerSet.get(j));
                newList.add(nums[i]);
                powerSet.add(newList);
            }
        }
        return powerSet;
         */
    }
}

/**
 * Approach 1: Bit manipulation; Time Complexity: O(2^n), Space Complexity: O(2^n)
 *      Intuition => We can think it in this way that every binary representation of n bits no. is unique 2^n elements
 *          and can be used to represent each possible subsets.
 *          eg. list = [2, 3], n = 2; 00, 01, 10, 11 so 00 means [], 01 means [3], 10 means [2], 11 means [2, 3].
 *          i.e. [[], [2], [3], [2, 3]]
 *
 * Approach 2: Iterative; Time Complexity: O(2^n), Space Complexity: O(2^n)
 *      Intuition => Using [1, 2, 3] as an example, the iterative process is like:
 *          1. Initially, one empty subset [[]]
 *          2. Adding 1 to []: [[], [1]];
 *          3. Adding 2 to [] and [1]: [[], [1], [2], [1, 2]];
 *          4. Adding 3 to [], [1], [2] and [1, 2]: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
 */
