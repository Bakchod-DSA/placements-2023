/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * Difficulty level: Easy
 */
package leetcode.BitManipulation;

public class Problem1342_NumberOfStepsToReduceNumToZero {
    public int numberOfSteps(int num) {
        // return approachOne(num);
        return approachTwo(num);
    }

    private int approachOne(int num) {
        /*  Approach: Brute Force
            Time Complexity: O(count)
            Space Complexity: O(1)
        */
        int count = 0;
        while(num != 0) {
            if((num & 1) == 0) {
                num >>= 1;
            } else {
                num -= 1;
            }
            ++count;
        }
        return count;
    }

    private int approachTwo(int num) {
        /*  Approach: Bit Manipulation
            Time Complexity: O(logn)
            Space Complexity: O(1)
        */
        int count = 0;
        while(num > 0) {
            // for leftmost bit which will always be 1 if it comes in while loop, we only need 1 operation i.e. to subtract 1 and not
            // divide now. so in final answer we do count - 1.
            if((num & 1) == 1) {
                // odd means last bit is removed by first -1 then /2. Total 2 operations.
                count += 2;
            } else {
                // even means /2 only. Total 1 operation only.
                count += 1;
            }
            num >>= 1;
        }
        return (count == 0)? 0 : count - 1;
    }
}
