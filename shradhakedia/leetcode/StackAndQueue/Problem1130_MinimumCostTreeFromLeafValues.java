/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 * Difficulty level: Medium
 */
package leetcode.StackAndQueue;

import java.util.*;

public class Problem1130_MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        return approachOne(arr);
    }

    private int approachOne(int[] arr) {
        // Approach: Monotonic stack
        // https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/1333938/Monotone-Stack-(n)-in-depth-explanation-python
        // https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/476513/Java-Mono-Stack-98-Example-to-explain
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for(int curr : arr) {
            while(!stack.isEmpty() && stack.peekFirst() <= curr) {
                int mid = stack.removeFirst();
                if(stack.isEmpty()) res += (mid * curr);
                else res += (mid * Math.min(stack.peekFirst(), curr));
            }
            stack.addFirst(curr);
        }

        while(stack.size() > 1) {
            res += stack.removeFirst() * stack.peekFirst();
        }

        return res;
    }
}
