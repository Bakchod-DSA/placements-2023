/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/jewels-and-stones/
 * Difficulty level: Easy
 */

package leetcode.HashTable;

public class Problem771_JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {

        return approachOne(jewels, stones);
    }

    private int approachOne(String jewels, String stones) {
        /* Approach: HashTable
           Time Complexity: O(m + n), m -> jewels.length(), n -> stones.length()
           Space Complexity: O(52)
        */

        boolean[] hashTable =  new boolean[52];

        for(int i = 0; i < jewels.length(); i++) {
            char ch = jewels.charAt(i);
            if(Character.isUpperCase(ch)) {
                hashTable[ch - 'A' + 26] = true;
            } else {
                hashTable[ch - 'a'] = true;
            }
        }

        int count = 0;
        for(int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if(Character.isUpperCase(ch)) {
                if(hashTable[ch - 'A' + 26]) {
                    count++;
                }
            } else {
                if(hashTable[ch - 'a']) {
                    count++;
                }
            }
        }

        return count;
    }

    private int approachTwo(String J, String S) {
        /* Approach: replace every letter in S that is NOT in J with "". Then take the above resultant string's length.
           Time Complexity: O(n) where, n -> S.length()
           Space Complexity: O(n)
        */

        return S.replaceAll("[^" + J + "]", "").length();
    }

}
