/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   :
 * Difficulty level: Hard
 */

package leetcode.HashTable;

import java.util.*;

public class Problem30_SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        return approachOne(s, words);
    }


    private List<Integer> approachOne(String s, String[] words) {
        /*  Given n as the length of s, a as the length of words, and b as the length of each word
            Time Complexity: O(n + (n - a.b)(a + a.b + b))
            Space Complexity: O(a + b), a = 'wordCount' hashTable, b = 'key' subtring.
        */

        int n = s.length();
        int k = words.length;
        int wordLength = words[0].length();
        int substringSize = k * wordLength;
        Map<String, Integer> wordCount = new HashMap<>();

        for(String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i <= n - substringSize; i ++) {
            Map<String, Integer> remaining = new HashMap<>(wordCount);
            boolean isValid = check(s, i, i + substringSize, remaining, wordLength);
            if(isValid) {
                ans.add(i);
            }
        }

        return ans;
    }

    private boolean check(String s, int start, int end, Map<String, Integer> remaining, int wordLength) {
        /*  Given n as the length of s, a as the length of words, and b as the length of each word
            Time Complexity: O(a.b + b), a.b = for loop, b = s.substring()
            Space Complexity: O(1)
        */

        boolean flag = true;
        for(int i = start; i < end; i += wordLength) {
            String key = s.substring(i, i + wordLength);
            if(remaining.containsKey(key) && remaining.get(key) > 0) {
                remaining.put(key, remaining.get(key) - 1);
            } else {
                flag = false;
                break;
            }
        }

        return flag;
    }


    private List<Integer> approachTwo(String s, String[] words) {

        // TODO: To implement Sliding Window approach.
        return new ArrayList<>();
    }

}
