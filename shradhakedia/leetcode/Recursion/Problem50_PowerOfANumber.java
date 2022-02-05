/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/powx-n/
 * Difficulty level : Medium
 */

package leetcode.Recursion;

public class Problem50_PowerOfANumber {

    public double myPow(double x, int n) {

        // return (n < 0)? 1/approachOne(x, -n) : approachOne(x, n);
        return (n < 0)? 1/approachTwo(x, -n) : approachTwo(x, n);
    }

    private double approachOne(double x, int n) {
        /*  Approach: Recursion
            Time Complexity: T(n) = T(n/2) + c; O(n)
            Space Complexity: O(log n)

        */

        if(n == 0) {
            return 1.0;
        }

        double recurPower = approachOne(x, n/2); // getting the result
        double myPower = recurPower * recurPower; // modifying the result to calculate my answer for next step

        if((n & 1) == 1) { // if odd, I multiplied with x one time,
            myPower *= x;
        }
        return myPower;
    }

    private double approachTwo(double x, int n) {
        /*  Approach: Recursion
            Time Complexity: T(n) = T(n/2) + c; O(n)
            Space Complexity: O(log n)

        */

        if(n == 0) {
            return 1.0;
        }

        double recurPower = approachOne(x * x, n/2); // getting the result
        double myPower = recurPower; // modifying the result to calculate my answer for next step

        if((n & 1) == 1) { // if odd, I multiplied with x one time,
            myPower *= x;
        }
        return myPower;

        // return ((n & 1) == 0)? approachOne(x * x, n/2) : x * approachOne(x * x, n/2);
    }

}
