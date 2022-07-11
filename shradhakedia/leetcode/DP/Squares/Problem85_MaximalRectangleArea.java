// https://leetcode.com/problems/maximal-rectangle/
package leetcode.DP.Squares;

import java.util.*;

public class Problem85_MaximalRectangleArea {
    public int maximalRectangle(char[][] matrix) {
        /*  Approach: tabulation + Monotonic Stack.
            Time Complexity: O(m * 2n), m = matrix.length, n = matrix[0].length, 2n = one for making heights ans
                             other for largestRectangleArea(heights).
            Space Complexity: O(n)
        */
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }
            int area = largestRectangleArea(heights);
            maxArea =  Math.max(area, maxArea);
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        /*  Approach: Monotonic Stack.
            Time Complexity: O(3n) = O(n)
            Space Complexity: O(2n) = O(n)
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
