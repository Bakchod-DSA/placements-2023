/**
 * Author : Sradha Kedia
 * Link   : https://www.youtube.com/watch?v=AZ4jEY_JAVc&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=6
 * Difficulty level : Easy
 */

package ExternalSources.Recursion;

import java.util.Arrays;

public class SortAnArray {

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,1,6,3};
        sorting(nums, 0);
        System.out.println(Arrays.toString(nums));

    }

    private static void sorting(int[] nums, int start) {
        // sorting in increasing order.

        if(start == nums.length - 1) {
            return;
        }

        sorting(nums, start + 1);
        for (int i = start; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
