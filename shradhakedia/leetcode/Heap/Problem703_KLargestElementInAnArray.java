/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * Difficulty level: Easy
 */

package leetcode.Heap;

import java.util.*;

public class Problem703_KLargestElementInAnArray {

    static class KthLargest {

        int k;
        PriorityQueue<Integer> minHeap;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.minHeap = new PriorityQueue<>(k);

            for (int num : nums) {
                minHeap.add(num);

                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }

        public int add(int val) {

            minHeap.add(val);

            if(minHeap.size() > k) {
                minHeap.poll();
            }

            return minHeap.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

}
