/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/partition-labels/
 * Difficulty level: Medium
 */

package leetcode.HashTable;

import java.util.*;

public class Problem763_PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        // return approachOne(s);
        return approachTwo(s);
    }

    private List<Integer> approachOne(String s) {
        /*  Approach: Hash Table
            Time Complexity: O(2n)
            Space Complexity: O(2n), notUsed.size(), charCount.size() = n
        */

        Set<Character> notUsed = new HashSet<>();
        Map<Character, Integer> charCount = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        List<Integer> partitions = new ArrayList<>();
        int partitionsLengthLeft = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            notUsed.add(ch);

            if(charCount.get(ch) > 0) {
                charCount.put(ch, charCount.get(ch) - 1);
                if(charCount.get(ch) == 0) {
                    notUsed.remove(ch);
                }
            }

            if(notUsed.isEmpty()) {
                partitions.add(i + 1 - partitionsLengthLeft);
                partitionsLengthLeft = i + 1;
            }
        }

        return partitions;
    }

    private List<Integer> approachTwo(String s) {
        /*  Approach: Greedy
            Time Complexity: O(2n)
            Space Complexity: O(26)
        */

        int[] last = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            last[ch - 'a'] = i;
        }

        List<Integer> partitions = new ArrayList<>();
        int partitionsLengthLeft = 0;
        int maxLast = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(last[ch - 'a'] > maxLast) {
                maxLast = last[ch - 'a'];
            } else if(i == maxLast) {
                partitions.add(maxLast + 1 - partitionsLengthLeft);
                partitionsLengthLeft = maxLast + 1;
                maxLast++;
            }
        }

        return partitions;
    }

}
