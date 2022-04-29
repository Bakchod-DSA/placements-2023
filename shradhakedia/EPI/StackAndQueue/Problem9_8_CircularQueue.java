/**
 * Author : Sradha Kedia
 * Page no.: 145, 146 of Epi Java
 * Problem no.: 9.8
 * Difficulty level : Medium
 */

package EPI.StackAndQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Problem9_8_CircularQueue {

    public static class Queue {
        private int capacity, size = 0, head = 0, tail = 0;
        private static final int SCALE_FACTOR = 2;
        private Integer[] elements;

        public Queue(int capacity) {
            this.capacity = capacity;
            this.elements = new Integer[capacity];
        }

        private boolean isEmpty() {
            return size == 0;
        }
        private boolean isFull() {
            return size == capacity;
        }
        public void enqueue(Integer x) {
            if(isFull()) {
                // Collections.rotate(list,distance) -> rotates the list by setting last |distance| elements before and then
                // placing the elements before distance after that. eg: list = [1,2,3,4,5] dis = 3 -> rotated list = [3, 4, 5, 1, 2]
                Collections.rotate(Arrays.asList(elements),capacity - head);
                elements = Arrays.copyOf(elements, SCALE_FACTOR * capacity);
                capacity *= SCALE_FACTOR;
                head = 0;
                tail = size;
            }
            elements[tail] = x;
            tail = (tail + 1) % capacity;
            size++;
        }

        public Integer dequeue() {
            if(!isEmpty()) {
                size--;
                Integer popElement = elements[head];
                head = (head + 1) % capacity;
                return popElement;
            }
            throw new NoSuchElementException("dequeue(): Queue Empty!");
        }

        public int size() {
            return size;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
