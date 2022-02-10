package LeetCode.dynamivProgramming;

public class Xproblem132_PalindromePartitioningII {
    int[][]dp;
    public int minCut(String s) {
        // dp = new int[s.length()][s.length()];
        // for (int[] row: dp) {
        //     Arrays.fill(row, -1);
        // }
        // return minPartition(s, 0, s.length() - 1);
        return approachTwo(s);
    }

    /**

     */
    private int minPartition(String s, int start, int end) {
        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        if (isPalindrome(s, start, end)) {
            dp[start][end] = 0;
            return 0;
        }
        int minCut = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (isPalindrome(s, start, i)) {
                minCut = Math.min(minCut,  minPartition(s, i + 1, end) + 1);
            }
        }
        dp[start][end] = minCut;

        return dp[start][end];
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    private int approachTwo(String s) {

        boolean[][] isPalindrome = isPalindrome(s);
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int slide = 1; slide < n; slide++) {
            for (int start = 0; start < n - slide; start++) {
                int end = start + slide;
                if (isPalindrome[start][end]) {
                    dp[start][end] = 0;
                } else {
                    int minCut = Integer.MAX_VALUE;
                    for (int k = start; k < end; k++) {
                        if (dp[start][k] == 0) {
                            minCut = Math.min(minCut, dp[k + 1][end] + 1);
                        }
                    }
                    dp[start][end] = minCut;
                }

            }
        }
        return dp[0][n - 1];
    }

    private boolean[][] isPalindrome(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (boolean[] row : isPalindrome) {
            Arrays.fill(row, true);
        }
        for (int slide = 1; slide < n; slide++) {
            for (int i = 0; i < n - slide; i++) {
                int j = i + slide;
                if (isPalindrome[i + 1][j - 1] == false || s.charAt(i) != s.charAt(j)) {
                    isPalindrome[i][j] = false;
                }
            }
        }
        return isPalindrome;
    }
}
