/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/3sum/
 * Difficulty level: Medium
 */

package leetcode.TwoPointers;

import java.util.*;

public class Problem15_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        int length = nums.length;
        if(length < 3) return new ArrayList<>();

        List<List<Integer>> threeSumList = new ArrayList<>();
        Arrays.sort(nums);

        /*
        // Binary Search; Time Complexity: O(nlog(n) + n^2(log(n) * n)) = O(n^3) approx, gives TLE.
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                int sum = 0 - (nums[i] + nums[j]);
                int target = binarySearch(nums, j + 1, sum);

                if(target != -1) {
                    List<Integer> threeSumTriplet = new ArrayList<>();
                    threeSumTriplet.add(nums[i]);
                    threeSumTriplet.add(nums[j]);
                    threeSumTriplet.add(nums[target]);
                    // O(n) complexity
                    if(!threeSumList.contains(threeSumTriplet)) {
                        threeSumList.add(threeSumTriplet);
                    }
                }
            }
        }

        return threeSumList;
        */

        // Approach 2: Two pointers
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) break;
            if(i == 0 || (nums[i] != nums[i - 1])) {
                for(int j = i + 1, k = nums.length - 1; j < k; ) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0) {
                        List<Integer> threeSumTriplet = new ArrayList<>();
                        threeSumTriplet.add(nums[i]);
                        threeSumTriplet.add(nums[j]);
                        threeSumTriplet.add(nums[k]);
                        threeSumList.add(threeSumTriplet);
                        while(j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
                        while(k > 1 && nums[k] == nums[k - 1]) k--;
                        j++;
                        k--;
                    } else if(sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }

        return threeSumList;
    }

    private int binarySearch(int[] nums, int start, int target) {
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + ((end - start) >> 2);
            System.out.println(start + ", " + mid);
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

/**
 * Approach 1: Binary Search; Time Complexity: O(n^3) gives TLE, Space Complexity: O(1)
 *
 * Approach 2: Two Pointers; Time Complexity: O(n^2), Space Complexity: O(1)
 *             NOTE: the problem is similar to LeetCode 2sum but the only thing is here the triplet is not unique
 *                   it can be more than one, and we have to also take care of those triplets that can appear more
 *                   than once.
 *            Intuition: we start with one i from beginning, try to find j,k s.t the sum of triplet is 0, if we get that
 *                       we contribute those to our result and then skip all the nos. that are equal to j and k
 *                       because we dont want the same triplet again. if sum is less we increment j if more we decrement
 *                       k. and to start with i we also take care we never go for same i's because we can get same triplet
 *                       again so we check this condition also. And WE CAN OPTIMIZE EVEN MORE by checking if nums[i] > 0
 *                       then we simply break because the array is sorted and we can get any triplet now after this index.
 *
 */