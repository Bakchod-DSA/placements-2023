/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/total-hamming-distance/
 * Difficulty level: Medium
 */

package leetcode.BitManipulation;

public class Problem477_TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {

        /*
        // Approach 1: Brute force(gives TLE); Time Complexity: (1 + 2 + ... + (n - 1)) * 32(32 for worst case for inner while loop) = 32 n(n - 1)/2 = O(n^2), Space Complexity: O(1)
        int hammingDistance = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int xor = nums[i] ^ nums[j];
                while(xor != 0) {
                    if((xor & 1) == 1) {
                        hammingDistance++;
                    }
                    xor >>= 1;
                }
            }
        }
        return hammingDistance;
         */

        // Approach 2: Bit manipulation
        int hammingDistance = 0;

        for(int bit = 0; bit < 31; bit++) {

            int countZeros = 0;
            int countOnes = 0;
            for(int i = 0; i < nums.length; i++) {

                if((nums[i] & 1) == 1) {
                    countOnes++;
                } else {
                    countZeros++;
                }
                nums[i] >>= 1;
            }

            hammingDistance += (countZeros * countOnes);
        }
        return hammingDistance;
    }
}

/**
 * Approach 2: Bit Manipulation; Time Complexity: O(32n), Space Complexity: O(1)
 *      Intuition => go bit by bit for each no., count ones and zeros, now once we have the count of different bits
 *                   we can just multiply thw two to get total different pairs of different bits
 *                   and add it to total hamming distance. this continues for all the 32 bits for each array element.
 *                   eg: 1 => 0001
 *                       4 => 0100
 *                      14 => 1110
 *                       6 => 0110
 *                     ------------
 *                  for bit 0 (lsb) -> 1, 000 so different bit pairs will be 10, 10, 10 i.e. countOnes * CountZeros = 3
 *                  for bit 1       -> 11, 00 so different bit pairs will be 10, 10, 10, 10 i.e. countOnes * CountZeros = 4
 *                  for bit 2       -> 111, 0 so different bit pairs will be 10, 10, 10 i.e. countOnes * CountZeros = 3
 *                  for bit 3 (msb) -> 1, 000 so different bit pairs will be 10, 10, 10 i.e. countOnes * CountZeros = 3
 *
 *                  hammingDistance = 3 + 4 + 3 + 3 = 13
 */
