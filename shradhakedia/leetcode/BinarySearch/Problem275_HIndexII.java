/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/h-index-ii/
 * Difficulty level : Medium
 */

package leetcode.BinarySearch;

public class Problem275_HIndexII {

    public int hIndex(int[] citations) {
        return approachTwo(citations);
    }

    private int approachOne(int[] citations) {
        /* Approach 1: Binary Search;
           Time Complexity: O(n)
           Space Complexity: O(1)
        */

        int len = citations.length;
        int low = 0;
        int high = len - 1;

        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            int windowSize = len - mid;
            if(windowSize < citations[mid]) {
                high = mid - 1;
            } else if(windowSize == citations[mid]) {
                return windowSize;
            } else { // windowSize > citations[mid]
                low = mid + 1;
            }
        }
        return len - low;
    }

    private int approachTwo(int[] citations) {
        /* Approach 2: Brute Force;
           Time Complexity: O(n)
           Space Complexity: O(1)
        */

        int len = citations.length;
        for(int i = 0; i < len; i++) {
            if(citations[i] >= len - i) {
                return len - i;
            }
        }
        return 0;
    }
}
