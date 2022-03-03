/**
 * Author : Sradha Kedia
 * Page no.: 212 of Epi Java
 * Problem no.: 13.1
 * Difficulty level : Medium
 */

package EPI.HashTable;

import java.util.HashMap;
import java.util.Map;

public class Problem13_1_PalindromePermutation {

    public static boolean canFormPalindrome(String s) {
    /*  Approach: Hash table
        Time Complexity: O(n + n/2)
        Space Complexity: O(n)
    */

        s = s.replaceAll(" ", "");
        boolean flag = false;

        Map<Character, Integer> hash = new HashMap<>();
        for(char ch : s.toCharArray()) {
            hash.put(ch, hash.getOrDefault(ch, 0) + 1);
        }

        for(int counts : hash.values()) {
            if((counts & 1) == 1) {
                if((s.length() & 1) == 0) {
                    return false;
                } else if(!flag) {
                    flag = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
