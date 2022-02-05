/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/subsets-ii/
 * Difficulty level: Medium
 */

package leetcode.Backtracking;

import java.util.*;

public class Problem90_SubSetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        /*
        // Approach 1: Bit Manipulation
        List<List<Integer>> powerSet = new ArrayList<>();

        for(int i = 0; i < (1 << nums.length); i++) {

            List<Integer> subSet = new ArrayList<>();
            int indexOfElementToAdd = 0;

            int x = i;
            while(x != 0) {
                if((x & 1) == 1) {
                    subSet.add(nums[indexOfElementToAdd]);
                }
                x >>= 1;
                indexOfElementToAdd++;
            }
            if(!powerSet.contains(subSet)) {
                powerSet.add(subSet);
            }
        }

        return powerSet;
        */

        /*
        // Approach 2: Iterative
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            int len = powerSet.size();
            for(int j = 0; j < len; j++) {
                List<Integer> subSet = new ArrayList<>(powerSet.get(j));
                subSet.add(nums[i]);
                if(!powerSet.contains(subSet)) {
                    powerSet.add(subSet);
                }
            }
        }
        return powerSet;
        */

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        approachThree(list, tempList, nums, used, -1);
        return list;

    }

    private void approachThree(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used, int lastUsed) {
        /*  Time complexity:  O(n * 2 ^ n) to generate all subsets and then copy them into output list.
            Space complexity: O(n + n),  n is depth of the tree, n for used[].
            Note: for space complexity analysis, we do not count space that is only used for the purpose of returning output,
                  so the output array is ignored.
        */

        list.add(new ArrayList<>(tempList));

        for(int i = lastUsed + 1; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                // for i = 0 we dont want to continue, but for i = 1 onwards if the previous element is equal to current then
                // we want them to continue if there previous was false, and if they were true means that permutation counts!!
                // so include them
                continue;
            }

            used[i] = true;
            tempList.add(nums[i]);
            approachThree(list, tempList, nums, used, i);
            tempList.remove(tempList.size() - 1);
            used[i] = false;

        }
    }

}
