/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/first-missing-positive/
 * Difficulty level: Hard
 */

package leetcode.HashTable;

import java.util.*;

public class Problem41_FirstMissingNumber {

    public int firstMissingPositive(int[] nums) {
//        return approachOne(nums);
        return approachTwo(nums);
    }

    private int approachOne(int[] nums) {
        /*  Approach: Hash Table
            Time Complexity: O(2n)
            Space Complexity: O(n)
        */

        Set<Integer> set = new HashSet<Integer>();

        for(int num : nums) {
            set.add(num);
        }

        int ans = (!set.contains(1))? 1 : Integer.MAX_VALUE;
        for(int num : nums) {
            if(num >= 0 && num < Integer.MAX_VALUE && !set.contains(num + 1)) {
                ans = Math.min(ans, num + 1);
            }
        }

        return ans;
    }

    private int approachTwo(int[] nums) {
        /*  Time Complexity: O(n)
            Space Complexity: O(1)
        */

        int n = nums.length;

        // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
        // (we can ignore those because if all number are > n then we'll simply return 1)
        for(int i = 0; i < n; i++) {
            if(nums[i] < 1 || nums[i] > n) {
                nums[i] = n + 1;
            }
        } // note: all number in the array are now positive, and on the range 1..n+1

        // 2. mark each cell appearing in the array, by converting the index for that number to negative
        for(int i = 0; i < n; i++) {
            if(nums[i] <= n) {

                // ind - 1 for zero index based array (so the number 1 will be at pos 0)
                int ind = Math.abs(nums[i]) - 1;
                if(ind < n && nums[ind] > 0) {
                    nums[ind] = -1 * nums[ind];
                }
            }
        }

        // 3. find the first cell which isn't negative (doesn't appear in the array)
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }

        // 4. no positive numbers were found, which means the array contains all numbers 1..n
        return n + 1;
    }
}
