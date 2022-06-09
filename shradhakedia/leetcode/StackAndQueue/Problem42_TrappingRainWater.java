/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/trapping-rain-water/
 * Difficulty level: Hard
 */
package leetcode.StackAndQueue;

public class Problem42_TrappingRainWater {
    public int trap(int[] height) {
        // return approachOne(height);
        return approachTwo(height);
    }

    private int approachOne(int[] height) {
        /*  Approach: brute force
            Time Complexity: O(3n)
            Space Complexity: O(2n)
        */
        int n = height.length;
        int[] maxL = new int[n];
        int[] maxR = new int[n];
        int water = 0;
        maxL[0] = height[0];
        maxR[n - 1] = height[n - 1];
        for(int i = 1; i < n; i++) {
            maxL[i] = Math.max(maxL[i - 1], height[i]);
        }
        for(int i = n - 2; i >= 0; i--) {
            maxR[i] = Math.max(maxR[i + 1], height[i]);
        }
        for(int i = 0; i < n; i++) {
            int min = Math.min(maxL[i], maxR[i]);
            water += (min - height[i]);
        }

        return water;
    }

    private int approachTwo(int[] height) {
        /*  Approach: two pointers
            Time Complexity: O(n)
            Space Complexity: O(1)
            Explanation: In first approach, we made leftMax, rightMax array, but here we find that leftMax and
                         rightMax which is useful and store it in a variable. saving the space complexity.
        */
        int n = height.length;
        int water = 0;
        int left = 0, right = n - 1, leftMax = 0, rightMax = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                // means we have got a right building which can trap the water at top of the curr building
                // leftMax stores the left array maximum.
                if(height[left] >= leftMax) {
                    // store max from left, no need to add this to answer as this is maximum, it cannot store
                    // water at top of it due to no support from the left side.
                    leftMax = height[left];
                } else {
                    // amt of water stored at the top of the building at left index
                    water += (leftMax - height[left]);
                }
                left++;
            } else {
                // right is smaller so we have got a support from left, we want to find amt of water stored at the
                // top of the building at the right index now.
                if(height[right] >= rightMax) {
                    // store max from right, no need to add this to answer as this is maximum, it cannot store
                    // water at top of it due to no support from the right side.
                    rightMax = height[right];
                } else {
                    // amt of water stored at the top of the building at right index
                    water += (rightMax - height[right]);
                }
                right--;
            }
        }
        return water;
    }
}
