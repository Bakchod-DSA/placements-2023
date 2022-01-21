/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/first-bad-version/
 * Difficulty level : Easy
 */

package leetcode.BinarySearch;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Problem278_FirstBadVersion {
    public int firstBadVersion(int n) {

        /*
        // Approach 1: Binary Search
        // Time Complexity: O(log n), Space Complexity: O(1)
        int low = 1;
        int high = n;
        while(low < high) {
            int mid = low + ((high - low) >> 1);
            if(isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
        */

        return 0;
    }


}
