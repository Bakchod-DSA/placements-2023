package LeetCode.recursion;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/subsets-ii/
 * Difficulty level : Medium
 */
public class problem90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        approachThree(new boolean[nums.length], result, nums, 0, new LinkedList<Integer>());
        return result;
    }

    private void approachThree(boolean[] grid,
                               List<List<Integer>> result,
                               int[] nums,
                               int idx,
                               LinkedList<Integer> ans) {

        if (idx == nums.length) {
            result.add(new LinkedList<>(ans));
            return;
        }

        if (idx == 0 || nums[idx] != nums[idx - 1] || grid[idx - 1] == true) {
            ans.addLast(nums[idx]);
            grid[idx] = true;
            approachThree(grid,result, nums, idx + 1, ans);
            ans.removeLast();
            grid[idx] = false;
        }
        approachThree(grid, result, nums, idx + 1, ans);
    }

    private void approachTwo(List<List<Integer>> result, int[] nums, int idx, LinkedList<Integer> ans) {

        result.add(new LinkedList<>(ans));

        for (int i = idx; i < nums.length; i++) {
            if (i == idx || nums[i] != nums[i - 1]) {
                ans.addLast(nums[i]);
                approachTwo(result, nums, i + 1, ans);
                ans.removeLast();
            }
        }
    }

    private List<List<Integer>> approachOne(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < 1 << length; i++) {
            List<Integer> set = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                if ((i & (1 << j)) != 0) {
                    set.add(nums[j]);
                }
            }

            if (!arr.contains(set)) {
                arr.add(set);
            }

        }
        return arr;
    }
}
