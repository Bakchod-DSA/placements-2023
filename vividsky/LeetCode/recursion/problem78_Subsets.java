package LeetCode.recursion;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/subsets/
 * Difficulty level : Medium
 */
public class problem78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        return recursiveApproach(nums, 0);
        // return result;
    }

    private List<List<Integer>> recursiveApproach(int[] nums, int i) {
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

    private List<List<Integer>> bitApproach(int[] nums) {
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
