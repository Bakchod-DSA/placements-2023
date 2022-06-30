/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/compare-version-numbers/
 * Difficulty level: Medium
 */
package leetcode.Strings;

public class Problem165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("[.]");
        String[] v2 = version2.split("[.]");
        int v1Len= v1.length;
        int v2Len = v2.length;

        for(int i = 0; i < v1Len || i < v2Len; i++) {
            int rev1 = (i < v1Len)? Integer.parseInt(v1[i]) : 0;
            int rev2 = (i < v2Len)? Integer.parseInt(v2[i]) : 0;

            if(rev1 < rev2) return -1;
            if(rev1 > rev2) return 1;
        }

        return 0;
    }
}
