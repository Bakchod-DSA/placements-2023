/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/majority-element-ii/
 * Difficulty level: Medium
 */

package leetcode.HashTable;

import java.util.*;

public class Problem229_MajorityElementsII {

    public List<Integer> majorityElement(int[] nums) {
        // return approachOne(nums);
        return approachTwo(nums);
    }

    private List<Integer> approachOne(int[] nums) {
        /*  Approach: HashTable
            Time Complexity: O(n + k), k is the size of the map
            Space Complexity: O(n)
        */

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<Integer>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > nums.length/3) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }

    private List<Integer> approachTwo(int[] nums) {
        /*  Approach: Boyer-Moore Voting Algorithm
            Time Complexity: O(2n)
            Space Complexity: O(1)
        */

        int count1 = 0, count2 = 0;
        Integer candidate1 = 0, candidate2 = 0;

        for(int num : nums) {

            if(num == candidate1) {
                count1++;
            } else if(num == candidate2) {
                count2++;
            } else if(count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if(count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0; count2 = 0;
        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            } else if(num == candidate2) {
                count2++;
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        if(count1 > nums.length / 3) {
            ans.add(candidate1);
        }
        if(count2 > nums.length / 3) {
            ans.add(candidate2);
        }
        return ans;
    }

}
