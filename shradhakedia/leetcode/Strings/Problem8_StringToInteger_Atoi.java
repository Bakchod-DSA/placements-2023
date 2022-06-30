/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/string-to-integer-atoi/
 * Difficulty level: Medium
 */
package leetcode.Strings;

public class Problem8_StringToInteger_Atoi {
    public int myAtoi(String s) {
        String t = s.trim();
        if(t.length() == 0) return 0;

        int sign = 1;
        long sum = 0l;


        for(int i = 0; i < t.length(); i++) {
            if(i == 0) {
                if(t.charAt(0) == '-') {
                    sign = 0;
                } else if(t.charAt(0) == '+') {
                    sign = 1;
                } else if(t.charAt(0) < '0' || t.charAt(0) > '9') {
                    break;
                } else {
                    int digit = t.charAt(0) - '0';
                    sum = (sum * 10) + digit;
                }
            } else {
                if(t.charAt(i) < '0' || t.charAt(i) > '9') {
                    break;
                } else {
                    int digit = t.charAt(i) - '0';
                    sum = (sum * 10) + digit;
                    if(sum > Integer.MAX_VALUE) break;
                }
            }
        }

        if(sum > Integer.MAX_VALUE && sign == 0) return Integer.MIN_VALUE;
        if(sum >= Integer.MAX_VALUE && sign == 1) return Integer.MAX_VALUE;
        return (sign == 0)? -(int) sum : (int) sum;
    }
}
