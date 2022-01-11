/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * Difficulty level: Medium
 */

package leetcode.bitManipulation;

public class Problem201_BitwiseANDOfNumbersRange {

    public int rangeBitwiseAnd(int left, int right) {

        // Approach 1: Using Brian Kernighan's Algorithm
        while(right > left) {
            right &= (right - 1);
        }

        return right;


        //Approach 2: Bit manipulation (checking from lsb)
        /*
        int count = 0;
        while(left != right) {
            count++;
            left >>= 1;
            right >>= 1;
        }

        return left << count;
        */

        // Approach 3: Bit manipulation (checking from msb)
        /*
        int result = 0;
        for(int i = 31; i >= 0; i--) {
            int leftBit = (left & (1 << i)) >> i;
            int rightBit = (right & (1 << i)) >> i;
            if(leftBit != rightBit) {
                break;
            } else {
                result |= (leftBit << i);
            }
        }

        return result;
        */
    }
}

/**
 *
 */
