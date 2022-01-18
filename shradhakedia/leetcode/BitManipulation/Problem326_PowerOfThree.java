/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/power-of-three/
 * Difficulty level: Easy
 */

package leetcode.BitManipulation;

public class Problem326_PowerOfThree {

    public static boolean isPowerOfThree(int n) {
        // Approach 3: bit manipulation
        String baseChanges = Integer.toString(n, 3);
        return baseChanges.matches("^10*$");
    }
}

/**
 * discuss post (Good to know): https://leetcode.com/problems/power-of-three/discuss/77876/**-A-summary-of-all-solutions-(new-method-included-at-15%3A30pm-Jan-8th)
 *
 * Approach 1: keep on dividing by 3 till we get 1 and return true when achieved 1,
 *             in process if a no. other than 1 is achieved which is not divisible by 3 return false.
 *
 * Approach 2: compute log3 n if its an integer return true.
 *             (Math.log10(n) / Math.log10(3)) % 1 == 0; => may throw error,
 *             This solution is problematic because we start using doubles, which means we are subject to precision errors.
 *             This means, we should never use == when comparing doubles.
 *             That is because the result of Math.log10(n) / Math.log10(3) could be 5.0000001 or 4.9999999.
 *             This effect can be observed by using the function Math.log() instead of Math.log10().
 *             instead use => return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
 *
 * Approach 3: using bit manipulation, convert no. to base 3 and if its of the form 1, 10, 100, ..., 10000... return true.
 *             approach 3, Time complexity :  O(log3 n) for both convert to base 3 and matching regex; Space complexity: O(1)
 */
