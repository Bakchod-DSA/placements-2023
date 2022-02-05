package LeetCode.backtracking;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/permutations-ii/
 * Difficulty level : Medium
 */
public class problem47_permutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele: nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        approachTwo(result, map, nums, new LinkedList<Integer>());


        // Arrays.sort(nums);
        // approachOne(result, new boolean[nums.length], nums, new ArrayList<Integer>());

        return result;
    }

    /**
     to find out all the unique numbers at each stage,
     we can build a hash table,
     with each unique number as the key and its occurrence as the corresponding value.
     This way, we won't be iterating same element twice
     i.e. one element will be considered once at each level

     In this problem or any backtrack problem,
     its good to use LinkedList instead of arrayList as we will be addying element at last only,
     similarly, when we will be reverting back our changes,
     we will be removing the recentrly added element
     and that will be at last of the List for sure
     */
    private void approachTwo(List<List<Integer>> result,
                             HashMap<Integer, Integer> map,
                             int[] nums,
                             LinkedList<Integer> ll) {

        if (ll.size() == nums.length) {
            result.add(new LinkedList<>(ll));
            return;
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {

            Integer ele = entry.getKey();
            Integer count = entry.getValue();

            if (count == 0)
                continue;

            ll.addLast(ele);
            map.put(ele, count - 1);

            approachTwo(result, map, nums, ll);

            ll.removeLast();
            map.put(ele, count);
        }
    }

    private void approachOne(List<List<Integer>> result,
                             boolean[] grid,
                             int[] nums,
                             List<Integer> ans) {

        if (ans.size() == nums.length) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            result.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (grid[i])
                continue;
            else if (i == 0 || (nums[i] != nums[i - 1]) || grid[i - 1]) {

                grid[i] = true;
                ans.add(nums[i]);

                approachOne(result, grid, nums, ans);

                grid[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }
}
