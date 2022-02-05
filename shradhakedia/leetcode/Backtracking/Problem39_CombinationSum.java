/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/combination-sum/
 * Difficulty level: Medium
 */

package leetcode.Backtracking;

import java.util.*;

public class Problem39_CombinationSum {

    List<List<Integer>> allCombinations = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> oneCombination = new ArrayList<>();

        findCombinationSum(candidates, 0, target, 0, oneCombination);

        return allCombinations;
    }

    private void findCombinationSum(int[] candidates, int curr, int target, int lastUsedIndex, List<Integer> oneCombination) {
        /*  Same as coin Combination wrt user
            Approach: BackTracking
            Time Complexity: O(2 ^ n), n is size of candidates
            Space Complexity: O(n + n), n is the depth of the tree. n for oneCombination
            Note:  we did not take into account the space needed to hold the results.
        */

        if(curr == target) {
            allCombinations.add(new ArrayList<>(oneCombination));
            return;
        }

        if(curr > target) {
            return;
        }

        for(int i = lastUsedIndex; i < candidates.length; i++) {
            oneCombination.add(candidates[i]);
            findCombinationSum(candidates, curr + candidates[i], target, i, oneCombination);
            oneCombination.remove(oneCombination.size() - 1);
        }
    }

}
