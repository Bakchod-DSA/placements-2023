package leetcode.DP.Partitions;

public class Problem132_PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();

        // return recursion(s, 0) - 1;

        // Integer[] dp = new Integer[n];
        // return topDown(s, 0, dp) - 1;

        return bottomUp(s);
    }

    private int recursion(String s, int i) {
        if(i == s.length()) return 0;

        int ways = Integer.MAX_VALUE;
        for(int j = i; j < s.length(); j++) {
            boolean isPalin = checkPalindrome(s.substring(i, j + 1));
            if(isPalin) {
                int cost =  1 + recursion(s, j + 1);
                ways = Math.min(ways, cost);
            }
        }

        return ways;
    }

    private int topDown(String s, int i, Integer[] dp) {
        if(i == s.length()) return 0;
        if(dp[i] != null) return dp[i];

        int ways = Integer.MAX_VALUE;
        for(int j = i; j < s.length(); j++) {
            boolean isPalin = checkPalindrome(s.substring(i, j + 1));
            if(isPalin) {
                int cost =  1 + topDown(s, j + 1, dp);
                ways = Math.min(ways, cost);
            }
        }

        return dp[i] = ways;
    }

    private int bottomUp(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        for(int i = n - 1; i >= 0; i--) {
            int ways = Integer.MAX_VALUE;
            for(int j = i; j < s.length(); j++) {
                boolean isPalin = checkPalindrome(s.substring(i, j + 1));
                if(isPalin) {
                    ways = Math.min(ways, 1 + dp[j + 1]);
                }
            }

            dp[i] = ways;
        }


        return dp[0] - 1;
    }

    private boolean checkPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
