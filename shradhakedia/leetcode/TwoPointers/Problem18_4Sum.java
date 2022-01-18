/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/4sum/
 * Difficulty level: Medium
 */

package leetcode.TwoPointers;

import java.util.*;

public class Problem18_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return recursiveKSum(4, nums, 0, target);
    }

    private List<List<Integer>> recursiveKSum(int k, int[] nums, int start, int target) {
        if(k == 2) {
            List<List<Integer>> baseTwoSumList = new ArrayList<>();
            for(int begin = start, end = nums.length - 1; begin < end; ) {
                int twoSum = nums[begin] + nums[end];
                if(twoSum == target) {
                    List<Integer> baseTwoSumPair = new ArrayList<>();
                    baseTwoSumPair.add(nums[begin]);
                    baseTwoSumPair.add(nums[end]);
                    baseTwoSumList.add(baseTwoSumPair);
                    while(begin < nums.length - 1 && nums[begin] == nums[begin + 1]) {
                        begin++;
                    }
                    while(end > 1 && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    begin++;
                    end--;
                } else if(twoSum < target) {
                    begin++;
                } else {
                    end--;
                }
            }
            return baseTwoSumList;
        }

        List<List<Integer>> recursiveKSumList = new ArrayList<>();
        for(int i = start; i < nums.length; i++) {
            if(i == start || nums[i] != nums[i - 1]) {
                for(List<Integer> sublist : recursiveKSum(k - 1, nums, i + 1, target - nums[i])) {
                    recursiveKSumList.add(new ArrayList<>(Arrays.asList(nums[i])));
                    recursiveKSumList.get(recursiveKSumList.size() - 1).addAll(sublist);
                }
            }
        }

        return recursiveKSumList;
    }
}
