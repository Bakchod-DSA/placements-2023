/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/first-unique-character-in-a-string/
 * Difficulty level: Easy
 */

package leetcode.HashTable;

public class Problem387_FirstUniqueCharactersInAString {

    public int firstUniqChar(String s) {
        return approachOne(s);
    }

    private int approachOne(String s) {
        /*  Approach: Hash Table
            Time Complexity: O(2n)
            Space Complexity: O(n)
        */

        int[] charCount = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charCount[ch - 'a'] += 1;
        }

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(charCount[ch - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

}
