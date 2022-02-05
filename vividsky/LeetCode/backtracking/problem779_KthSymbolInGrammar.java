package LeetCode.backtracking;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/k-th-symbol-in-grammar/
 * Difficulty level : Medium
 */
public class problem779_KthSymbolInGrammar {

    public int kthGrammar(int n, int k) {
        return approachOne(n, k);
    }

    private int approachOne(int n, int k) {
        if (n == 1) {
            return 0;
        }
        if (k <= (1 << (n - 2))) {
            return approachOne(n - 1, k);
        } else {
            return (approachOne(n - 1, k - ((1 << (n - 2))))) ^ 1;
        }
    }
}
