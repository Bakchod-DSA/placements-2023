/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/design-circular-queue/
 * Difficulty level: Medium
 */

package leetcode.StackAndQueue;

public class Problem622_DesignCircularQueue {

    class MyCircularQueue {
        int size;
        int capacity;
        int front;
        int rear;
        int[] queue;

        public MyCircularQueue(int k) {
            this.capacity = k;
            this.queue = new int[capacity];
            this.size = 0;
            this.front = 0;
            this.rear = -1;
        }

        public boolean enQueue(int value) {
            if(isFull()) return false;
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()) return false;
            front = (front + 1) % capacity;
            size--;
            return true;
        }

        public int Front() {
            if(isEmpty()) return -1;
            return queue[front];
        }

        public int Rear() {
            if(isEmpty()) return -1;
            return queue[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
