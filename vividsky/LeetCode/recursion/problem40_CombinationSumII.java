package LeetCode.recursion;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/combination-sum-ii/
 * Difficulty level : Medium
 */
public class problem40_CombinationSumII {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinations(candidates, target, 0, 0, new ArrayList<Integer>());
        return result;
    }

    private void combinations(int[] candidates, int target, int currIdx, int currSum, List<Integer> ans) {

        if (currSum == target) {
            result.add(new ArrayList<>(ans));
            return;
        }

        for (int i = currIdx; i < candidates.length; i++) {
            if (candidates[i] + currSum <= target && (i == currIdx || candidates[i] != candidates[i - 1])) {
                ans.add(candidates[i]);
                combinations(candidates, target, i + 1, currSum + candidates[i], ans);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
