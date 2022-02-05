/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/permutations-ii/
 * Difficulty level: Medium
 */

package leetcode.Recursion;

import java.util.*;

public class Problem47_PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        return approachOne(nums, 0);

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

}
