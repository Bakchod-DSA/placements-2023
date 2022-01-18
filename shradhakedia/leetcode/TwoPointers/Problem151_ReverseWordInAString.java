/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/reverse-words-in-a-string/
 * Difficulty level: Medium
 */

package leetcode.TwoPointers;

public class Problem151_ReverseWordInAString {

    public String reverseWords(String s) {
            
        /*
        // Approach 1: Brute Force; Time Complexity: O(n), Space Complexity: O(1)
        String word = "";
        String reverse = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ') {
                word = s.charAt(i) + word;
            }
            else {
                if(!word.isEmpty()) {
                    System.out.println("true");
                    word += " ";
                }
                reverse += word;
                word = "";
            }
        }
        reverse += word;
        reverse = (reverse.charAt(reverse.length() - 1) == ' ')? reverse.substring(0, reverse.length() - 1) : reverse;
        return reverse;
        */
        
        // Approach 2: Two Pointers; Time Complexity: O(n), Space Complexity: O(1)
        String result = "";
        char[] reverseString = reverse(s.toCharArray(), 0, s.length() - 1);
        for(int i = 0, j = 0; i < reverseString.length;) {
            while(i < reverseString.length && reverseString[i] == ' ') {
                i++;
                j = i;
            }
            while(i < reverseString.length && reverseString[i] != ' ') {
                i++;
            }
            String word = reverseWord(reverseString, j, i - 1);
            result += word + " ";
        }
        
        return result.trim(); 
            
    }
        
    private String reverseWord(char[] s, int j, int i) {
        if(j > i) {
            return "";
        }
        char[] reverseWord = reverse(s, j, i);
        return new String(reverseWord).substring(j, i + 1);        
    }
    
    private char[] reverse(char[] s, int i, int j) {
        for(; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;            
        }
        return s;
    }
}