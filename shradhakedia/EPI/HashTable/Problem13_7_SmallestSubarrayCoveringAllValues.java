/**
 * Author : Sradha Kedia
 * Page no.: 218-221 of Epi Java
 * Problem no.: 13.7
 * Difficulty level : Medium
 */

package EPI.HashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem13_7_SmallestSubarrayCoveringAllValues {

    // Represent subarray by starting and ending indices, inclusive.
    private static class Subarray {
        public Integer start;
        public Integer end;

        public Subarray(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    public static Subarray findSmallestSubarrayCoveringSet(List<String> paragraph,
                                                           Set<String> keywords) {
        /*  Approach: Sliding Window + Hash Table
            Time Complexity: O(n), n = paragraph.size()
            Space Complexity: O(m), m = keywords.size()
        */

        Map<String, Integer> keywordsCount = new HashMap<>();
        int windowSize = keywords.size();
        Subarray result = new Subarray(-1, -1);
        int i = 0, j = 0;
        int usedCount = 0;

        for(String keyword : keywords) {
            keywordsCount.put(keyword, 1);
        }

        while(j < paragraph.size()) {
            if(keywords.contains(paragraph.get(j))) {
                keywordsCount.put(paragraph.get(j), keywordsCount.get(paragraph.get(j)) - 1);
                if(keywordsCount.get(paragraph.get(j)) == 0) {
                    usedCount++;
                }
            }

            while(usedCount == windowSize) {
                if((result.start == -1 && result.end == -1) || j - i < result.end - result.start) {
                    result.start = i;
                    result.end = j;

                }

                if(keywordsCount.containsKey(paragraph.get(i))) {
                    keywordsCount.put(paragraph.get(i), keywordsCount.get(paragraph.get(i)) + 1);
                    if(keywordsCount.get(paragraph.get(i)) == 1) {
                        usedCount--;
                    }
                }
                i++;
            }
            j++;
        }

        return result;
    }


}
