package LeetCode.recursion;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/palindrome-partitioning/
 * Difficulty level : Medium
 */
public class problem131_PalindromePartitioning {

    public List<List<String>> partition(String s) {
        return approachOne(s);
    }

    private List<List<String>> approachOne(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        for (int slide = 0; slide < n; slide++) {
            List<String> list = new ArrayList<>();
            for (int start = 0; start < n - slide; start++) {
                int end = start + slide;
                System.out.println(start +" "+ end);
                if (start == end) {
                    list.add(String.valueOf(s.charAt(start)));
                    dp[start][end] = true;
                } else if (end == start + 1 && s.charAt(start) == s.charAt(end)) {
                    list.add(s.substring(start, end + 1));
                    dp[start][end] = true;
                } else if (dp[start + 1][end - 1] && s.charAt(start) == s.charAt(end)) {
                    list.add(s.substring(start, end + 1));
                    dp[start][end] = true;
                } else {
                    list.add(String.valueOf(s.charAt(start + 1)));
                }
            }
            result.add(list);
        }
        return result;
    }
}
