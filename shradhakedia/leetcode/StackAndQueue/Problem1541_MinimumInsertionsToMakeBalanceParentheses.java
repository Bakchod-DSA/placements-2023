/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
 * Difficulty level: Medium
 */
package leetcode.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Problem1541_MinimumInsertionsToMakeBalanceParentheses {

    public int minInsertions(String s) {
        Deque<Character> stack = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.addFirst('(');
            } else {
                if(i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if(!stack.isEmpty()) stack.removeFirst();
                    else count++; // missing (
                    i++;
                } else {
                    if(!stack.isEmpty()) {
                        stack.removeFirst();
                        count++; // missing )
                    } else count += 2; // missing ()
                }
            }
        }

        count += (stack.size() * 2);
        return count;
    }
}
