/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/missing-number/
 * Difficulty level: Easy
 */

package leetcode.HashTable;

import java.util.*;

public class Problem268_MissingNumber {

    public int missingNumber(int[] nums) {
        // return approachOne(nums);
        // return approachTwo(nums);
        return approachThree(nums);
    }


    private int approachOne(int[] nums) {
        /*  Approach: Hash Table
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        Set<Integer> seen = new HashSet<>();
        for(int num : nums) {
            seen.add(num);
        }

        for(int i = 0; i <= nums.length; i++) {
            if(!seen.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    private int approachTwo(int[] nums) {
        /*  Approach: Bit Manipulation
            Time Complexity: O(n)
            Space Complexity: O(1)
        */

        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            ans = ans ^ i ^ nums[i];
        }

        return ans ^ nums.length;
    }

    private int approachThree(int[] nums) {
        /*  Approach: Sorting
            Time Complexity: O(nlogn)
            Space complexity: O(1)
        */

        int ans = nums.length;

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                ans = i;
                break;
            }
        }

        return ans;
    }

}
