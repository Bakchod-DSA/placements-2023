/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1#
 * Difficulty level: Medium
 */
package ExternalSources.Array;

import java.util.*;

public class Problem_LargestSubarrayWithSumZero {
    int maxLen(int arr[], int n)
    {
        Map<Integer, Integer> prefixSumToIndex = new HashMap<>();
        int sum = 0, maxLen = 0;
        prefixSumToIndex.put(0, -1);

        for(int i = 0; i < n; i++) {
            sum += arr[i];
            if(prefixSumToIndex.containsKey(sum)) {
                maxLen = Math.max(i - prefixSumToIndex.get(sum), maxLen);
            } else {
                prefixSumToIndex.put(sum, i);
            }
        }

        return maxLen;
    }
}
