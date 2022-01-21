/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/minimum-window-substring/
 * Difficulty level : Medium
 */

package leetcode.SlidingWindow;

import javafx.util.Pair;
import java.util.*;

public class Problem76_MinimumWindowSubString {
    public String minWindow(String s, String t) {
        return approachTwo(s, t);
    }

    public String approachOne(String s, String t) {
        /* Approach 1: Sliding Window
           Time Complexity: O(2n + m), n = s.length(), m = t.length();
           Space Complexity: O(m + 3), m = t.length(), int[] window size 3.
           till unique chars are 0.
        */

        if(s.length() < t.length()) return "";

        // make hash table for t
        HashMap<Character, Integer> hashTable = new HashMap<>();
        for(char c : t.toCharArray()) {
            hashTable.put(c, hashTable.getOrDefault(c, 0) + 1);
        }

        // intialization for the calculations
        int uniqueCharsCount = hashTable.size();
        // window[0] = size of window, window[1] = start of window, window[2] = end of window
        int[] window = new int[]{s.length(), 0, 0};

        // apply sliding window
        int i = 0, j = 0;
        while(j < s.length()) {
            // add calculations for j
            char currentChar = s.charAt(j);
            if(hashTable.containsKey(currentChar)) {
                hashTable.put(currentChar, hashTable.get(currentChar) - 1);
                if(hashTable.get(currentChar) == 0) {
                    uniqueCharsCount--;
                }
            }

            // if all the chars of t is not obtained increase the window size,
            // else, if 0 try decreasing window from i.
            if(uniqueCharsCount > 0) {
                j++;
            } else if(uniqueCharsCount == 0) {

                while(uniqueCharsCount == 0) {
                    // update the window (if got a new min window)
                    if(j - i + 1 <= window[0]) {
                        window[0] = j - i + 1;
                        window[1] = i;
                        window[2] = j;
                    }

                    // remove calculation for i
                    if(hashTable.containsKey(s.charAt(i))) {
                        hashTable.put(s.charAt(i), hashTable.get(s.charAt(i)) + 1);
                        if(hashTable.get(s.charAt(i)) == 1) {
                            uniqueCharsCount++;
                        }
                    }
                    // Move the left pointer ahead, this would help to look for a new window.
                    i++;
                }
                // Keep expanding the window once we are done contracting.
                j++;
            }
        }

        // the case when string s, does not has all the char of t; so it comes out of loop with
        // minWindow as the whole string(as i never increased, j always increased).
        // eg: s = "aa" , t = "b" or s = "aab", t = "bc"
        return (i == 0 && j == s.length() && uniqueCharsCount > 0)? "" : s.substring(window[1], window[2] + 1);
    }

    public String approachTwo(String s, String t) {
        /* Approach 2: Optimized Sliding Window
           Time Complexity: O(2k + n + m), k = filteredS.size() n = s.length(), m = t.length();
           Space Complexity: O(m + k + 3), m = t.length(), k = filteredS.size(), int[] window size 3.
           till unique chars are 0.
        */

        if(s.length() < t.length()) return "";

        // make hash table for t
        HashMap<Character, Integer> hashTable = new HashMap<>();
        for(char c : t.toCharArray()) {
            hashTable.put(c, hashTable.getOrDefault(c, 0) + 1);
        }

        // filtering s
        List<Pair<Integer, Character>> filtered_S = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(hashTable.containsKey(s.charAt(i))) {
                filtered_S.add(new Pair<>(i, s.charAt(i)));
            }
        }

        // apply sliding window
        int uniqueCharsCount = hashTable.size();
        // window[0] = to store min size of window, window[1] = start of window, window[2] = end of window
        int[] window = new int[]{-1, 0, 0};
        int i = 0, j = 0;
        while(j < filtered_S.size()) {
            // add calculations for j
            char currentChar = filtered_S.get(j).getValue();
            if(hashTable.containsKey(currentChar)) {
                hashTable.put(currentChar, hashTable.get(currentChar) - 1);
                if(hashTable.get(currentChar) == 0) {
                    uniqueCharsCount--;
                }
            }

            // if all the chars of t is not obtained increase the window size,
            // else, if 0 try decreasing window from i.
            if(uniqueCharsCount > 0) {
                j++;
            } else if(uniqueCharsCount == 0) {

                while(uniqueCharsCount == 0) {
                    // update the window (if got a new min window)
                    int end = filtered_S.get(j).getKey();
                    int start = filtered_S.get(i).getKey();
                    if(window[0] == -1 || end - start + 1 <= window[0]) {
                        window[0] = end - start + 1;
                        window[1] = start;
                        window[2] = end;
                    }

                    // remove calculation for i
                    char c = filtered_S.get(i).getValue();
                    if(hashTable.containsKey(c)) {
                        hashTable.put(c, hashTable.get(c) + 1);
                        if(hashTable.get(c) == 1) {
                            uniqueCharsCount++;
                        }
                    }
                    // Move the left pointer ahead, this would help to look for a new window.
                    i++;
                }
                // Keep expanding the window once we are done contracting.
                j++;
            }
        }

        // the case when string s, does not has all the char of t; so it comes out of loop with
        // minWindow as the whole string(as i never increased, j always increased).
        // eg: s = "aa" , t = "b" or s = "aab", t = "bc"
        return (window[0] == -1)? "" : s.substring(window[1], window[2] + 1);
    }
}

