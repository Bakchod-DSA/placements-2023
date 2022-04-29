/**
 * Author : Sradha Kedia
 * Coding block Problem
 * Difficulty level : Easy
 */

package ExternalSources.Recursion;

public class IsArraySorted {

    public static void main(String[] args) {

        System.out.println(isSorted(new int[]{2,2,4,5,7,6}, 0));
    }

    private static boolean isSorted(int[] nums, int start) {
        /* Approach: Recursion
           Time Complexity: O(n)
           Space Complexity: O(n), recursion stack
        */

        if(start == nums.length - 1) {
            return true;
        }

        if(nums[start] > nums[start + 1]) {
            return false;
        }
        return isSorted(nums, start + 1);
    }

}
