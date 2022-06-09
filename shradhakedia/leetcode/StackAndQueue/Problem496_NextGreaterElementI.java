/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/next-greater-element-i/
 * Difficulty level: Easy
 */
package leetcode.StackAndQueue;

import java.util.*;

public class Problem496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /*  Approach: Stack + HashMap
            Time Complexity: O(nums1.length + nums.length)
            Space Complexity: O(k + t), k = maximum decreasing sequence in nums2,
                                        t = all the nums which have next greater element i.e. subset of nums1.
        */
        Deque<Integer> decStack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums2) {
            while(!decStack.isEmpty() && num > decStack.peekFirst()) {
                int popEle = decStack.removeFirst();
                map.put(popEle, num);
            }
            decStack.addFirst(num);
        }

        int[] ans = new int[nums1.length];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
