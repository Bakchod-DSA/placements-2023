/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * Difficulty level: Medium
 */
package leetcode.BinarySearch;

import java.util.*;

public class Problem315_CountOfNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] countSmallerThanSelf = new Integer[n];
        List<Integer> sorted = new ArrayList<>();

        for(int i = n - 1; i >= 0; i--) {
            int index = findPositionInNumsSortedVersion(sorted, nums[i]);
            countSmallerThanSelf[i] = index;
        }

        return Arrays.asList(countSmallerThanSelf);
    }

    private int findPositionInNumsSortedVersion(List<Integer> sorted, int num) {
        if(sorted.isEmpty()) {
            sorted.add(num);
            return 0;
        }

        int low = 0, high = sorted.size() - 1;
        int index = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(sorted.get(mid) >= num) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if(index == -1) {
            sorted.add(num);
            return sorted.size() - 1;
        } else {
            sorted.add(index, num);
            return index;
        }
    }
}
