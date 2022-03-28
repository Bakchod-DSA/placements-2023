/**
 * Author : Sradha Kedia
 * Page no.: 225-226 of Epi Java
 * Problem no.: 13.10
 * Difficulty level : Medium
 */

package EPI.HashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem13_10_LongestContainedArray {

    public static int longestContainedRange(List<Integer> A) {
    /*  Approach: Hash Table
        Time Complexity: O(n), n = A.size()
        Space Complexity: O(m), m = map.size() i.e. no. of unique characters in A
    */

        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for( int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
            min = Math.min(a, min);
        }

        int i = min, len = 0;
        int k = A.size();
        int ans = 0;
        while (k > 0) {
            ans = 0;
            while (map.containsKey(i)) {
                k -= map.get(i);
                ans++;
                i += 1;
            }
            len = Math.max(len, ans);
            i += 1;
        }

        return len;
    }

}
