/**
 * Author : Sradha Kedia
 * Link   : https://www.youtube.com/watch?v=1cspuQ6qHW0&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=14
 * Difficulty level : Medium
 */

package ExternalSources.Recursion;

import java.util.*;

public class PermutationWithSpaces {

    public static void main(String[] args) {

        System.out.println(permuteSpace("abcd"));
    }

    private static List<String> permuteSpace(String s) {

        if(s.length() == 1) {
            List<String> baseList = new ArrayList<>();
            baseList.add(Character.toString(s.charAt(0)));
            return baseList;
        }

        List<String> recurList = permuteSpace(s.substring(1));
        List<String> myList = new ArrayList<>();
        for(String rs : recurList) {
            myList.add(s.charAt(0) + rs);
            myList.add(s.charAt(0) + "_" + rs);
        }

        return myList;
    }

}
