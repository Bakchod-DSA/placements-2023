package LeetCode.dynamivProgramming;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/palindromic-substrings/
 * Difficulty level : Medium
 */
public class problem647_PalindromicSubstrings {
    public int countSubstrings(String s) {
        return substringCount(s);
    }

    /**
     Time  : O(N^2)
     SPace : O(N^2)
     Algo  : our DP table is filled in such a way that all the diagonal element represents all the single character of string
     as all one length character are palindrom.

     Index start and end represent substring(start, end + 1)

     to check if it is a substring or not, we need not to check the whole substring but substring(start + 1, end)
     should be a substring and char at start and end should be same
     for e.g. if string = abcba we need to check if bcb is substring or not, if it is, then we will check if start
     and end character i.e. a is same or not
     and since we are storing whether substring are palindrome or not diagonally, we must have been calculated its                 substring is palindrome or not before handed
     */
    private int substringCount(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        // We can also write, this way we will be starting from diagonal bottom to diagonal top in one inner for loop
        // for (int start = s.length() - 1; start >= 0; start++) {
        //      for (int end = start; end < s.length(); end++) {
        //          ---your code goes here---
        //      }
        // }
        for (int slide = 0; slide < n; slide++) {
            for (int start = 0; start < n - slide; start++) {
                int end = start + slide;
                if (start == end) {
                    dp[start][end] = true;
                } else if(end == start + 1){
                    dp[start][end] = s.charAt(start) == s.charAt(end);
                } else if(dp[start + 1][end - 1] && s.charAt(start) == s.charAt(end)){
                    dp[start][end] = true;
                }
                count += dp[start][end] ? 1 : 0;
            }
        }
        return count;
    }

    /**
     Time  : O(N^2)
     Space : constant
     Algo  : we are finding palindroms keeping ith element as mid
     If to find off length palindroms, we are starting with left == right
     where to find even length palindroms, we are starting with right = left + 1
     */
    private int approachTwo(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += extractPalindrome(s, i, i); // To find odd palindroms
            count += extractPalindrome(s, i, i + 1); // To find even palindroms
        }
        return count;
    }

    private int extractPalindrome(String s, int left, int right) {
        int count = 0;
        // Taking care of the fact that we do not go out of bound at any case
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
