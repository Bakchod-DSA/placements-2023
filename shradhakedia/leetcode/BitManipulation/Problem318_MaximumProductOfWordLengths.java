/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/maximum-product-of-word-lengths/
 * Difficulty level: Medium
 */
package leetcode.BitManipulation;

public class Problem318_MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {
        // return approachOne(words);
        return approachTwo(words);
    }

    private int approachOne(String[] words) {
        /*  Approach: brute force
            Time Complexity: O(n * n * len(words[i]) * len(words[i])) for i in 0 to n.
            Space Complexity: O(26n)
        */

        int len = words.length;
        int maxProd = 0;

        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                int prod = compare(words[i], words[j]);
                maxProd = Math.max(prod, maxProd);
            }
        }

        return maxProd;
    }

    private int compare(String w1, String w2) {
        int[] map = new int[26];
        boolean distinct = true;
        for(char c : w1.toCharArray()) {
            map[c - 'a'] = 1;
        }
        for(char c : w2.toCharArray()) {
            if(map[c - 'a'] == 1) {
                distinct = false;
                break;
            }
        }

        return distinct? w1.length() * w2.length() : 0;

    }

    private int approachTwo(String[] words) {
        /*  Approach: Bit manipulation
            Time Complexity: O(n * k + n ^ 2)
            Space Complexity: O(n), n = words.length,
            k = words[i].length(), for i in 0 to n and k can be at max 1000 as given constraint.
        */
        int len = words.length;
        int maxProd = 0;
        int[] mask = new int[len];
        for(int i = 0; i < len; i++) {
            int maskFromWord = calculateMask(words[i]);
            mask[i] = maskFromWord;
        }
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if((mask[i] & mask[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }

    private int calculateMask(String w) {
        int n = 0;
        for(char c : w.toCharArray()) {
            n |= (1 << (c - 'a'));
        }
        return n;
    }
}
