/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/integer-replacement/
 * Difficulty level: Medium
 */

package leetcode.bitManipulation;

import java.util.HashMap;

public class Problem397_IntegerReplacement {
    static HashMap<Long, Long> map = new HashMap<>();

    public int integerReplacement(int n1) {

        // too handle overflow, 2^31 - 1 is 111....111 which odd and goes in first case
        // to add 1, the integer type causes n to be -2^32; which goes in infinite loop, typecast n1 to long
        long n = n1;

        // Approach 1: Bit Manipulation
        int count = 0;

        if(n == 1) return 0;
        if(n == 2) return 1;

        while(n != 3 && n != 4) {
            if((n & 1) == 1 && (n & 2) == 2) {
                n = n + 1;
            } else if((n & 1) == 1 && (n & 2) == 0) {
                n = n - 1;
            } else {
                n >>= 1;
            }
            count++;
        }
        return count + 2;

        // Approach 2: recursion + memoization
        /*
        map.put(1l, 0l);
        map.put(2l, 1l);
        return (int) recursiveIntegerReplacement((long) n1);
         */
    }

    public long recursiveIntegerReplacement(long n) {
        if(n == 1 || n == 2) {
            return map.get(n);
        }

        if((n & 1) == 0) {
            n >>= 1;
            if(!map.containsKey(n)) {
                long divideByTwo = recursiveIntegerReplacement(n);
                map.put(n , divideByTwo);
            }
            return map.get(n) + 1;
        }
        else {
            long plusOne;
            long minusOne;

            if(!map.containsKey(n + 1)) {
                plusOne = recursiveIntegerReplacement(n + 1);
                map.put(n + 1, plusOne);
            }
            if(!map.containsKey(n - 1)) {
                minusOne = recursiveIntegerReplacement(n - 1);
                map.put(n - 1, minusOne);
            }
            plusOne = map.get(n + 1);
            minusOne = map.get(n - 1);
            if(plusOne < minusOne) return plusOne + 1;
            else return minusOne + 1;
        }
    }
}

/**
 * Approach 1: Bit Manipulation; Time Complexity: O(log(n)), Space Complexity: O(1)
 *      if even i.e. lsb = 0 => we just need to divide
 *      if odd i.e lsb = 1 =>
 *          case 1: we check second bit if its 1 i.e we get ...11 then we add 1 to no. to make it ...00
 *                  by replacing two bits to 0 and setting the bit i.e. the first 0 from left side. eg: 10111 -> 11000.
 *          case 2: second bit is 0, eg: 11001, then we subtract 1 to clear the lsb. means here we don't need to set
 *                  further bits when they are already clear as that increases our cost of operation.
 *
 * Approach 2: recursion + memoization (complexities To be studied later)
 */