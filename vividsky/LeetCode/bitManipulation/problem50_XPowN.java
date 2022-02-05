package LeetCode.bitManipulation;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/powx-n/
 * Difficulty level : Medium
 */
public class problem50_XPowN {
    public double myPow(double x, int n) {

        double result = 1.0;
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        while (n != 0) {
            if ((n & 1) != 0) {
                result *= x;
            }
            x *= x;
            n >>>= 1;
        }
        return result;
    }
}
