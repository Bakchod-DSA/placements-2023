/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/remove-palindromic-subsequences/
 * Difficulty level: Easy
 */
package leetcode.TwoPointers;

public class Problem1332_RemovePalindromicSubSequences {
    public int removePalindromeSub(String s) {
        /*  Approach: If it's empty sting, return 0;
                       If it's palindrome, return 1;
                       Otherwise, we need at least 2 operation.
            Time Complexity: O(n)
            Space Complexity: O(1)
        */

        if(s.length() == 0) return 0;

        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if(s.charAt(i) == s.charAt(j)) continue;
            return 2;
        }

        return 1;
    }
}
