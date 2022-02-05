/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/combination-sum-ii/
 * Difficulty level: Medium
 */

package leetcode.Backtracking;

import java.util.*;

public class Problem40_CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];

        approachOne(list, tempList, candidates, used, target, 0);

        return list;
    }

    private void approachOne(List<List<Integer>> list, List<Integer> tempList, int[] candidates, boolean[] used, int target, int lastUsed) {
        /*  Same as coin Combination wrt user
            Approach: BackTracking
            Time Complexity: O(2 ^ n), n is size of candidates
            Space Complexity: O(n + n), n is the depth of the tree. n for tempList
            Note:  we did not take into account the space needed to hold the results.
        */

        if(target == 0) {
            // +ve base case
            list.add(new ArrayList<>(tempList));
            return;
        }

        if(target < 0) {
            // -ve base case
            return;
        }

        for(int i = lastUsed; i < candidates.length; i++) {
            if(i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                // we need to skip same elements, if its at index greater than last used index.
                // [10,1,2,7,6,1,5], 8
                // [[1,1,6],[1,2,5],[1,7],[2,6]] so, for first 1 also [1,2,5] and second 1 also [1, 2, 5] can encounter.
                // we need to restrict that so we check that if i is after the last used element and equal to previous element then
                // surely that can give duplicate results.
                continue;
            }

            used[i] = true;
            tempList.add(candidates[i]);
            approachOne(list, tempList, candidates, used, target - candidates[i], i + 1);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }

}
