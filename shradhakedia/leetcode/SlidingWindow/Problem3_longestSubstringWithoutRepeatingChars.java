/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Difficulty level : Medium
 */

package leetcode.SlidingWindow;

import java.util.*;

public class Problem3_longestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        return approachThree(s);
    }

    private int approachOne(String s) {
        if(s.length() == 0) return 0;

        int[] hash = new int[256];
        int ans = 1;
        int i = 0, j = 0;
        while(j < s.length()) {
            if(hash[s.charAt(j)] == 0) {
                hash[s.charAt(j)] = 1;
                j++;
            } else {
                ans = Math.max(ans, j - i);
                while(s.charAt(i) != s.charAt(j)) {
                    hash[s.charAt(i)] = 0;
                    i++;
                }
                i++;
                j++;
            }
        }
        return Math.max(ans, j - i);
    }

    private int approachTwo(String s) {
        int[] hash = new int[256];
        int ans = 0;
        int i = 0, j = 0;
        for(; j < s.length(); j++) {
            // when repeating character is encountered
            if(hash[s.charAt(j)] != 0) {
                ans = Math.max(ans, j - i);
                // setting slow pointer(i.e. unique substring start pointer) to the index
                // next to the position of repeating character or let it be same if repeating char was not part
                // of the substring we matched.
                // because we need to start matching from there now.
                i = Math.max(i, hash[s.charAt(j)]);

            }
            hash[s.charAt(j)] = j + 1;
        }

        return Math.max(ans, j - i);
    }

    private int approachThree(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();

        for(int i = 0, j = 0; j < s.length(); ) {
            if(set.add(s.charAt(j))) {
                j++;
            } else {
                ans = Math.max(ans, set.size());
                set.remove(s.charAt(i));
                i++;
            }
        }

        return Math.max(ans, set.size());
    }
}

/**
 * Approach 1: Time Complexity: O(n^2), Space Complexity: O(256) i.e. constant
 *             here, hash table stores 1, if char appeared else 0.
 *
 * Approach 2: Time Complexity: O(n), Space Complexity: O(256) i.e. constant
 *             here, hash table stores index of chars
 * Approach 3: Time Complexity: O(n or more) (why?), Space Complexity: O(n)
 */
