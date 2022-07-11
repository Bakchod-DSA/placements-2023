/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/climbing-stairs/
 * Difficulty level: Medium
 */

package leetcode.DP.Fibonacci;

import java.util.*;

public class Problem70_ClimbingStairs {

    public int climbStairs(int n) {

        // HashMap<Integer, Integer> cache = new HashMap<>();
        // cache.put(1, 1);
        // cache.put(2, 2);
        // return approachOne(n, cache);

        return approachTwo(n);
    }

    private int approachOne(int n, HashMap<Integer, Integer> cache) {
        /*  Approach: fibonacci series, DP (Recursion + memoization) Top Down
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        if(!cache.containsKey(n)) {
            cache.put(n, approachOne(n - 1, cache) + approachOne(n - 2, cache));
        }

        return cache.get(n);
    }

    private int approachTwo(int n) {
        /*  Approach: fibonacci series, DP (Tabulation) Bottom up
            Time Complexity: O(n)
            Space Complexity: O(1)
        */

        if(n <= 2) {
            return n;
        }

        int fibMinus1 = 1;
        int fibMinus2 = 2;

        for(int i = 3; i <= n; i++) {
            int fibPresent = fibMinus1 + fibMinus2;
            fibMinus1 = fibMinus2;
            fibMinus2 = fibPresent;
        }

        return fibMinus2;
    }

}
