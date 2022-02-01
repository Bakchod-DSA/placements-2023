package LeetCode.dyamicProgramming;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/climbing-stairs/
 * Difficulty level : Easy
 */
public class problem70_ClimbingStairs {
    int[] cache = new int[46];

    public int climbStairs(int n) {
        return approachTwo(n);
    }

    /**
     Time:O(N)
     Space : O(N)
     */
    public int approachOne(int n) {

        if (cache[n] != 0) {
            return cache[n];
        }

        if (n == 1 || n == 2) {
            cache[n] = n;
            return n;
        }

        cache[n] = approachOne(n - 1) + approachOne(n - 2);
        return cache[n];
    }

    /**
     Time:O(N)
     Space : constant
     no extra space for cache array,
     only needed two variables to store previous two values
     */
    public int approachTwo(int n) {
        if (n == 1 || n == 2) return n;
        int oneStep = 1;
        int twoStep = 2;
        int totalSteps = 0;
        for (int i = 2; i < n; i++) {
            totalSteps = oneStep + twoStep;
            oneStep = twoStep;
            twoStep = totalSteps;
        }

        return totalSteps;
    }
}
