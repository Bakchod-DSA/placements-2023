/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-median-from-data-stream/
 * Difficulty level: Hard
 */

package leetcode.Heap;

import java.util.*;

public class Problem295_FindMedianFromDataStream {

    class MedianFinder {

        Queue<Integer> minHeap;
        Queue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((e1, e2) -> e2 - e1);
        }

        public void addNum(int num) {
            if(streamSize() == 0) {
                maxHeap.offer(num);
            } else {
                if((streamSize() & 1) == 0) {
                    // even, we have to increment maxHeap Size by 1, by inserting either num or top of min heap.
                    if(num <= minHeap.peek()) {
                        maxHeap.offer(num);
                    } else {
                        // num > minHeap top.
                        int smallerEle = minHeap.poll();
                        maxHeap.offer(smallerEle);
                        minHeap.offer(num);
                    }
                } else {
                    // odd, we have to increment minHeap size by 1, by inserting bigger of num or max heap top
                    if(num >= maxHeap.peek()) {
                        minHeap.offer(num);
                    } else {
                        // num < maxHeap top
                        int largerEle = maxHeap.poll();
                        minHeap.offer(largerEle);
                        maxHeap.offer(num);
                    }
                }
            }
        }

        public double findMedian() {
            if((streamSize() & 1) == 0) {
                return (maxHeap.peek() + minHeap.peek())/2.0;
            }

            return maxHeap.peek();
        }

        private int streamSize() {
            return minHeap.size() + maxHeap.size();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
