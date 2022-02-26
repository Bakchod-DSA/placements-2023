/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/ugly-number-ii/
 * Difficulty level: Medium
 */

package leetcode.Heap;

import java.util.*;

public class Problem264_UglyNumberII {

    public int nthUglyNumber(int n) {
        return approachOne(n);
    }

    private int approachOne(int n) {
        /*  Approach: Priority Queue
            Time Complexity: O(n log n)
            Space Complexity: O(n)
        */


        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        minHeap.add(1L);

        for(int i = 1; i < n; i++) {
            long temp = minHeap.poll();
            while(!minHeap.isEmpty() && temp == minHeap.peek()) {
                temp = minHeap.poll();
            }

            minHeap.add(temp * 2);
            minHeap.add(temp * 3);
            minHeap.add(temp * 5);
        }

        return minHeap.poll().intValue();
    }

}
