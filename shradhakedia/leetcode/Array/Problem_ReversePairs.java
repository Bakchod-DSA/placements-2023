/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/reverse-pairs/
 * Difficulty level: Hard
 */
package leetcode.Array;

public class Problem_ReversePairs {
    int count = 0;

    public int reversePairs(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return count;
    }

    private void sort(int[] nums, int l, int r) {
        if(l < r) {
            int mid = l + ((r - l) >> 1);
            sort(nums, l, mid);
            sort(nums, mid + 1, r);

            merge(nums, l, r, mid);
        }
    }

    private void merge(int[] nums, int l, int r, int m) {
        int n1 = m - l + 1;
        int n2 =  r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; ++i)
            left[i] = nums[l + i];
        for (int j = 0; j < n2; ++j)
            right[j] = nums[m + 1 + j];

        // compute the ans
        int j = 0;
        for(int i = 0; i < n1; i++) {
            while(j < n2) {
                if(left[i] > (long) 2 * right[j]) j++;
                else break;
            }
            count += j;
        }

        int i, k = l;
        for(i = 0, j = 0; i < n1 && j < n2;) {
            if(left[i] > right[j]) {
                nums[k++] = right[j++];
            } else {
                nums[k++] = left[i++];
            }
        }

        while(i < n1) {
            nums[k++] = left[i++];
        }
        while(j < n2) {
            nums[k++] = right[j++];
        }
    }
}
