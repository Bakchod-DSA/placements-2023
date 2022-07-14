package leetcode.DP;

public class Problem473_MatchSticksToSquare {
    int[] visited;

    public boolean makesquare(int[] matchsticks) {
        visited = new int[16];

        int sum = 0;
        for(int m : matchsticks) {
            sum += m;
        }

        if(sum % 4 != 0) return false;

        int n = matchsticks.length;
        visited[n - 1] = 1;
        return recursion(matchsticks, n - 1, matchsticks[n - 1], sum/4, 4);

    }

    private boolean recursion(int[] matchsticks, int ind, int currSum, int targetSum, int k) {
        if(k == 1) return true;

        if(currSum == targetSum) {
            return recursion(matchsticks, matchsticks.length - 1, 0, targetSum, k - 1);
        }

        for(int i = ind; i >= 0; i--) {
            if(visited[i] == 1 || currSum + matchsticks[i] > targetSum) continue;

            visited[i] = 1;
            currSum += matchsticks[i];

            if(recursion(matchsticks, i + 1, currSum, targetSum, k)) return true;
            visited[i] = 0;
            currSum -= matchsticks[i];
        }

        return false;
    }
}
