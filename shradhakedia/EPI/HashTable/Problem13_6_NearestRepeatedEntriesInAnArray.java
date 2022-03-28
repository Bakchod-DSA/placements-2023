/**
 * Author : Sradha Kedia
 * Page no.: 217-218 of Epi Java
 * Problem no.: 13.6
 * Difficulty level : Medium
 */

package EPI.HashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem13_6_NearestRepeatedEntriesInAnArray {

    public static int findNearestRepetition(List<String> paragraph) {
    /*  Approach: HashTable
        Time Complexity: O(n)
        Space Complexity: O(m), n = paragraph.size(), m = map.size().
    */

        Map<String, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for(int i = 0; i < paragraph.size(); i++) {

            String word = paragraph.get(i);
            if (map.containsKey(word)) {
                int lastIdx = map.get(word);
                minDistance = Math.min(minDistance, Math.abs(lastIdx - i));
            }
            map.put(word, i);
        }

        return (minDistance == Integer.MAX_VALUE)? -1 : minDistance;
    }

}
