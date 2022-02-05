/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/permutations/
 * Difficulty level: Medium
 */


package leetcode.Backtracking;

import java.util.*;

public class Problem46_Permutations {

    public List<List<Integer>> permute(int[] nums) {

        // return approachOne(nums, 0);

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        // boolean[] box = new boolean[nums.length];
        // approachTwo(list, tempList, box, nums, 0);

        approachThree(list, tempList, nums);
        return list;

    }

    private List<List<Integer>> approachOne(int[] nums, int start) {
        /*  Approach: Recursion
            Time Complexity:  O(n * (n - 1)! * n) where n is no. of recursive calls, (n - 1)! for traversing the result list
                              returned by the previous calls and n for travering its sublist.
            Space Complexity: O(n * (n - 1)! * n! * n) where n is depth of tree, (n - 1)! is space taken by recurList and n! for
                              myList ans n for temp list.

        */

        if(start == nums.length - 1) {
            List<List<Integer>> baseList = new ArrayList<>();
            baseList.add(new ArrayList<>(Arrays.asList(nums[start])));
            return baseList;
        }

        List<List<Integer>> recurList = approachOne(nums, start + 1);
        List<List<Integer>> myList = new ArrayList<>();
        for(List<Integer> sublist : recurList)  {

            for(int i = 0; i <= sublist.size(); i++) {

                List<Integer> temp = new ArrayList<>(sublist);
                temp.add(i, nums[start]);

                myList.add(temp);
            }
        }

        return myList;
    }

    private void approachTwo(List<List<Integer>> list, List<Integer> tempList, boolean[] box, int[] nums, int qpsf) {
        /*  Same as queen permutation 1D wrt box where no. of total queens is same as box size.
            Approach: BackTracking

            Time Complexity: O(∑(k=1 to N) nPk) or O(n * n!),
            https://leetcode.com/problems/permutations/discuss/993970/Python-4-Approaches-%3A-Visuals-%2B-Time-Complexity-Analysis

            Space Complexity: O((n + 1) + 2n), (n + 1) depth of the tree, n for templist, n for box.
            Note:  we did not take into account the space needed to hold the results. Otherwise, the space complexity would become
                   O(N⋅N!).

            Explanation: qpsf -> queen placed so far, tq = k i.e. -> total queens to be placed.
        */

        if(qpsf == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0; i < box.length; i++) {
            if(!box[i]) {
                box[i] = true;
                tempList.add(nums[i]);
                approachTwo(list, tempList, box, nums, qpsf + 1);
                tempList.remove(tempList.size() - 1);
                box[i] = false;

            }
        }
    }

    private void approachThree(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        /*  Same as queen permutation 1D wrt box where no. of total queens is same as box size.
            Approach: BackTracking
            Time Complexity:  O(∑(k=1 to N) nPn) or O(n * n!)
            Space Complexity: O((n + 1) + n), (n + 1) depth of the tree, n for templist.
            Note:  we did not take into account the space needed to hold the results. Otherwise, the space complexity would become
                   O(N⋅N!).

        */

        if(tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!tempList.contains(nums[i])) {
                tempList.add(nums[i]);
                approachThree(list, tempList, nums);
                tempList.remove(tempList.size() - 1);

            }
        }
    }

}
