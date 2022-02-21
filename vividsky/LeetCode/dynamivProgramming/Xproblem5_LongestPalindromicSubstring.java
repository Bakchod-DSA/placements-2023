package LeetCode.dynamivProgramming;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/longest-palindromic-substring/
 * Difficulty level : Medium
 */
public class Xproblem5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        // return approachTwo(s);
        return approachOne(s);
    }

    /**
     Time  : O(N^2)
     SPace : O(N^2)
     Algo  : our DP table is filled in such a way that all the diagonal element represents all the single character of string
     as all one length character are palindrom.

     Index start and end represent substring(start, end + 1)

     to check if it is a substring or not, we need not to check the whole substring
     all we need to check is weather substring(start + 1, end - 1)
     is a substring and char at start and end is same
     for e.g. if string = abcba we need to check if bcb is substring or not, if it is, then we will check if start
     and end character i.e. a is same or not
     and since we are storing whether substring are palindrome or not diagonally, we must have been calculated its                  substring is palindrome or not before handed
     */
    public String approachOne(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int maxTillNow = 0;
        String result = "";
        for (int start = n - 1; start >= 0; start--) {
            for (int end = start; end < n; end++) {
                if (start == end) {
                    dp[start][end] = 1;
                } else if (end == start + 1 && s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = 2;
                } else if (dp[start + 1][end - 1] != 0 && s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = dp[start + 1][end - 1] + 2;
                }

                if (dp[start][end] > maxTillNow) {
                    maxTillNow = dp[start][end];
                    result = s.substring(start, end + 1);
                }
            }
        }
        return result;
    }

    /**
     Time  : O(N^2)
     Space : constant
     Algo  : we are finding palindroms keeping ith element as mid
     If to find odd length palindroms, we are starting with left == right
     where to find even length palindroms, we are starting with right = left + 1
     */
    public String approachTwo(String s) {

        String result = "";

        for (int i = 0; i < s.length(); i++) {

            // maximum of p1, p2, ans result is going to be out current longestPalindromcSubstring
            String p1 = extractPalindrome(s, i, i);
            String p2 = extractPalindrome(s, i, i + 1);

            if (p1.length() > result.length()) {
                result = p1;
            }
            if (p2.length() > result.length()) {
                result = p2;
            }
        }
        return result;
    }

    private String extractPalindrome(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (left + 1 <= right - 1) {
            return s.substring(left + 1, right); // we found a valid palindrome substring
        } else {
            return ""; // we were trying the even palindrome case and it turned out to be non palindromic substring
        }
    }
}
