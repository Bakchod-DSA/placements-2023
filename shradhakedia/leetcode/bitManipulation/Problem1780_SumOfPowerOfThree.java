/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
 * Difficulty level: Medium
 */

package leetcode.bitManipulation;

public class Problem1780_SumOfPowerOfThree {

    public boolean checkPowersOfThree(int n) {
        // Approach 1 (bit manipulation)
        // String baseChanges = Integer.toString(n, 3);
        // return baseChanges.matches("^[01]+$");

        // Approach 2 (kind of brute force)
        // no need to check for 0, due to constraint
        while(n != 1) {
            if((n % 3) == 0) {
                n /= 3;
            }
            else if(((n - 1) % 3) == 0) {
                n -= 1;
            }
            else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Approach 1: using bit manipulation, convert no. to base 3 and if it is of the form 0's and 1's then return true
 *      and if contains 2 in its base form, return false
 *      Time complexity :  O(log3 n) for both convert to base 3 and matching regex; Space complexity: O(1)
 *
 * Approach 2: the intuition is n = 3^a + 3^b + ...(assume a < b < ... < k...) = 3^a(1 + 3^(b - a) ..) => n is either
 *      divisible by 3 or  n - 1 is divisible by 3. so, we can check and compare if n belongs to these cases then continue
 *      else we return false.
 */
