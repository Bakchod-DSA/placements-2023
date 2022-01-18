/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/3sum-closest/
 * Difficulty level: Medium
 */

package leetcode.TwoPointers;

import java.util.*;

public class Problem16_ThreeSumClosest {

    // similar to 3Sum
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[nums.length - 1]; // since we are starting from here

        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1, k = nums.length - 1; j < k; ) {
                int threeSum = nums[i] + nums[j] + nums[k];
                closestSum = (Math.abs(target - threeSum) < Math.abs((target - closestSum)))? threeSum : closestSum;
                if(threeSum == target) {
                    return threeSum;
                } else if(threeSum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return closestSum;

    }
}
