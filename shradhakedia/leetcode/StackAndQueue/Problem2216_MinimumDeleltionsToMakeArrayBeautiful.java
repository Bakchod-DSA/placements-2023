/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/
 * Difficulty level: Medium
 */
package leetcode.StackAndQueue;

import java.util.*;

public class Problem2216_MinimumDeleltionsToMakeArrayBeautiful {
    public int minDeletion(int[] nums) {
        /*  Approach: Stack
            Time Complexity: O(n)
            Space Complexity: O(n)
        */
        Deque<Integer> stack = new LinkedList<>();
        for(int num : nums) {
            if((stack.size() % 2) == 0) {
                stack.addFirst(num);
            } else {
                if(stack.peekFirst() != num) {
                    stack.addFirst(num);
                }
            }
        }

        int operations = nums.length - stack.size();
        operations = ((stack.size() % 2) != 0)? operations + 1 : operations;
        return operations;

    }
}
