/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/palindrome-partitioning/
 * Difficulty level: Medium
 */
package leetcode.Backtracking;

import java.util.*;

public class Problem131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(res, temp, s, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> temp, String s, int start) {
        if(start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int end = start; end < s.length(); end++) {
            if(isPalindrome(s.substring(start, end + 1))) {
                temp.add(s.substring(start, end + 1));
                backtrack(res, temp, s, end + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
