package LeetCode.recursion;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/subsets/
 * Difficulty level : Medium
 */
public class problem78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        approachThree(result, nums, 0, new LinkedList<Integer>());
        // return recursiveApproach(nums, 0);
        return result;
    }


    private void approachFour( List<List<Integer>> result,
                               int[] nums,
                               int idx,
                               LinkedList<Integer> ans) {

        result.add(new LinkedList<>(ans));

        for (int i = idx; i < nums.length; i++) {
            ans.addLast(nums[i]);
            backtrackingApproach(result, nums, i + 1, ans);
            ans.removeLast();
        }

    }

    private void approachThree(List<List<Integer>> result,
                               int[] nums,
                               int idx,
                               LinkedList<Integer> ans) {

        if (idx == nums.length) {
            result.add(new LinkedList<>(ans));
            return;
        }

        ans.addLast(nums[idx]);
        backtrackingApproach(result, nums, idx + 1, ans);
        ans.removeLast();
        backtrackingApproach(result, nums, idx + 1, ans);

    }

    private List<List<Integer>> approachTwo(int[] nums,
                                            int i) {

        if (i == nums.length) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> result = recursiveApproach(nums, i + 1);
        List<List<Integer>> temp = new ArrayList<>();

        for (List<Integer> ele: result) {
            List<Integer> subset = new ArrayList<>(ele);
            subset.add(nums[i]);
            temp.add(subset);
        }
        result.addAll(temp);
        return result;
    }



    private List<List<Integer>> approachOne(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            powerSet.add(subset);
        }
        return powerSet;
    }
}
