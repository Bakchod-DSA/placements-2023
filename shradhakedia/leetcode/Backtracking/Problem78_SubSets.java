/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/subsets/
 * Difficulty level: Medium
 */

package leetcode.Backtracking;

import java.util.*;

public class Problem78_SubSets {

    public List<List<Integer>> subsets(int[] nums) {

        /*
        // Approach 1:
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
            powerSet.add(subSet);
        }

        return powerSet;
        */

        /*
        // Approach 2: iterative
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < (1 << i); j++) {
                List<Integer> newList = new ArrayList<>(powerSet.get(j));
                newList.add(nums[i]);
                powerSet.add(newList);
            }
        }
        return powerSet;
        */

        // return approachThree(nums, 0);

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        approachFour(list, tempList, nums, -1);
        return list;

    }

    private List<List<Integer>> approachThree(int[] nums, int start) {
        // Approach 3: Recursion

        if(start == nums.length - 1) {
            List<List<Integer>> baseList = new ArrayList<>();
            baseList.add(new ArrayList<>());
            baseList.add(new ArrayList<>(Arrays.asList(nums[start])));
            return baseList;
        }

        List<List<Integer>> recurList = approachThree(nums, start + 1);
        List<List<Integer>> myList = new ArrayList<>();
        for(List<Integer> sublist : recurList) {
            myList.add(sublist);

            List<Integer> temp = new ArrayList<>();
            temp.add(nums[start]);
            temp.addAll(sublist);

            myList.add(temp);
        }

        return myList;
    }

    private void approachFour(List<List<Integer>> list, List<Integer> tempList, int[] nums, int lastUsed) {
        /*  Time complexity:  O(n * 2 ^ n) to generate all subsets and then copy them into output list.
            Space complexity: O(n),  n is depth of the tree.
            Note: for space complexity analysis, we do not count space that is only used for the purpose of returning output,
                  so the output array is ignored.
        */

        list.add(new ArrayList<>(tempList));

        for(int i = lastUsed + 1; i < nums.length; i++) {
            tempList.add(nums[i]);
            approachFour(list, tempList, nums, i);
            tempList.remove(tempList.size() - 1);

        }
    }

}
