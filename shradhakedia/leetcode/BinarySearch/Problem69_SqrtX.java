/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/sqrtx/
 * Difficulty level : Easy
 */

package leetcode.BinarySearch;

public class Problem69_SqrtX {

    public int mySqrt(int x) {
        return (x == 0)? 0 : approachTwo(x);
    }

    private int approachOne(int x) {
        // Approach 1: Binary Search
        // Time Complexity: O(log x), Space Complexity: O(1)
        int low = 1;
        int high = x;

        while(low < high) {
            int mid = high - ((high - low) >> 1);
            int sqrt = x / mid;
            if(mid == sqrt) {
                return mid;
            } else if(mid < sqrt) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private int approachTwo(int x) {
        // Approach 2: Bit Manipulation;
        // Time Complexity: O(16) i.e. O(1), Space Complexity: O(1)
        int mask = 1 << 16;
        int ans = 0;
        while(mask > 0) {
            ans |= mask; //set bit
            if(ans > x / ans) {
                ans ^= mask;
            }
            mask >>>= 1;
        }
        return ans;
    }
}
