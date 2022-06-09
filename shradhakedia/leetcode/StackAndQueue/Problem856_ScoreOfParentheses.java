/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/score-of-parentheses/
 * Difficulty level: Medium
 */
package leetcode.StackAndQueue;

import java.util.*;

public class Problem856_ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        // return approachTwo(s);
        return approachThree(s);
    }

    private int approachOne(String s) {
        /*  Approach: Stack
            Time Complexity: O(n)
            Space Complexity: O(n)
        */
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(0); // the uppermost level will contain the final answer.
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                // entering score for new depth representing we have entered the new depth.
                stack.addFirst(0);
            } else {
                // ')' means getting out of a depth.
                int currScore = stack.removeFirst();
                if(currScore == 0) {
                    // means we encountered "()", so deeper level score is 1 only add it to one level up score.
                    stack.addFirst(stack.removeFirst() + 1);
                } else {
                    // else do 2 * calculated score and add that that to one level up score.
                    stack.addFirst(stack.removeFirst() + currScore * 2);
                }
            }
        }
        return stack.peekFirst();
    }

    private int approachTwo(String s) {
        /*  Approach: Stack
            Time Complexity: O(n)
            Space Complexity: O(n)
        */
        Deque<Integer> stack = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.addFirst(-1);
            } else {
                if(stack.peekFirst() == -1) {
                    stack.removeFirst();
                    stack.addFirst(1);
                } else {
                    int toPush = 0;
                    while(stack.peekFirst() != -1) {
                        toPush += stack.removeFirst();
                    }
                    stack.removeFirst();
                    stack.addFirst(2 * toPush);
                }
            }
        }

        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.removeFirst();
        }
        return res;
    }

    private int approachThree(String s) {
        /*  Approach: Optimized intutive
            Time Complexity: O(n)
            Space Complexity: O(1)
        */
        int res = 0;
        int depth = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                if(s.charAt(i - 1) == '(') {
                    res += (1 << depth);
                }
            }
        }
        return res;
    }
}
