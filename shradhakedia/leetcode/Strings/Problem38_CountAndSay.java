/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/count-and-say/
 * Difficulty level: Medium
 */
package leetcode.Strings;

public class Problem38_CountAndSay {
    public String countAndSay(int n) {
        return iterCountAndSay(n);
    }

    private String recurCountAndSay(int n) {
        /*  TC: O(n * maxLength(string count and say))
            SC: O(n * maxLength(string count and say)), recursive stack space: n, stringBuilder space : maxLength(string count and say)
        */

        if(n == 1) {
            return "1";
        }

        String prev = recurCountAndSay(n - 1);

        int cnt = 1;
        int len = prev.length();
        StringBuilder curr = new StringBuilder();
        for(int i = 0; i < len - 1; i++) {
            if(prev.charAt(i) == prev.charAt(i + 1)) {
                cnt++;
            } else {
                String count = Integer.toString(cnt);
                curr.append(count).append(prev.charAt(i));
                cnt = 1;
            }
        }

        curr.append(Integer.toString(cnt)).append(prev.charAt(len - 1));
        return curr.toString();
    }

    private String iterCountAndSay(int n) {
        /*  TC: O(n * maxLength(string count and say))
            SC: O(maxLength(string count and say)), stringBuilder space : maxLength(string count and say)
        */
        String nthCountAndSay = "1";
        for(int i = 1; i < n; i++) {
            nthCountAndSay = countAndSayNext(nthCountAndSay);
        }

        return nthCountAndSay;
    }

    private String countAndSayNext(String prev) {
        int cnt = 1;
        int len = prev.length();
        StringBuilder curr = new StringBuilder();
        for(int i = 0; i < len - 1; i++) {
            if(prev.charAt(i) == prev.charAt(i + 1)) {
                cnt++;
            } else {
                String count = Integer.toString(cnt);
                curr.append(count).append(prev.charAt(i));
                cnt = 1;
            }
        }

        curr.append(Integer.toString(cnt)).append(prev.charAt(len - 1));
        return curr.toString();
    }
}
