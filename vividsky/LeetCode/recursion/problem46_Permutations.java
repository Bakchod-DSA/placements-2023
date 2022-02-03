package LeetCode.recursion;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/permutations/
 * Difficulty level : Medium
 */
public class problem46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // return approachOne(nums, 0);
        approachTwo(result, new boolean[nums.length], nums, new ArrayList<Integer>());
        return result;
    }
    private List<List<Integer>> approachOne(int[] nums, int idx) {
        if (idx == nums.length) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        List<List<Integer>> result = approachOne(nums, idx + 1);
        List<List<Integer>> temp = new ArrayList<>();
        for (List<Integer> subList: result) {
            for (int i = 0; i < subList.size(); i++) {
                List<Integer> permutation = new ArrayList<>(subList);
                permutation.add(i, nums[idx]);
                temp.add(permutation);
            }
            subList.add(nums[idx]);
        }
        result.addAll(temp);
        return result;
    }


    /**
     This approach uses backtracking
     */
    private void approachTwo(List<List<Integer>> result, boolean[] grid, int[] nums, List<Integer> ans) {
        if (ans.size() == nums.length) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (grid[i] == false) {

                grid[i] = true;
                ans.add(nums[i]);

                approachTwo(result, grid, nums, ans);

                grid[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }
}
