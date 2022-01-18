/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/implement-strstr/
 * Difficulty level : Easy
 */

package leetcode.TwoPointers;

public class Problem28_ImplementstrStr {

    public int strStr(String haystack, String needle) {
        // return approachOne(haystack, needle);

        return approachTwo(haystack, needle);
    }

    /**
     * Time Complexity: O(m + n)
     * Space Complexity: O(n), where n is the size of needle
     */
    private int approachTwo(String haystack, String needle) {
        if(needle.length() == 0) return 0;

        int[] lpsArray = findLpsArray(needle);
        int i, j;
        for(i = 0, j = 0; i < haystack.length() && j < needle.length(); ) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            } else {
                if(j == 0) {
                    i++;
                } else {
                    j = lpsArray[j - 1];
                }
            }
        }
        if(j == 0) {
            return -1;
        } else if (j < needle.length() && i == haystack.length()) {
            return -1;
        }
        else {
            return i - j;
        }
    }

    private int[] findLpsArray(String needle) {
        int[] lpsArray = new int[needle.length()];
        for(int i = 0, j = 1; j < needle.length(); ) {
            if(needle.charAt(i) == needle.charAt(j)) {
                lpsArray[j++] = ++i;
            }
            else {
                if(i == 0) {
                    j++;

                } else {
                    i = lpsArray[i - 1];
                }
            }
        }
        return lpsArray;
    }

    /**
     * gives TLE
     * Time Complexity: O(mn)
     * Space Complexity: O(n), where n is the size of needle
     */
    private int approachOne(String haystack, String needle) {
        if(needle.length() == 0) return 0;

        int i,j;
        for(i = 0, j = 0; (i + j) < haystack.length() && j < needle.length();) {
            if(haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            } else {
                j = 0;
                i++;
            }
        }

        if(j == needle.length()) {
            return i;
        }
        return -1;
    }
}
