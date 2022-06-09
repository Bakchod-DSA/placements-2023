/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/count-collisions-on-a-road/
 * Difficulty level: Medium
 */
package leetcode.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Problem2211_CountCollisionsOnRoad {

    public int countCollisions(String directions) {
        Deque<Character> stack = new LinkedList<>();
        int count = 0;
        for(char dir : directions.toCharArray()) {
            boolean push = true;
            while(!stack.isEmpty()) {
                if(stack.peekFirst() == 'R' && dir == 'L') {
                    // RL on collision will become S
                    count += 2;
                    stack.removeFirst();
                    dir = 'S';
                    continue;
                } else if(stack.peekFirst() == 'R' && dir == 'S') {
                    count += 1;
                    stack.removeFirst();
                    continue;
                } else if(stack.peekFirst() == 'S' && dir == 'L') {
                    count += 1;
                    push = false;
                    break;
                } else {
                    break;
                }
            }
            if(push) stack.addFirst(dir);
        }

        return count;
    }
}
