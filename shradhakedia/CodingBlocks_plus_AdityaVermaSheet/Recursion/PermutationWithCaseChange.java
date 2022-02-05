/**
 * Author : Sradha Kedia
 * Link   : https://www.youtube.com/watch?v=J2Er5XceU_I&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=15
 * Difficulty level : Medium
 */

package CodingBlocks_plus_AdityaVermaSheet.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithCaseChange {

    public static void main(String[] args) {

        System.out.println(permuteCaseChange("abc"));
    }

    private static List<String> permuteCaseChange(String s) {

        if(s.length() == 1) {
            List<String> baseList = new ArrayList<>();
            baseList.add(s.charAt(0) + "");
            baseList.add(Character.toString(s.charAt(0) - 32));
            return baseList;
        }

        List<String> recurList = permuteCaseChange(s.substring(1));
        List<String> myList = new ArrayList<>();
        for(String rs : recurList) {
            myList.add(s.charAt(0) + rs);
            myList.add(Character.toString(s.charAt(0) - 32) + rs);
        }

        return myList;
    }

}
