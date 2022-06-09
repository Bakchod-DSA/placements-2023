/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/largest-rectangle-in-histogram/
 * Difficulty level: Hard
 */
package leetcode.StackAndQueue;

import java.util.*;

public class Problem84_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        /*  Approach: Monotonic Stack.
            Time Complexity: O(3n)
            Space Complexity: O(2n)
        */
        int n = heights.length;
        int[] nsr = nextSmallerToRight(heights);
        int[] nsl = nextSmallerToLeft(heights);
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            int area = (nsr[i] - nsl[i] - 1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    private int[] nextSmallerToRight(int[] heights) {
        /*  Approach: Monotonic Stack. Its a common problem of stack
            Time Complexity: O(n)
            Space Complexity: O(n)
        */
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peekFirst()] >= heights[i]) {
                stack.removeFirst();
            }
            if(stack.isEmpty()) ans[i] = n; // instead of -1 to frame ans according to us.
            else ans[i] = stack.peekFirst();
            stack.addFirst(i);
        }
        return ans;
    }

    private int[] nextSmallerToLeft(int[] heights) {
        /*  Approach: Monotonic Stack. Its a common problem of stack
            Time Complexity: O(n)
            Space Complexity: O(n)
        */
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peekFirst()] >= heights[i]) {
                stack.removeFirst();
            }
            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peekFirst();
            stack.addFirst(i);
        }
        return ans;
    }
}
