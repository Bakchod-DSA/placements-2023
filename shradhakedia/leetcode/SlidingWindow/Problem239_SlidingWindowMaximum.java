/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/sliding-window-maximum/
 * Difficulty level : Hard
 */

package leetcode.SlidingWindow;

import java.util.*;

public class Problem239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        return approachTwo(nums, k);

    }

    private int[] approachOne(int[] nums, int k) {
        int[] maxSW = new int[nums.length - k + 1];
        int index = 0;

        Deque<Integer> maxElementsDeque = new LinkedList<>();
        maxElementsDeque.add(nums[0]);

        for(int i = 0, j = 1; j < nums.length; j++) {
            while(!maxElementsDeque.isEmpty() && maxElementsDeque.peekLast() < nums[j]) {
                maxElementsDeque.pollLast();
            }
            maxElementsDeque.addLast(nums[j]);
            if(j - i + 1 == k) {
                maxSW[index++] = maxElementsDeque.peekFirst();
                if(maxElementsDeque.peekFirst() == nums[i]) {
                    maxElementsDeque.pollFirst();
                }
                i++;
            }
        }

        if(k == 1) {
            return nums;
        }
        if(k == nums.length) {
            return new int[] {maxSW[0]};
        }
        return maxSW;
    }

    private int[] approachTwo(int[] nums, int k) {
        int[] maxSW = new int[nums.length - k + 1];
        int index = 0;

        PriorityQueue<Integer> pQueue = new PriorityQueue<>((i1, i2) -> (i2 - i1));
        for(int i = 0, j = 0; j < nums.length; j++) {
            pQueue.add(nums[j]);
            // System.out.println(pQueue);
            if(j - i + 1 == k) {
                maxSW[index++] = pQueue.peek();

                // caused TLE, as it goes in O(k); k = priority queue size (same as size of the window)
                pQueue.remove(nums[i]);
                i++;
            }
        }

        return maxSW;
    }
}

/**
 * Approach 1: Time Complexity: O(n), Space Complexity: O(k)
 * Approach 2: Time Complexity: O(nk) where n is nums.length, k = window size; complexity is nk due to PQ built in
 *             remove function, if we implement our own Priority queue to remove elements in log k time, its of
 *             O(nlog(k)). Space Complexity: O(k)
 */