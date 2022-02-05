package LeetCode.backtracking;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/combinations/
 * Difficulty level : Medium
 */
public class problem77_Combinations {
    List<List<Integer>> r = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        combinations(1, n, k, new ArrayList<Integer>());
        return r;
    }

    private void combinations(int idx, int n, int k, List<Integer> ans) {
        if (k == 0) {
            r.add(new ArrayList<>(ans));
            return;
        }

        for (int i = idx; i <= n - k + 1; i++) {
            ans.add(i);
            combinations(i + 1, n, k - 1, ans);
            ans.remove(ans.size() - 1);
        }
    }
}
