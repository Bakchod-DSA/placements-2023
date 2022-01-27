package LeetCode.binarySearch;

/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Difficulty level : Hard
 */

public class problem0004MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // return bruteForce(nums1, nums2);
        return approachOne(nums1, nums2);
    }
    /*
    Binary Search
    Time : log(min(n, m))
    Space : constant (except recursive stack)
    We will run our bs on min len array, to ge that,
    we will use recursive call with min len array as frst parameter.

    */
    private double approachOne(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return approachOne(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int l = 0;
        int h = n1;

        while (l <= h) {
            // We will partition two arrays in such a way that left = right or left > right + 1
            int partition1 = (l + h) >> 1;
            int partition2 = ((n1 + n2 + 1)>>1) - partition1;

            // find the max and min ele of both the parted arrays,
            // if any array is partioned at start, then we will consider minLeft ele as Integer.MIN_VALUE
            // Similarly if any array is partioned at end, then we will consider maxRight ele as Integer.MAX_VALUE
            // else keep min and max as partition - 1 ans partition respectively

            int maxLeftX = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int maxLeftY = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRightX = partition1 == n1 ? Integer.MAX_VALUE : nums1[partition1];
            int minRightY = partition2 == n2 ? Integer.MAX_VALUE : nums2[partition2];

            // This is the case when we have well partioned arrays
            // Find median keeping the sum of len of Arrays in mind
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if (((n1 + n2) & 1) != 0) {
                    return (double)Math.max(maxLeftX, maxLeftY);
                } else {
                    return (double)(Math.max(maxLeftX, maxLeftY)
                            + Math.min(minRightX, minRightY))/2;
                }
                // In this case, we are too ahead of required partition
                // Hence we will reduce out high
                // [1,8,9,10] and [4,5,6,7] partition1 = 2, partition2 = 2 i.e. 8 > 6
            } else if (maxLeftX > minRightY) {
                h = partition1 - 1;
                // In this case we are too behind of required partition
                // Hence, we will increment out low
                // [1,2,3,7] and [4,5,6,8] partition1 = 2, partition2 = 2 i.e. 3 < 5
            } else {
                l = partition1 + 1;
            }
        }
        // We will neevr reach end only except if arrays are not sorted well
        return 0.0;
    }

    /*
    Brute Force
    Time : O(m + n);
    Space : O(m + n);
    algo : merge sort two arrays in a single sorted array
    and find median keeping the sum of len of arrays in mind
    */
    private double bruteForce(int[] nums1, int[] nums2) {
        List<Integer> arr = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                arr.add(nums1[i] > nums2[j] ? nums2[j++] : nums1[i++]);
            } else if (i < nums1.length) {
                arr.add(nums1[i++]);
            } else if (j < nums2.length) {
                arr.add(nums2[j++]);
            }
        }
        int s = arr.size();
        if ((arr.size() & 1) != 0) {
            return arr.get(s/2);
        }
        return (double)(arr.get(s/2) + arr.get((s - 1)/2))/2;
    }
}
