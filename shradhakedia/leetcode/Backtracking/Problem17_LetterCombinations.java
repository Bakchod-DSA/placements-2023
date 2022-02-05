/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Difficulty level: Medium
 */

package leetcode.Backtracking;

import java.util.*;

public class Problem17_LetterCombinations {

    public List<String> letterCombinations(String digits) {

        String[] comb = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if(digits.length() != 0) {
            approachOne(list, sb, comb, digits, digits.length());
        }

        return list;

    }

    private void approachOne(List<String> list, StringBuilder sb, String[] comb, String digits, int n) {
        /*  Approach: BackTracking
            n = len(digits)
            Time Complexity:  O(3 ^ n), 3 because each digit maps to 3 chars, except 7 and 9. for that we multiply by 4 not 3.
            Space Complexity: O(n), n for recursive stack.
        */

        if(sb.length() == n) {
            list.add(sb.toString());
            return;
        }


        char ch = digits.charAt(0);
        String letters = comb[ch - '0'];
        for(int j = 0; j < letters.length(); j++) {

            sb.append(letters.charAt(j));
            approachOne(list, sb, comb, digits.substring(1), n);
            sb.setLength(sb.length() - 1);
        }

    }

}
