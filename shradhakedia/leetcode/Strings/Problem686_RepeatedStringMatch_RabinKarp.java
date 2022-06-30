/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/repeated-string-match/
 * Difficulty level: Medium
 */
package leetcode.Strings;

public class Problem686_RepeatedStringMatch_RabinKarp {
    public int repeatedStringMatch(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int times = 0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < b.length()) {
            sb.append(a);
            times++;
        }

        if(sb.toString().contains(b)) return times;
        sb.append(a);
        if(sb.toString().contains(b)) return times + 1;
        return -1;
    }
}
