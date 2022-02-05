package LeetCode.backtracking;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/find-greatest-common-divisor-of-array/
 * Difficulty level : Easy
 */
public class problem1979_FindGreatestCommonDivisorOfArray {
    public int findGCD(int[] nums) {

        // To find min and max of an array in linear search
        int n = nums.length;
        int min = Math.min(nums[0], nums[1]);
        int max = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n - 1; i+=2) {
            if (nums[i] < nums[i + 1]) {
                min = Math.min(nums[i], min);
                max=  Math.max(nums[i + 1], max);
            } else {
                min = Math.min(nums[i + 1], min);
                max=  Math.max(nums[i], max);
            }
        }

        if ((n & 1) != 0) {
            min = Math.min(nums[n - 1], min);
            max=  Math.max(nums[n - 1], max);
        }

        // return gcd(max, min);
        // return gcdUsingWhile(max, min);
        return approachTwo(min, max);
    }

    /**
     Try all the numbers in the range [1, min] and check the largest number
     which divides both of them.
     */
    private int approachTwo(int min, int max) {
        int ans = 1;
        for (int i = 1; i <= min; i++) {
            if ((min % i) == 0 && (max % i) == 0) {
                ans = i;
            }
        }
        return ans;
    }


    /**
     Find gcd of min and max with recursion
     */
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    /**
     Find gcd of min and max with while loop
     */
    private int gcdUsingWhile(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
