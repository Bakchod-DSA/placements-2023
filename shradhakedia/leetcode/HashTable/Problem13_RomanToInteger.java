/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/roman-to-integer/
 * Difficulty level: Easy
 */

package leetcode.HashTable;

import java.util.*;

public class Problem13_RomanToInteger {

    public int romanToInt(String s) {
        return approachOne(s);
    }

    private int approachOne(String s) {
        /*  Approach: hash Table
            Time Complexity: O(n), where n = s.length()
            Space Complexity: O(7)
        */
        Map<Character, Integer> hash = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

        int result = hash.get(s.charAt(s.length() - 1));

        for(int i = s.length() - 2; i >= 0; i--) {
            int latter = hash.get(s.charAt(i + 1));
            int curr = hash.get(s.charAt(i));
            if(latter > curr) {
                result -= curr;
            } else {
                result += curr;
            }
        }

        return result;
    }

}
