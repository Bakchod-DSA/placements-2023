/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/merge-sorted-array/
 * Difficulty level: Medium
 */

package leetcode.TwoPointers;

public class Problem88_MergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        /*
        int j = 0;
        int lastIndex = m;
        for(int i = 0; m < nums1.length; ) {
              if(i < m && nums1[i] <= nums2[j]) {
                  i++;
              } else {
                  lastIndex = m;
                  m++;
                  while(lastIndex > i) {
                      nums1[lastIndex] = nums1[lastIndex - 1];
                      lastIndex--;
                  }
                  nums1[i] = nums2[j++];
              }
         }
         */


        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if(nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
