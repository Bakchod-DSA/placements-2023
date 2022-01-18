/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/single-number-iii/
 * Difficulty level: Easy
 */

package leetcode.BitManipulation;

public class Problem260_SingleNumberIII {

    public int[] singleNumber(int[] nums) {

        int xorOfSingleNums = 0;
        for(int num : nums) {
            xorOfSingleNums ^= num;
        }

        int lastSetBitPosition = xorOfSingleNums & -xorOfSingleNums;
        int xorFirst = 0;
        int xorSecond = 0;

        for(int num : nums) {
            if((num & lastSetBitPosition) == lastSetBitPosition) {
                xorFirst ^= num;
            }
            else {
                xorSecond ^= num;
            }
        }

        return new int[]{xorFirst, xorSecond};

    }
}

/**
 * Discuss section (must see): https://leetcode.com/problems/single-number-iii/discuss/1561827/C%2B%2BPython-5-Simple-Solutions-w-Explanation-or-Brute-Force-%2B-Sort-%2B-Hashmap-%2B-Hashset-%2B-Xor-O(1)
 *
 * Approach 1: Bit Manipulation;
 *      Time Complexity: O(2n), Space Complexity:O(1)
 *      Intuition: find the xor of all elements to get a ^ b which appear once,
 *             rest all become 0 (since, x ^ x = 0) now in aXORb we can find last set bit
 *             which tells where the two no. differs from each other and by this set bit position separate the list into
 *             two halves to get a and b in separate list for sure and duplicate elements together in one of the two lists
 *             thus getting the uniques in that two lists by XORing again to cancel out duplicates.
 */