package EPI.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Problem11_7_ImplementStackUsingHeap {

    // Stack uses maxHeap based on time stamp.
    public static class Stack {

        private Queue<int[]> maxHeap;
        private int timeStamp;

        public Stack() {
            maxHeap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
            timeStamp = 0;
        }

        private void push(int num) {
            // Time Complexity: O(log n), n is no. of elements in heap.

            int[] toPush = new int[]{num, timeStamp++};
            maxHeap.add(toPush);
        }

        private int pop() {
            // Time Complexity: O(log n), n is no. of elements in heap.

            if(maxHeap.isEmpty()) {
                throw new NullPointerException();
            }
            return maxHeap.poll()[0];
        }

        private int peek() {
            // Time Complexity: O(1)

            if(maxHeap.isEmpty()) {
                throw new NullPointerException();
            }
            return maxHeap.peek()[0];
        }
    }

    // Queue uses minHeap based on time stamp.
    public static class Queue1 {

        private Queue<int[]> minHeap;
        private int timeStamp;

        public Queue1() {
            minHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            timeStamp = 0;
        }

        private void push(int num) {
            // Time Complexity: O(log n), n is no. of elements in heap.

            int[] toPush = new int[]{num, timeStamp++};
            minHeap.add(toPush);
        }

        private int pop() {
            // Time Complexity: O(log n), n is no. of elements in heap.

            if(minHeap.isEmpty()) {
                throw new NullPointerException();
            }
            return minHeap.poll()[0];
        }

        private int peek() {
            // Time Complexity: O(1)

            if(minHeap.isEmpty()) {
                throw new NullPointerException();
            }
            return minHeap.peek()[0];
        }
    }

}
