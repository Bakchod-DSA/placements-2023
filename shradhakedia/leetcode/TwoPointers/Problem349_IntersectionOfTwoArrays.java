/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/intersection-of-two-arrays/
 * Difficulty level : Easy
 */

package leetcode.TwoPointers;

import java.util.*;

public class Problem349_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {

        // ApproachOne: Two Pointers; Time Complexity: O(nlogn + mlogm + min(m,n)), Space Complexity: O(1)
        // return approachOne(nums1, nums2);

        // ApproachTwo: BinarySearch; Time Complexity: O(nlogn + mlogm + nlogm) where n << m,
        //              Space Complexity: O(1)
        if(nums1.length < nums2.length) {
            return approachTwo(nums1, nums2);
        } else {
            return approachTwo(nums2, nums1);
        }

        // ApproachThree: Make one list set, traverse the other list find if element exits in set, if yes add to
        //                result and remove from set.
        //                Time Complexity: O(m + n) one loop to convert one list to set, and one loop to traverse the other
        //                Space Complexity: O(n)
    }

    private int[] approachOne(int[] nums1, int[] nums2) {
        int[] intersection = new int[nums1.length];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int k = 0;
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if(nums1[i] == nums2[j]) {
                intersection[k++] = nums2[j];
                while(i + 1 < nums1.length && nums1[i] == nums1[i + 1]) {
                    i++;
                }
                while(j + 1 < nums2.length && nums2[j] == nums2[j + 1]) {
                    j++;
                }
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOf(intersection, k);
    }

    private int[] approachTwo(int[] nums1, int[] nums2) {
        int[] intersection = new int[nums1.length];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int k = 0;
        // traverse in shorter array search in longer array.
        for(int i = 0; i < nums1.length; i++) {
            if(binarySearch(nums1[i], nums2)) {
                intersection[k++] = nums1[i];
            }
            while(i + 1 < nums1.length && nums1[i] == nums1[i + 1]) {
                i++;
            }
        }

        return Arrays.copyOf(intersection, k);
    }

    private boolean binarySearch(int target, int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + ((high - low) >> 2);
            if(nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
