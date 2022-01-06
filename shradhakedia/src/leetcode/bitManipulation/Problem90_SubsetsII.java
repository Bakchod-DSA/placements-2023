/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/subsets-ii/
 * Difficulty level: Easy
 */

package leetcode.bitManipulation;

import java.util.*;

public class Problem90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        // Approach 1: Bit Manipulation
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
            if(!powerSet.contains(subSet)) {
                powerSet.add(subSet);
            }
        }

        return powerSet;

        /*
        // Approach 2: Iterative
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            int len = powerSet.size();
            for(int j = 0; j < len; j++) {
                List<Integer> subSet = new ArrayList<>(powerSet.get(j));
                subSet.add(nums[i]);
                if(!powerSet.contains(subSet)) {
                    powerSet.add(subSet);
                }
            }
        }
        return powerSet;
        */
    }
}

/**
 * Approach 1: Bit manipulation; Time Complexity: O(n * 2^n + nlog(n)), Space Complexity: O(2^n)
 *      Intuition => Same as Subsets, only the change is; there can be duplicate elements too.
 *          so, we sort the list firstly and while adding subsets to powerSet we check if
 *          that does not exist already in powerSet.
 *
 * Approach 2: Iterative; Time Complexity: O(n * 2^n + nlog(n)), Space Complexity: O(2^n)
 *      similarly for this approach as above and Subsets problem.
 */
