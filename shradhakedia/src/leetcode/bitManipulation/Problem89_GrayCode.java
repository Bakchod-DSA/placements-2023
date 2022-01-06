/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/gray-code/
 * Difficulty level: Medium
 */

package leetcode.bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class Problem89_GrayCode {
    public List<Integer> grayCode(int n) {
        // Approach 1:
        List<Integer> grayCodeList = new ArrayList<>();

        for(int i = 0; i < (1 << n); i++) {
            grayCodeList.add(i ^ (i >> 1));
        }
        return grayCodeList;

        // Approach 2:
        // return recursiveGrayCode(n);
    }

    public List<Integer> recursiveGrayCode(int n) {
        if(n == 1) {
            List<Integer> baseGrayCode = new ArrayList<>();
            baseGrayCode.add(0);
            baseGrayCode.add(1);
            return baseGrayCode;
        }

        List<Integer> prevGrayCode = recursiveGrayCode(n - 1);

        List<Integer> presentGrayCode = new ArrayList<>(prevGrayCode);
        int add = 1 << (n - 1);
        for(int i = prevGrayCode.size() - 1; i >= 0; i--) {
            presentGrayCode.add(prevGrayCode.get(i) + add);
        }
        return presentGrayCode;
    }
}

/**
 * Approach 1: Bit Manipulation; Time Complexity: O(2^n), Space Complexity: O(1)
 *      formula based: G(i) = i ^ (i/2); for ith term
 *
 * Approach 2: Brute force, Time complexity: to study later, recurrence relation.
 *      recursive solution, if we know gray code of n-1 we can find for n.
 *      by just copying prev gray code to list and then reversing the list to add power(2, n-1) to each element.
 */
