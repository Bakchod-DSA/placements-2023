/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Difficulty level: Medium
 */

package leetcode.HashTable;

import java.util.*;

public class Problem442_FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        // return approachOne(nums);
        // return approachTwo(nums);
        return approachThree(nums);
    }

    private List<Integer> approachOne(int[] nums) {
        /*  Approach: Hash Map
            Time Complexity: O(2n) in worst case, once for adding in hashmap, second for traversing hashMap which in worst
                             case can be of size n.
            Space Complexity: O(n), n = HashMap size in the worst case.
        */

        Map<Integer, Integer> numsCount = new HashMap<>();
        for(int num : nums) {
            numsCount.put(num, numsCount.getOrDefault(num, 0) + 1);
        }

        List<Integer> duplicates = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : numsCount.entrySet()) {
            if(entry.getValue() == 2) {
                duplicates.add(entry.getKey());
            }
        }

        return duplicates;
    }

    private List<Integer> approachTwo(int[] nums) {
        /*  Approach: Hash Set
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();
        for(int num : nums) {
            if(seen.contains(num)) {
                duplicates.add(num);
            } else {
                seen.add(num);
            }
        }

        return duplicates;
    }

    private List<Integer> approachThree(int[] nums) {
        /*  Optimised O(n) Approach
            Time Complexity: O(n)
            Space Complexity: O(1)
        */

        List<Integer> duplicates = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int ind = Math.abs(nums[i]) - 1;
            if(nums[ind] < 0) {
                duplicates.add(Math.abs(nums[i]));
            } else {
                nums[ind] *= -1;
            }
        }

        return duplicates;
    }

}
