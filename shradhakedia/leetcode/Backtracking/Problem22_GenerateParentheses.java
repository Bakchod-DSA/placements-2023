/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/generate-parentheses/
 * Difficulty level: Medium
 */

package leetcode.Backtracking;

import java.util.*;

public class Problem22_GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        // return findBalancedParenthesis(n);

        List<String> list = new ArrayList<>();
        StringBuilder curr = new StringBuilder();

        approachTwo(list, n, curr, 0, 0);

        return list;
    }

    private List<String> findBalancedParenthesis(int n) {
        if(n == 1) {
            List<String> baseList = new ArrayList<>();
            baseList.add("()");
            return baseList;
        }

        List<String> recurList = findBalancedParenthesis(n - 1);
        List<String> myList = new ArrayList<>();
        for (String rs : recurList) {

            rs = '(' + rs;
            for(int i = 0; i < rs.length(); i++) {

                char ch = rs.charAt(i);
                if(ch == '(') {
                    String parenthesisToAdd = rs.substring(0, i + 1) + ')' + rs.substring(i + 1);
                    if(!myList.contains(parenthesisToAdd)) {
                        myList.add(parenthesisToAdd);
                    }
                }
            }
        }

        return myList;
    }

    private void approachTwo(List<String> list, int n, StringBuilder curr, int open, int close) {
        /*  Time Complexity :  O((4^n)/(\sqrt(n))), Each valid sequence has at most n steps during the backtracking procedure.
            Space Complexity : O((4^n)/(\sqrt(n)), as described above, and using O(n) space to store the sequence.
        */

        if(curr.length() == n * 2) {
            list.add(curr.toString());
            return;
        }


        if(open < n) {
            curr.append("(");
            approachTwo(list, n, curr, open + 1, close);
            curr.deleteCharAt(curr.length() - 1);

        }

        if(close < open) {
            curr.append(")");
            approachTwo(list, n, curr, open, close + 1);
            curr.deleteCharAt(curr.length() - 1);
        }

    }

}
