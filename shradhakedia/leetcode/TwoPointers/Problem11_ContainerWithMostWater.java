/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/container-with-most-water/
 * Difficulty level: Medium
 */

package leetcode.TwoPointers;

public class Problem11_ContainerWithMostWater {
    
    public int maxArea(int[] height) {
        
        // Approach 1: Two Pointers;
        int amt = 0;
        
        for(int i = 0, j = height.length - 1; i < j; ) {
            amt = Math.max(amt, (j - i) * Math.min(height[i], height[j]));
            if(height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            } 
        }
        return amt;
    }
}

/**
 * Problem Discuss (must see): https://leetcode.com/problems/container-with-most-water/discuss/6099/Yet-another-way-to-see-what-happens-in-the-O(n)-algorithm
 * Approach 1: Two Pointers; Time Complexity:O(n), Space Complexity:O(1)
 *             Intuition: The idea here is that amt of water is calculated as width * min height of the two lines.
 *                        amt is maximum when width and height are max. now the idea is to put pointers, one at first
 *                        the other at last(width is max in this case). now, what we need to do is shift these pointers based on
 *                        certain conditions:
 *                        left = 0, right = n - 1 => if line[left] < line[height] its for sure height role is contributed by left line
 *                        so, how much we decrement the right it won't affect the amt. eg: 2, 11, 10, 8
 *                        if we see amt between 2, 8 = width * height = 3 * 2; now if we move right to 10, it will only decrease
 *                        the amt. so, its better to increment left. //ly for right if its less than left, its always better to decrement
 *                        right. NOTE: (if both are equal, we can move any of the two.)
 *
 */
