/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/implement-strstr/
 * Difficulty level: Easy
 */
package leetcode.Strings;

public class Problem28_ImplementstrStr_KMP {

    public int strStr(String haystack, String needle) {
        // return approachOne(haystack, needle);

        return approachTwo(haystack, needle);
    }

    private int approachOne(String haystack, String needle) {
        /* gives TLE
           O(mn)
        */
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

    private int[] computeLps(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for(int i = 0, j = 1; j < n;) {
            if(s.charAt(i) == s.charAt(j)) {
                lps[j++] = i + 1;
                i++;
            } else {
                if(i == 0) {
                    j++;
                }
                else {
                    i = lps[i - 1];
                }
            }
        }

        return lps;
    }

    private int approachTwo(String s, String p) {
        int[] lps = computeLps(p);

        int i, j;
        for(i = 0, j = 0; i < s.length();) {
            if(p.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            } else {
                if(j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }

            if(j == p.length()) {
                return i - j;
            }
        }

        return -1;

    }
}
