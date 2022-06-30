/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/furthest-building-you-can-reach/
 * Difficulty level: Medium
 */

package leetcode.Heap;

import java.util.*;

public class Problem1642_FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        return approachOne(heights, bricks, ladders);
    }

    private int approachOne(int[] heights, int bricks, int ladders) {

        Queue<Integer> minHeap = new PriorityQueue<>();
        int prev = heights[0];
        for(int i = 1; i < heights.length; i++) {
            int curr = heights[i];
            if(curr - prev > 0) {
                minHeap.add(curr - prev);
            }

            if(minHeap.size() > ladders) {
                int d = minHeap.poll();
                if(d <= bricks) {
                    bricks -= d;
                } else {
                    return i - 1;
                }
            }
            prev = curr;
        }

        return heights.length - 1;
    }
}
