package leetcode.StackAndQueue;
/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
 * Difficulty level: Medium
 */
import java.util.*;

public class Problem1003_CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String s) {
        if(s.length() % 3 != 0) return false;
        Deque<Character> stack = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            if(stack.size() >= 2 && s.charAt(i) == 'c') {
                char b = stack.removeFirst();
                char a = stack.removeFirst();
                if(b != 'b' || a != 'a') return false;
            } else {
                stack.addFirst(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
