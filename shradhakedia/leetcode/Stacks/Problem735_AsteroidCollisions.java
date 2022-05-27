/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/asteroid-collision/
 * Difficulty level: Medium
 */
package leetcode.Stacks;

import java.util.Deque;
import java.util.LinkedList;

public class Problem735_AsteroidCollisions {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for(int ast : asteroids) {
            boolean push = true;
            while(!stack.isEmpty() && stack.peekFirst() > 0 && ast < 0) {
                if(stack.peekFirst() < -ast) {
                    stack.removeFirst();
                    continue;
                } else if(stack.peekFirst() == -ast) {
                    push = false;
                    stack.removeFirst();
                } else {
                    push = false;
                }
                break;
            }
            if(push) stack.addFirst(ast);
        }


        int[] res = new int[stack.size()];
        int index = 0;
        while(!stack.isEmpty()) {
            res[index++] = stack.removeLast();
        }

        return res;
    }
}
