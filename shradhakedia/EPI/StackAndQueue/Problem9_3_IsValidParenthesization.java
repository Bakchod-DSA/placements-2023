/**
 * Author : Sradha Kedia
 * Page no.: 137 of Epi Java
 * Problem no.: 9.3
 * Difficulty level : Medium
 */

package EPI.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Problem9_3_IsValidParenthesization {

    public static boolean isWellFormed(String s) {
    /*  Approach: Stack
        Time Complexity: O(n)
        Space complexity: O(n)
    */
        Deque<Character> leftChars = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if("({[".contains(c + "")) {
                leftChars.addFirst(c);
            } else {
                if(leftChars.isEmpty()) return false; // {}] unmatched right char.

                char popElement = leftChars.removeFirst();
                switch (c) {
                    case ')':
                        if(popElement != '(') return false;
                        break;
                    case '}':
                        if(popElement != '{') return false;
                        break;
                    case ']':
                        if(popElement != '[') return false;
                        break;
                }
            }
        }

        // [{} unmatched left char.
        return leftChars.isEmpty();
    }
}
