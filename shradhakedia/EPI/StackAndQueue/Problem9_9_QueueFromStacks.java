/**
 * Author : Sradha Kedia
 * Page no.: 146, 147 of Epi Java
 * Problem no.: 9.9
 * Difficulty level : Medium
 */

package EPI.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Problem9_9_QueueFromStacks {

    public static class Queue {
        Deque<Integer> enqueue;
        Deque<Integer> dequeue;

        Queue() {
            enqueue = new LinkedList<>();
            dequeue = new LinkedList<>();
        }
        public void enqueue(Integer x) {
            enqueue.addFirst(x);
        }

        public Integer dequeue() {
            if(dequeue.isEmpty()) {
                while (!enqueue.isEmpty()) {
                    dequeue.addFirst(enqueue.removeFirst());
                }
            }
            return dequeue.removeFirst();
        }
    }
}
