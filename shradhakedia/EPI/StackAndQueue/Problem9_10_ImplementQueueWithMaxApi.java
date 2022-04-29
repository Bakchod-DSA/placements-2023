/**
 * Author : Sradha Kedia
 * Page no.: 147, 148, 149 of Epi Java
 * Problem no.: 9.10
 * Difficulty level : Medium
 */

package EPI.StackAndQueue;

import java.util.NoSuchElementException;

public class Problem9_10_ImplementQueueWithMaxApi {

    public class QueueWithMax {

        // Approach 1:
        /*
        Queue<Integer> queue = new LinkedList<>();
        // deque will hold the elements in decreasing order according to max available if we are pushing an element in queue
        // which is greater than last few entries of deque then we remove all such small entries and then enqueue the element in the last.
        Deque<Integer> deque = new LinkedList<>();

        public void enqueue(Integer x) {
            queue.add(x);
            // check if x is greater than some elements entered before (not all) , if so those elements are of no use as x is
            // greater than them, so pop them.
            while (!deque.isEmpty() && deque.peekLast() < x) {
              deque.pollLast();
            }
            deque.offerLast(x);
        }

        public Integer dequeue() {
            // check if we are polling the max element if so, poll it from deque too.
            Integer pollElement = queue.poll();
            if(pollElement.equals(deque.peekFirst())) {
              deque.pollFirst();
            }
            return pollElement;
            }

            public Integer max() {
            return deque.peekFirst();
        }
        */

        // Approach 2:
        Problem9_1_ImplementStackWithMaxApi.Stack enqueue = new Problem9_1_ImplementStackWithMaxApi.Stack();
        Problem9_1_ImplementStackWithMaxApi.Stack dequeue = new Problem9_1_ImplementStackWithMaxApi.Stack();

        public void enqueue(Integer x) {
            enqueue.push(x);
        }

        public Integer dequeue() {
            if (dequeue.empty()) {
                while (!enqueue.empty()) {
                    dequeue.push(enqueue.pop());
                }
            }

            return dequeue.pop();
        }

        public Integer max() {
            if (!enqueue.empty()) {
                if (!dequeue.empty()) {
                    return Math.max(enqueue.max(), dequeue.max());
                } else {
                    return enqueue.max();
                }
            } else if (!dequeue.empty()) {
                return dequeue.max();
            }

            throw new NoSuchElementException("max(): queue Empty");
        }
    }
}
