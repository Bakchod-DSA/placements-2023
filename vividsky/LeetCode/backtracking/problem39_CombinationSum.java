package LeetCode.backtracking;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/combination-sum/
 * Difficulty level : Medium
 */
public class problem39_CombinationSum {
    List<List<Integer>> r = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinations(candidates, target, 0, 0, new ArrayList<Integer>());
        return r;
    }

    private void combinations(int[] candidates, int target, int currIdx, int currSum, List<Integer> ans) {

        if (currSum == target) {
            r.add(new ArrayList<>(ans));
            return;
        }

        for (int i = currIdx; i < candidates.length; i++) {
            if (candidates[i] + currSum <= target) {
                ans.add(candidates[i]);
                combinations(candidates, target, i, currSum + candidates[i], ans);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
