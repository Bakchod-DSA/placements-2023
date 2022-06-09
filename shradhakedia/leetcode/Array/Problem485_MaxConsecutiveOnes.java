/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/max-consecutive-ones/
 * Difficulty level: Easy
 */
package leetcode.Array;

public class Problem485_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, count = 0;
        for(int num : nums) {
            if(num == 1) count++;
            else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }

        return Math.max(maxCount, count);
    }
}
