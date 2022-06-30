/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/kth-missing-positive-number/
 * Difficulty level: Easy
 */
package leetcode.BinarySearch;

import java.util.*;

public class Problem1539_KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        return bs(arr, k);
    }

    private int approachOne(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for(int a : arr) {
            set.add(a);
        }

        int count = 0;
        for(int i = 1; i <= arr.length + k; i++) {
            if(!set.contains(i)) {
                count++;
            }

            if(count == k) return i;
        }

        return -1;
    }

    private int bs(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while(low < high) {
            int mid = low + (high - low)/2;
            int missingNums = arr[mid] - mid - 1;
            if(missingNums < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if(low == arr.length - 1 && arr[arr.length - 1] - arr.length < k) return arr.length + k;
        else return high + k;
    }
}
