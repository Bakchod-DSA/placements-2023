/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/integer-to-roman/
 * Difficulty level: Medium
 */

package leetcode.HashTable;

import java.util.*;
import static java.util.Map.entry;

public class Problem12_IntegerToRoman {

    public String intToRoman(int num) {

         //return approachOne(num);
         return approachTwo(num);
    }

    private String approachOne(int num) {
        /*  Approach: hash Table
            Time Complexity: O(n), where n = num.length
            Space Complexity: O(31)
        */

        Map<Integer, String> hash = Map.ofEntries(
                entry(0, ""),
                entry(1, "I"),
                entry(2, "II"),
                entry(3, "III"),
                entry(4, "IV"),
                entry(5, "V"),
                entry(6, "VI"),
                entry(7, "VII"),
                entry(8, "VIII"),
                entry(9, "IX"),
                entry(10, "X"),
                entry(20, "XX"),
                entry(30, "XXX"),
                entry(40, "XL"),
                entry(50, "L"),
                entry(60, "LX"),
                entry(70, "LXX"),
                entry(80, "LXXX"),
                entry(90, "XC"),
                entry(100, "C"),
                entry(200, "CC"),
                entry(300, "CCC"),
                entry(400, "CD"),
                entry(500, "D"),
                entry(600, "DC"),
                entry(700, "DCC"),
                entry(800, "DCCC"),
                entry(900, "CM"),
                entry(1000, "M"),
                entry(2000, "MM"),
                entry(3000, "MMM")
        );

        StringBuilder result = new StringBuilder();
        String s = "" + num;
        for(int i = 0; i < s.length(); i++) {
            int power = s.length() - 1 - i;
            result.append(hash.get((s.charAt(i) - '0') * (int) Math.pow(10, power)));
        }

        return result.toString();
    }

    private String approachTwo(int num) {
        /*  Approach: hash Table
            Time Complexity: O(n), where n = num.length
            Space Complexity: O(2 * 13)
        */

        int[] ints = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < ints.length; i++) {
            while(num >= ints[i]) {
                num -= ints[i];
                result.append(romans[i]);
            }
        }

        return result.toString();
    }

}
