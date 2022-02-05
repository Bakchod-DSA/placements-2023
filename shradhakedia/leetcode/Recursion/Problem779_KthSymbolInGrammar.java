/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/k-th-symbol-in-grammar/
 * Difficulty level: Medium
 */

package leetcode.Recursion;

public class Problem779_KthSymbolInGrammar {

    public int kthGrammar(int n, int k) {

        // return approachOne(n, k);
        return approachTwo(n, k);

    }

    private int approachOne(int n, int k) {
        /*  Approach: Recursion + Observation
            Time Complexity: O(n)
            Space Complexity: O(n)
            Intuition: Observation 1 -> length of each row increases by double.
                       Observation 2 -> length of any row n = 1 << (n - 1) or 2 ^ (n - 1).
                       Observation 3 -> patterns are repeating, the current row pattern first half part is exactly same as its
                                        previous row and rest second half is bits reversed of previous row.
                                        Eg -> 0110 is (0110) (1001).
                       Observation 4 -> let, mid = length(nth row)/2
                                        if k is <= mid, then we need to find kth bit for (n - 1)th row too.
                                        but if k > mid, then we need to find (k - mid)th bit for (n - 1)th row too but reverse it.
                       And done! :)
        */

        if(n == 1) {
            return 0;
        }

        int length = 1 << (n - 1);
        int mid = length / 2;

        int kthBit;
        if(k <= mid) {
            kthBit = approachOne(n - 1, k);
        } else {
            kthBit = approachOne(n - 1, k - mid);
            kthBit = (kthBit == 0)? 1 : 0;
        }

        return kthBit;

    }

    private int approachTwo(int n, int k) {
        /*  Approach: Recursion
            Time Complexity:  O(n)
            Space Complexity: O(n)
            Intuition: Think of the problem like this,
                  n = 1                 0
                                    /        \
                                  /            \
                  n = 2          0              1
                               /    \         /    \
                  n = 3       0      1       1      0
                             / \    / \     / \    / \
                  n = 4     0   1  1   0   1   0  0   1
       for last level, k =  1   2  3   4   5   6  7   8

                       if k is even then the ans is on the left nodes of current level, k is odd then ans is on the right nodes
                       of the current level. if left node, then same as the value of parent node. if right node, then diiferent
                       from the parent's value. now, how to calculate parent node? if k is odd parent node is (k + 1)/2 and if
                       even then parent node is k/2.
        */


        if(n == 1) {
            return 0;
        }

        int kthBit;
        if((k & 1) == 1) {
            kthBit = approachTwo(n - 1, (k + 1)/ 2);
        } else {
            kthBit = approachTwo(n - 1, (k)/ 2);
            kthBit = (kthBit == 0)? 1 : 0;
        }

        return kthBit;

    }

}
