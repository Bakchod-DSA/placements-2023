/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/next-greater-element-ii/
 * Difficulty level: Medium
 */
package leetcode.StackAndQueue;

import java.util.*;

public class Problem503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        /*
         */
        int n = nums.length;
        Deque<Integer> decStack = new LinkedList<>();
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            while(!decStack.isEmpty() && nums[decStack.peekFirst()] < nums[i]) {
                res[decStack.removeFirst()] = nums[i];
            }
            decStack.addFirst(i);
        }

        // another pass for left out elements.
        for(int i = 0; i < n; i++) {
            while(!decStack.isEmpty() && nums[decStack.peekFirst()] < nums[i]) {
                res[decStack.removeFirst()] = nums[i];
            }
        }

        // element which has no next greater element
        while(!decStack.isEmpty()) {
            res[decStack.removeFirst()] = -1;
        }
        return res;
    }
}
