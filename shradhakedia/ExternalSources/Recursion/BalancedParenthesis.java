/**
 * Author : Sradha Kedia
 * Link   : https://www.youtube.com/watch?v=eyCj_u3PoJE&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=17
 * Difficulty level : Medium
 */

package ExternalSources.Recursion;

import java.util.*;

public class BalancedParenthesis {

    public static void main(String[] args) {
        System.out.println(findBalancedParenthesis(4));
    }

    private static List<String> findBalancedParenthesis(int n) {
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

}
