/**
 * Author : Sradha Kedia
 * Page no.: 135, 136 of Epi Java
 * Problem no.: 9.2
 * Difficulty level : Medium
 */

package EPI.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Problem9_2_EvaluateRpn {

    public static int eval(String expression) {
        /*  Approach: Stack
            Time Complexity: O(n)
            Space complexity: O(n)
        */

        String[] symbols = expression.split(",");
        Deque<Integer> intermediateResults = new LinkedList<>();
        for(String token : symbols) {
            if(token.length() == 1 && "+-*/".contains(token)) {
                // operator
                int y = intermediateResults.removeFirst();
                int x = intermediateResults.removeFirst();
                switch (token) {
                    case "+":
                        intermediateResults.addFirst(x + y);
                        break;
                    case "-":
                        intermediateResults.addFirst(x - y);
                        break;
                    case "*":
                        intermediateResults.addFirst(x * y);
                        break;
                    case "/":
                        intermediateResults.addFirst(x / y);
                        break;
                    default:
                        throw new IllegalArgumentException("Malformed rpn at:" + token);
                }
            } else {
                // token is a number
                intermediateResults.addFirst(Integer.parseInt(token));
            }
        }

        return intermediateResults.removeFirst();
    }
}
