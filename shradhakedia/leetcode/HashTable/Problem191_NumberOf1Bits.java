/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/number-of-1-bits/
 * Difficulty level: Easy
 */
package leetcode.HashTable;

public class Problem191_NumberOf1Bits {
    public int hammingWeight(int n) {
        // return approachOne(n);
        return approachTwo(n);
    }

    private int approachOne(int n) {
        int hammWt = 0;
        for(int i = 0; i < 32; i++) {
            if((n & 1) == 1) {
                hammWt++;
            }
            n >>= 1;
        }
        return hammWt;
    }

    private int approachTwo(int n) {
        // faster than approach one. Bit Trick: n & (n - 1) unsets the lowest set bit.
        // Time Complexity: O(no. of set bits)
        int hammWt = 0;
        while(n != 0) {
            hammWt++;
            n = n & (n - 1);
        }
        return hammWt;
    }
}
