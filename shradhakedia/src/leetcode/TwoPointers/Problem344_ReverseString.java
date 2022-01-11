/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/reverse-string/
 * Difficulty level: Easy
 */

package leetcode.TwoPointers;

public class Problem344_ReverseString {
    public void reverseString(char[] s) {
        for(int i = 0, j = s.length- 1; i < j; i++, j--) {
            if(s[i] != s[j]) {
                swap(s, i, j);
            }
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
