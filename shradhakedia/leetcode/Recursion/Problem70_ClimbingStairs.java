/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/climbing-stairs/
 * Difficulty level: Easy
 */

package leetcode.Recursion;

import java.util.*;

public class Problem70_ClimbingStairs {

    public int climbStairs(int n) {

        HashMap<Integer, Integer> cache = new HashMap<>();
        cache.put(1, 1);
        cache.put(2, 2);
        return approachOne(n, cache);
    }

    private int approachOne(int n, HashMap<Integer, Integer> cache) {
        /*  Approach: fibonacci series, Recursion + memoization
            Time Complexity: O(n)
            Space Complexity: O(n)

        */

        if(cache.containsKey(n)) {
            return cache.get(n);
        }

        if(!cache.containsKey(n - 1)) {
            cache.put(n - 1, approachOne(n - 1, cache));
        }

        if(!cache.containsKey(n - 2)) {
            cache.put(n - 2, approachOne(n - 2, cache));
        }

        return cache.get(n - 1) + cache.get(n - 2);
    }

}
