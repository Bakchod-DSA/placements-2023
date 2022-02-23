/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/group-anagrams/
 * Difficulty level: Medium
 */

package leetcode.HashTable;

import java.util.*;

public class Problem49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        return approachOne(strs);
    }

    private List<List<String>> approachOne(String[] strs) {
        /* Approach: Hash Table
           Time Complexity: O(n * (m(log m) + m)), n calls for all the elements in dictionary and m log m to sort the string
                            to make key and m for checking if key is in map already, then inserting it also requires getting
                            the key.
           Space Complexity: O(k), k = map size containing unique anagrams.
        */

        Map<String, List<String>> hash = new HashMap<>();

        for(String s : strs) {
            char[] sortedStrs = s.toCharArray();
            Arrays.sort(sortedStrs);
            String sortedStrsKey = new String(sortedStrs);

            if(!hash.containsKey(sortedStrsKey)) {
                hash.put(sortedStrsKey, new ArrayList<>());
            }
            hash.get(sortedStrsKey).add(s);
        }

        List<List<String>> groupAnagrams = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : hash.entrySet()) {
            groupAnagrams.add(entry.getValue());
        }

        return groupAnagrams;
    }

}
