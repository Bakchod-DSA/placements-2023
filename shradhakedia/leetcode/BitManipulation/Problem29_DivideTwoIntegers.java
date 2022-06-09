/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/divide-two-integers/
 * Difficulty level: Medium
 */
package leetcode.BitManipulation;

public class Problem29_DivideTwoIntegers {
    public int divide(int x, int y) {
        return approachTwo(x, y);
    }

    private int approachOne(int x, int y) {
        int factor = 1;
        if((x > 0 && y < 0) || (x < 0 && y > 0)) {
            factor = -1;
        }

        long X = Math.abs(x + 0l);
        long Y = Math.abs(y + 0l);
        int power = 31;
        long Ypower = Y << power;
        long quotient = 0l;
        while(X >= Y) {
            while(Ypower > X) {
                power--;
                Ypower >>>= 1;
            }
            quotient += (1L << power);
            X -= Ypower;
        }

        quotient *= factor;
        if(quotient > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(quotient < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return (int) quotient;
    }

    private int approachTwo(int x, int y) {
        if(x == 1 << 31 && y == -1) {
            // Edge case: the only case when overflow occurs. when x is min and y is -1, result is max + 1(in 2's complement, it is min)
            // but we need to return max.
            return (1 << 31) - 1;
        }
        int a = Math.abs(x);
        int b = Math.abs(y);
        int quotient = 0;
        int power = 0;
        while(a - b >= 0) {
            for(power = 0; a - (b << power << 1) >= 0; power++);
            // b << power << 1 => b * (2 ^ 2power) and since this is greater than a(when loop ends),
            // we need to reduce a by 2 ^ power, since b * 2 ^ power will be less than a.
            quotient += 1 << power;
            a -= b << power;
        }

        return ((x > 0 && y > 0) || (x < 0 && y < 0))? quotient : -quotient;
    }
}
