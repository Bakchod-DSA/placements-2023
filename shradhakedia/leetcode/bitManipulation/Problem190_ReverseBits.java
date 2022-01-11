/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/reverse-bits/
 * Difficulty level: Easy
 */

package leetcode.bitManipulation;

public class Problem190_ReverseBits {

    public int reverseBits(int n) {
        // Approach 2: bit manipulation
        int reverse = 0;
        int pos = 31;
        while(n != 0) {
            System.out.println(pos);
            if((n & 1) == 1) {
                // set bit in reverse manner
                reverse |= 1 << pos;
            }
            pos--;
            n >>>= 1;
        }
        return reverse;
    }
}

/**
 * Approach 1 : The brute force approach is to iterate 32 times, and set the bits at pos = 31 - current bit set position.
 *              current bit set position means lsb i.e. set (1). time complexity is O(32).
 *
 * Approach 2:  Instead of looping 32 times, we loop till no. is equal to 0. since, we need to set only those bits
 *              from right which are set/1 from left. time complexity -> avg: O(log2 n), worst -> O(32).
 *
 * Approach 3:  we can swap bits of right and left, two pointers starting from 32nd bit and 0th bit, so on.
 *              public int reverseBits(int n) {
 *                  for(int i = 0, j = 31; i < j; i++, j--) {
 *                      int x = 1 << i;
 *                      int y = 1 << j;
 *                      int xOry = x|y;
 *                      if((n & xOry) != xOry && (n & xOry) != 0) {
 *                          n ^= xOry;
 *                       }
 *                 }
 *                 return n;
 *             }
 */
