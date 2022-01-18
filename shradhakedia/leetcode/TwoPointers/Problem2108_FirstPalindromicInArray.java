/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
 * Difficulty level: Easy
 */

package leetcode.TwoPointers;

public class Problem2108_FirstPalindromicInArray {

    // Approach 1: Two Pointers
    public String firstPalindrome(String[] words) {
        String palindromic = "";

        for(String isPalindrome : words) {
            int i,j;
            for(i = 0, j = isPalindrome.length() - 1; i < j; i++, j--) {
                if(isPalindrome.charAt(i) != isPalindrome.charAt(j)) {
                    break;
                }
            }
            if(i >= j) {
                return isPalindrome;
            }
        }

        return palindromic;
    }
}

/**
 * Approach 1: Two Pointers; Time Complexity: O(nk) worst case: where n is length of array and k is length of word.
 *             Space Complexity: O(1)
 *             Intuition: traverse each word till we get a palindrome, as we get one return.
 */
