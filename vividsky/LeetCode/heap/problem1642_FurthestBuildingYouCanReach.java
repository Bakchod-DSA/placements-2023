package LeetCode.heap;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/furthest-building-you-can-reach/
 * Difficulty level : Medium
 */
public class problem1642_FurthestBuildingYouCanReach {
    /**
     Heap

     Time : O(NlogN) where N = heights.length
     Space: O(N)
     Algo : keep count of bricksUsed
     maxHeap will store the height differences
     for non positive differences -> move forward
     for negative differences -> increment bricksUsed by difference
     if bricksUsed > bricks available -> only way to move forward is by using ladder
     if bricksUsed > bricks available and we are out of ladders -> no way to move forward, hence return current idx - 1
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int bricksUsed = 0;

        for (int i = 1; i < heights.length; i++) {

            int diff = heights[i] - heights[i - 1];

            if (diff > 0) {
                heap.add(diff);
            }

            bricksUsed += diff > 0 ? diff : 0;

            if (bricksUsed > bricks && ladders > 0) {
                ladders--;
                bricksUsed -= heap.poll();
            } else if (bricksUsed > bricks) {
                return i - 1;
            }
        }
        return heights.length - 1;
    }
}
