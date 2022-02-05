package LeetCode.recursion;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/power-of-three/
 * Difficulty level : Easy
 */
public class problem326_PowerOfThree {
    public boolean isPowerOfThree(int n) {
        // return approachOne(n);
        // return approachTwo(n);
        return approachThree(n);
    }

    private boolean approachThree(int n) {
        if (n <= 0) return false;
        if ((n%3) != 0) {
            if (n == 1) return true;
            return false;
        }
        return approachThree(n/3);
    }

    private boolean approachOne(int n) {

        if (n <= 0) return false;

        while (n%3 == 0) {
            n/=3;
        }

        return n == 1;
    }

    private boolean approachTwo(int n) {

        double logBaseThree = Math.log(n)/Math.log(3);

        return Math.abs(logBaseThree - Math.round(logBaseThree)) < 1e-12;
    }
}
