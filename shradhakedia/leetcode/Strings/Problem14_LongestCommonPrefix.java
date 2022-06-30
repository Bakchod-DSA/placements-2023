/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/longest-common-prefix/
 * Difficulty level: Easy
 */
package leetcode.Strings;

public class Problem14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int minWordLength = min(strs);
        StringBuilder commonPrefix = new StringBuilder();
        for(int i = 0; i < minWordLength; i++) {
            for(int j = 0; j < strs.length - 1; j++) {
                if(strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    return commonPrefix.toString();
                }
            }
            commonPrefix.append(strs[0].charAt(i));
        }

        return commonPrefix.toString();
    }

    private int min(String[] strs) {
        int len = 201;
        for(String str : strs) {
            len = Math.min(len, str.length());
        }
        return len;
    }
}
