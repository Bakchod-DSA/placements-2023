/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
 * Difficulty level: Easy
 */

package leetcode.TwoPointers;

public class Problem2108_FirstPalindromicInArray {
    public String firstPalindrome(String[] words) {
        String palindromic = "";
        int flag = 0;

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
