/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Difficulty level : Hard
 */

package leetcode.BinarySearch;

public class Problem4_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         return approachTwo(nums1, nums2);
        // return approachOne(nums1, nums2);
    }

    private double approachOne(int[] nums1, int[] nums2) {
        /*  Brute Force;
            Time Complexity:  O(k)
            Space Complexity: O(1)
            Intuition:  find kth smallest element in two sorted arrays. now, if m + n is odd we need to find
                        median = (m + n + 1/ 2)th smallest element. If, m + n is even we need to find (m + n + 1/ 2)th
                        and (m + n + 1/ 2) + 1 th smallest elements and median is average of these two.
        */

        int m = nums1.length;
        int n = nums2.length;
        int k = (m + n + 1) >> 1;

        if(((m + n) & 1) == 1) {
            int[] ans = findKSmallestElement(nums1, nums2, k, 0);
            return (double) ans[0];
        } else {
            int[] ans = findKSmallestElement(nums1, nums2, k, 1);
            return (double) (ans[0] + ans[1]) / 2.00;
        }

    }

    private int[] findKSmallestElement(int[] nums1, int[] nums2, int k, int type) {
        int[] ans = new int[2];

        int m = nums1.length;
        int n = nums2.length;

        int i = 0, j = 0;
        while((i < m) && (j < n) && k > 1) {
            if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
            k--;

        }

        if(i < m && j < n && k == 1) {
            // type = 1 -> m + n is even
            if(nums1[i] < nums2[j]) {
                ans[0] = nums1[i];
                ans[1] = (type == 1)? (i + 1) < m? Math.min(nums1[i + 1], nums2[j]) : nums2[j] : 0;
            } else {
                ans[0] = nums2[j];
                ans[1] = (type == 1)? (j + 1) < n? Math.min(nums2[j + 1], nums1[i]) : nums1[i] : 0;

            }

            return ans;
        }
        if(i < m) {
            ans[0] = nums1[i + k - 1];
            if(type == 1) { // m + n is even
                ans[1] = nums1[i + k];
            }
            return ans;
        } else {
            ans[0] = nums2[j + k - 1];
            if(type == 1) { // m + n is even
                ans[1] = nums2[j + k];
            }
            return ans;
        }
    }

    private double approachTwo(int[] nums1, int[] nums2) {
        /*  Binary Search;
            Time Complexity:    O(log(min(m, n)))
            Space Complexity:   O(1)
        */

        return (nums1.length < nums2.length)? findMedian(nums1, nums2) : findMedian(nums2, nums1);
    }

    private double findMedian(int[] A, int[] B) {
        /*
         Binary Search
         Time Complexity:    O(log(min(m, n)))
         Space Complexity:   O(1)
         You Tube Link: https://www.youtube.com/watch?v=LPFhl65R7ww&t=2s
        */

        int m = A.length;
        int n = B.length;

        int low = 0;
        int high = m;

        while(low <= high) {

            // partitionA + partitionB = (m + n + 1)/2
            // divide A and B into two parts, s.t. length(leftPart) = length(rightPart), when total even length.
            // length(leftPart) + 1 = length(rightPart), when total odd length.
            int partitionA = low + ((high - low) >> 1);
            int partitionB = (m + n + 1)/2 - partitionA;

            // calculate the left and right partition elements of Array A
            int maxLeftA = (partitionA == 0)? Integer.MIN_VALUE : A[partitionA - 1];
            int minRightA = (partitionA == m)? Integer.MAX_VALUE : A[partitionA];

            // calculate the left and right partition elements of Array B
            int maxLeftB = (partitionB == 0)? Integer.MIN_VALUE : B[partitionB - 1];
            int minRightB = (partitionB == n)? Integer.MAX_VALUE : B[partitionB];

            // if found that whole left part is less than the whole right part, calculate the ans
            if(maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if(((m + n) & 1) == 1) {
                    return (double) Math.max(maxLeftA, maxLeftB);
                } else {
                    return (double) (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB))/2.00;
                }
            }
            //if left part has greater elements than right part, then next two cases
            else if(maxLeftA > minRightB) {
                // if left part exceedes greater elements due to array A, decrease the partion by 1.
                high = partitionA - 1;
            } else { // maxLeftB > minRightA
                // if left part exceedes greater elements due to array B, increase the partion by 1.
                low = partitionA + 1;
            }
        }

        return -1; // comes here only when input is not valid (unsorted array), we can throw illegal state exception here.
    }

}
