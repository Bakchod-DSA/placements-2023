/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/permutations-ii/
 * Difficulty level: Medium
 */

package leetcode.Backtracking;

import java.util.*;

public class Problem47_PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        // return approachOne(nums, 0);

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        approachTwo(list, tempList, used, nums);
        return list;

    }

    private List<List<Integer>> approachOne(int[] nums, int start) {
        /*  Approach: Recursion
            Time Complexity:  O(nlogn + (n * (n - 1)! * n * len(myList))) where n is no. of recursive calls,
                              (n - 1)! -> len(recurList) for traversing the resultant list returned by the previous calls and n
                              for travering its sublist, len(myList) to check contains.
            Space Complexity: O(n * (n - 1)! * n! * n) where n is depth of tree, (n - 1)! is space taken by recurList and n! for
                              myList and n for temp list.

        */

        if(start == nums.length - 1) {
            List<List<Integer>> baseList = new ArrayList<>();
            baseList.add(new ArrayList<>(Arrays.asList(nums[start])));
            return baseList;
        }

        List<List<Integer>> recurList = approachOne(nums, start + 1);
        List<List<Integer>> myList = new ArrayList<>();
        for(List<Integer> sublist : recurList) {

            for(int i = 0; i <= sublist.size(); i++) {

                List<Integer> temp = new ArrayList<>(sublist);
                temp.add(i, nums[start]);

                if(!myList.contains(temp)) {
                    myList.add(temp);
                }
            }
        }

        return myList;
    }

    private void approachTwo(List<List<Integer>> list, List<Integer> tempList, boolean[] used, int[] nums) {
        /*  Same as queen permutation 1D wrt box where no. of total queens is same as box size.
            Approach: BackTracking

            Time Complexity: O(n logn + ∑(k=1 to N) nPk) or O(n * n!), n log n for sorting,
            https://leetcode.com/problems/permutations/discuss/993970/Python-4-Approaches-%3A-Visuals-%2B-Time-Complexity-Analysis

            Space Complexity: O((n + 1) + 2n), (n + 1) depth of the tree, n for tempList, n for box.
            Note:  we did not take into account the space needed to hold the results. Otherwise, the space complexity would become
                   O(N⋅N!).

            Explanation: qpsf -> queen placed so far, tq = k i.e. -> total queens to be placed.
        */

        if(tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                // used[i] = true means that box is already occupied by queen.
                // if not occupied, i > 0, because for 0 we need to run further recursion but after that we need to skip same
                // previous elements.
                // if i > 0 and curr element is same as the previous elements then it can produce same permutation
                // so we exclude it if its 'previous is false', i.e. if we take a case of [2,2,3] so, here for i = 0 we call further
                // then in next call used[0] is true so continue, i = 1 and n[1] = n[0] but we want this permutation!! so we can
                // check if previous is 'true' means this permutation is required and don't skip!!

                continue;
            }

            used[i] = true;
            tempList.add(nums[i]);
            approachTwo(list, tempList, used, nums);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }

}
