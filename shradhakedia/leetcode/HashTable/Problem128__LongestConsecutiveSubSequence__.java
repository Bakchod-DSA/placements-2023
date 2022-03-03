/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/longest-consecutive-sequence/
 * Difficulty level: Medium
 * Solution(Must Read): https://leetcode.com/problems/longest-consecutive-sequence/solution/
 */

package leetcode.HashTable;

import java.util.*;

public class Problem128__LongestConsecutiveSubSequence__ {

    public int longestConsecutive(int[] nums) {
        // return approachOne(nums);
        return approachTwo(nums);
    }

    private int approachOne(int[] nums) {
        /*  Approach: ordered HashTable i.e. TreeSet
            Time Complexity: O(2n)
            Space Complexity: O(n)
        */

        if(nums.length == 0) return 0;

        Set<Integer> set = new TreeSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int len = 1;
        int ans = 1;
        Iterator<Integer> iters = set.iterator();
        int prev = iters.next();
        while(iters.hasNext()) {
            int curr = iters.next();
            if(prev + 1 == curr) {
                len++;
            } else {
                ans = Math.max(len, ans);
                len = 1;
            }
            prev = curr;
        }

        return Math.max(len, ans);
    }

    private int approachTwo(int[] nums) {
        /*  Approach: HashTable + Union Find
            Time Complexity: O(2n)
            Space Complexity: O(n)
            Intuition: consider a number in set to build sequences from numbers that are not already part of a longer sequence.
                       attempting to count as high as possible from that number using only numbers in nums. After it counts
                       too high (i.e. currentNum refers to a number that nums does not contain), it records the length of the
                       sequence if it is larger than the current best. The algorithm is necessarily optimal because it
                       explores every possibility.
        */

        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for(int num : set) {
            // O(n) since we are not counting for a all nums but the ones whose num - 1 does not exist in set

            if(!set.contains(num - 1)) {
                // we check for num - 1 because we dont want to count again for a number that already appeared in
                // longest Sequence and if num - 1 is in set means that from num - 1 we can reach to num so why to
                // count from num.

                int currentNum = num;
                int currentStreak = 1;

                while(set.contains(currentNum + 1)) {
                    currentStreak++;
                    currentNum++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

}
