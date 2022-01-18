/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * Difficulty level : Medium
 */

package leetcode.SlidingWindow;

import java.util.*;

public class Problem438_FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {

        // return approachOne(s, p);

        return approachTwo(s, p);
    }

    private List<Integer> approachOne(String s, String p) {
        int windowSize = p.length();
        StringBuilder toCheckAnagram = new StringBuilder();

        List<Integer> result = new ArrayList<>();
        for(int i = 0, j = 0; j < s.length(); j++) {
            toCheckAnagram.append(s.charAt(j));
            if(j - i + 1 == windowSize) {
                if(isAnagram(toCheckAnagram, p)) {
                    result.add(i);
                }
                toCheckAnagram.deleteCharAt(0);
                i++;
            }
        }

        return result;
    }

    private boolean isAnagram(StringBuilder toCheckAnagram, String key) {
        int[] array = new int[26];
        for(int i = 0; i < toCheckAnagram.length(); i++) {
            array[toCheckAnagram.charAt(i) - 'a']++;
            array[key.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(array[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> approachTwo(String s, String p) {

        // making hashTable of pattern p.
        Map<Character, Integer> hash = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            hash.put(p.charAt(i), hash.getOrDefault(p.charAt(i), 0) + 1);
        }
        int countDistinctChars = hash.size();
        int windowSize = p.length();

        // applying sliding window
        List<Integer> result = new ArrayList<>();
        for(int i = 0, j = 0; j < s.length(); j++) {
            // performing calculation for each step i.e. to decrease the count of letter if its in pattern
            if(hash.containsKey(s.charAt(j))) {
                hash.put(s.charAt(j), hash.get(s.charAt(j)) - 1);
                // if we decreased the char count s.t. it became zero means the distinct char(to match)
                // reduced by one.
                if(hash.get(s.charAt(j)) == 0) {
                    countDistinctChars--;
                }
            }
            if(j - i + 1 == windowSize) {
                // if this count is zero means pattern match with windows chars so add index, i
                if(countDistinctChars == 0) {
                    result.add(i);
                }

                // since work of index i is done and it affected the hashtable so we need to recover original
                // hash table to check further slide of window, so we increment it back in map.
                if(hash.containsKey(s.charAt(i))) {
                    hash.put(s.charAt(i), hash.get(s.charAt(i)) + 1);
                    // if key had value one means we encountered a key that could contribute distinct char
                    // so increment count.
                    if(hash.get(s.charAt(i)) == 1) {
                        countDistinctChars++;
                    }
                }
                // increment i to maintain window.
                i++;
            }
        }
        return result;
    }
}

/**
 * Approach 1: Sliding Window; Time Complexity: O(len(s)), Space Complexity: O(len of unique chars in p) -> at most 26.
 * Approach 2: Sliding Window; Time Complexity: O(len(s)*len(p)), Space Complexity: O(26)
 */