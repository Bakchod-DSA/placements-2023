/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/valid-anagram/
 * Difficulty level: Easy
 */
package leetcode.Strings;

import java.util.*;

public class Problem242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freqChar = new HashMap<>();
        for(char c : s.toCharArray()) {
            freqChar.put(c, freqChar.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()) {
            if(!freqChar.containsKey(c)) return false;
            freqChar.put(c, freqChar.get(c) - 1);
            if(freqChar.get(c) == 0) freqChar.remove(c);
        }

        return freqChar.isEmpty();
    }
}
