/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/valid-palindrome/
 * Difficulty level: Easy
 */

package leetcode.TwoPointers;

public class Problem125_ValidPalindrome {

    // Approach 1: Two Pointers; Time Complexity:O(n), Space Complexity: O(1)
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        for(int i = 0, j = s.length() - 1; i < j; ) {

            char leftChar = s.charAt(i);
            char rightChar = s.charAt(j);
            if(!(leftChar >= 'a' && leftChar <= 'z') && !(leftChar >= '0' && leftChar <= '9')) {
                i++;
            }
            if(!(rightChar >= 'a' && rightChar <= 'z') && !(rightChar >= '0' && rightChar <= '9'))             {
                j--;
            }
            if(((leftChar >= 'a' && leftChar <= 'z') || (leftChar >= '0' && leftChar <= '9')) && ((rightChar >= 'a' && rightChar <= 'z') || (rightChar >= '0' && rightChar <= '9')))             {
                if(leftChar != rightChar) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
