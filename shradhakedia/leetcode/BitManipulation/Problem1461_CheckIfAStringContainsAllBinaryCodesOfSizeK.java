/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 * Difficulty level: Medium
 */
package leetcode.BitManipulation;

import java.util.*;

public class Problem1461_CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public boolean hasAllCodes(String s, int k) {
        // k = no. of combinations of bits possible with k (range)
        // 1 = 2 (0 to 1 << 1 - 1)
        // 2 = 4 (0 to 1 << 2 - 1)
        // 3 = 8 (0 to 1 << 3 - 1)
        // 4 = 16 (0 to 1 << 4 - 1)
        // ...
        // n = 2 ^ n (0 to 1 << n - 1)
        // e.g. k = 4 < (1 << 4) i.e 16 all possible combination of four bits can be there.
        // return approachOne(s, k);
        return approachTwo(s, k);

    }

    public boolean approachOne(String s, int k) {
        /*  Approach: Set + Bit Manipulation
            Time Complexity: O((n - k + 1) * k), n - k + 1 for iteration, k for hashing and adding it in the set.
            Space Complexity: O((n - k + 1) * k), n - k + 1 string of length k.
                              so, for length of string we multiplied wih k too.
        */
        Set<String> set = new HashSet<>();
        for(int i = 0; i <= s.length() - k; i++) {
            // int num = Integer.parseInt(s.substring(i, i + k), 2);
            set.add(s.substring(i, i + k));
            // return true when found all occurrences
            if(set.size() == (1 << k)) return true;
        }
        return false;
    }

    public boolean approachTwo(String s, int k) {
        /*  Approach: Set + Bit Manipulation
            Time Complexity: O(n)
            Space Complexity: O(1 << k)
            Explanation: For example, say s="11010110", and k=3, and we just finish calculating the hash of the                            first substring: "110" (hash is 4+2=6, or 110). Now we want to know the next hash, which
                         is the hash of "101".We can start from the binary form of our hash, which is 110. First,
                         we shift left, resulting 1100. We do not need the first digit, so it is a good idea to do
                         1100 & 111(all-one is of length k) = 100. The all-one 111 helps us to align the digits.
                         Now we need to apply the lowest digit of "101", which is 1, to our hash,
                         and by using |, we get 100 | last_digit = 100 | 1 = 101.
        */
        int need = 1 << k;
        boolean[] got = new boolean[need];
        int allOne = need - 1;
        int hash = 0;
        for(int i = 0; i < s.length(); i++) {
            // right shift by 1, set it lsb to 0 and then set msb bit according to what is at ith position
            int bit = s.charAt(i) - '0';
            hash = ((hash << 1) & allOne) | bit;
            if(i - k + 1 >= 0 && !got[hash]) {
                got[hash] = true;
                need--;
            }
            if(need == 0) return true;
        }
        return false;
    }
}
