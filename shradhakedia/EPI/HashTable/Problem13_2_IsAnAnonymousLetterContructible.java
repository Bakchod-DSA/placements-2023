/**
 * Author : Sradha Kedia
 * Page no.: 213-214 of Epi Java
 * Problem no.: 13.2
 * Difficulty level : Medium
 */

package EPI.HashTable;

import java.util.HashMap;
import java.util.Map;

public class Problem13_2_IsAnAnonymousLetterContructible {

    public static boolean isLetterConstructibleFromMagazine(String letterText,
                                                            String magazineText) {
    /*  Approach: HashTable
        Time complexity: O(m + n)
        Space Complexity: O(c), c = no. of unique chars in letterText.
    */

        Map<Character, Integer> charFrequency = new HashMap<>();
        for(char ch : letterText.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }

        for(char ch : magazineText.toCharArray()) {
            if(charFrequency.containsKey(ch)) {
                charFrequency.put(ch, charFrequency.get(ch) - 1);
                if(charFrequency.get(ch) == 0) {
                    charFrequency.remove(ch);
                }
            }
            if(charFrequency.isEmpty()) {
                break;
            }
        }
        return charFrequency.isEmpty();
    }

}
