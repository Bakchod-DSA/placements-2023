/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/single-number-ii/
 * Difficulty level: Medium
 */

package leetcode.bitManipulation;

public class Problem137_SingleNumberII {

    public int singleNumber(int[] nums) {

        // Approach 1: bit manipulation
        int result = 0;
        for(int pos  = 0; pos <= 31; pos++) {
            int countZeros = 0;
            for(int i = 0; i < nums.length; i++) {
                if((nums[i] & 1) != 1) {
                    countZeros++;
                }
                nums[i] >>>= 1;
            }
            if((countZeros % 3) == 0) {
                result |= (1 << pos);
            }
        }
        return result;

        /*
         Approach 2: brute force
         int i = 0;
         Arrays.sort(nums);
         for(; i < nums.length - 1; ) {
             if((nums[i] ^ nums[i + 1]) == 0) {
                 i += 3;
             }
             else break;
         }
         return nums[i];
        */

    }
}

/**
 * Approach 1: Bit Manipulation, Time Complexity: O(32n); Space Complexity: O(1)
 *      the only idea is to think in bits, i.e. count 1's and 0's for each bit and, as the no. appears
 *      exactly once or thrice implies the count of zeros/ones for each bit also will be either multiple of 3 or one extra.
 *      this is for sure count of bits of either 1 or 0 is not multiple of 3, denoting the missing no.'s bit,
 *      now we can set this bit in our result at that particular position(if the bit is 0 we dont need to set it, as its 0 by default).
 *      can be extended to any times i.e no. can be present any times and a single no.
 *
 * Approach 2: brute force, Time Complexity: O(nlog(n) + n) maybe n^2 as for sorting Arrays.sort() uses quicksort;
 *      Space Complexity: O(1)
 *      we sort the array to get all the groups of no. together and single no. somewhere in between.
 *      we know, each no. appears exactly once or thrice
 *
 */
