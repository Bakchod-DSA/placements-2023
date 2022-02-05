package LeetCode.backtracking;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/generate-parentheses/
 * Difficulty level : Medium
 */
public class problem22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        paranthesis(result, 0, 0, n, "");
        return result;

    }
    /**
     There can be two cases
     1. When we can open parantheses i.e. when open paranthesis < n
     2. When we can close paranthesis when we have any open paranthesis, i.e. when open > close
     */
    private void paranthesis( List<String> result, int open, int close, int n, String ans) {

        if (open == close && close == n) {
            result.add(ans);
            return;
        }
        if (open < n)
            paranthesis(result, open + 1, close, n, ans + "(");

        if (open > close)
            paranthesis(result, open, close + 1, n, ans + ")");

    }
}
