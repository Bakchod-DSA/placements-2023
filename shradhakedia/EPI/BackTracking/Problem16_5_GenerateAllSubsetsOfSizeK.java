/**
 * Author : Sradha Kedia
 * Page no.: 291 of Epi Java
 * Problem no.: 16.5
 * Difficulty level : Medium
 */

package EPI.BackTracking;

import java.util.*;

public class Problem16_5_GenerateAllSubsetsOfSizeK {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int [] nums = new int[] {1,2,3};

        generateSubsetsOfSizeK(list, tempList, nums, 3, -1);

        System.out.println(list);
    }


    private static void generateSubsetsOfSizeK(List<List<Integer>> list, List<Integer> tempList, int[] nums, int k, int lastUsed) {

        if(tempList.size() == k) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = lastUsed + 1; i < nums.length; i++) {
            tempList.add(nums[i]);
            generateSubsetsOfSizeK(list, tempList, nums, k, i);
            tempList.remove(tempList.size() - 1);
        }
    }

}
