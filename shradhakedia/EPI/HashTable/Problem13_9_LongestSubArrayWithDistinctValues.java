/**
 * Author : Sradha Kedia
 * Page no.: 224-225 of Epi Java
 * Problem no.: 13.09
 * Difficulty level : Medium
 */

package EPI.HashTable;

import java.util.*;

public class Problem13_9_LongestSubArrayWithDistinctValues {

    public static int longestSubarrayWithDistinctEntries(List<Integer> A) {
        // return approachOne(A);
        return approachTwo(A);
    }

    private static int approachOne(List<Integer> A) {
    /*  Approach: Hash Table + Sliding Window
        Time Complexity: O(n ^ 2)
        Space Complexity: O(n)
    */

        if(A.isEmpty()) return 0;

        Set<Integer> seen = new HashSet<>();
        // one element is always unique
        int max = 1;

        int i = 0, j = 0;
        while(j < A.size()) {
            // increment window till we get unique elements
            if(!seen.contains(A.get(j))) {
                seen.add(A.get(j));
                j++;
            } else {
                // as soon as we get duplicate entry we record the size of window if its larger than the previous window.
                while (seen.contains(A.get(j))) {
                    // keep on removing previously added result
                    seen.remove(A.get(i));
                    max = Math.max(max, j - i);
                    // decrement window size
                    i++;
                }
            }
        }
        // return the maximum of window size stored and the size of the set as in case of distinct elements in array/window
        // we may never go in above else case but our set still contains that window length as its size.
        return Math.max(max, seen.size());
    }

    private static int approachTwo(List<Integer> A) {
    /*  Approach: Hash Table
        Time Complexity: O(n)
        Space Complexity: O(n)
    */

        Map<Integer, Integer> mostRecentOccurrences = new HashMap<>();
        int longestDupFreeSubarrayStartIdx = 0;
        int result = 0;
        for(int i = 0; i < A.size(); i++) {
            if(mostRecentOccurrences.containsKey(A.get(i))) {
                if(mostRecentOccurrences.get(A.get(i)) >= longestDupFreeSubarrayStartIdx) {
                    result = Math.max(result, i - longestDupFreeSubarrayStartIdx);
                    longestDupFreeSubarrayStartIdx = mostRecentOccurrences.get(A.get(i)) + 1;
                }
            }
            mostRecentOccurrences.put(A.get(i), i);
        }

        return Math.max(result, A.size() - longestDupFreeSubarrayStartIdx);
    }
}
