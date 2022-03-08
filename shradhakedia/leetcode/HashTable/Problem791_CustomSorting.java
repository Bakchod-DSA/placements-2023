/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/custom-sort-string/
 * Difficulty level: Medium
 */

package leetcode.HashTable;

import java.util.*;

public class Problem791_CustomSorting {

    public String customSortString(String order, String s) {
        return approachOne(order, s);
    }

    private String approachOne(String order, String s) {
        /*  Approach: Hash Table
            Time Complexity: O(m + n)
            Space Complexity: O(m + n)
        */

        Map<Character, Integer> sMap = new HashMap<>();
        for(char ch : s.toCharArray()) {
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }

        Set<Character> orderSet = new HashSet<>();
        StringBuilder ordersb = new StringBuilder();
        for(char ch : order.toCharArray()) {
            if(sMap.containsKey(ch)) {
                orderSet.add(ch);
                while(sMap.get(ch) > 0) {
                    ordersb.append(ch);
                    sMap.put(ch, sMap.get(ch) - 1);
                }
            }
        }

        StringBuilder permutedS = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(!orderSet.contains(ch)) {
                permutedS.append(ch);
            }
        }

        return permutedS.toString() + ordersb.toString();
    }

}
