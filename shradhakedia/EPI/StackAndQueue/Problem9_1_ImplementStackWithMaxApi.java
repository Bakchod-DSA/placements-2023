/**
 * Author : Sradha Kedia
 * Page no.: 132, 133, 134, 135 of Epi Java
 * Problem no.: 9.1
 * Difficulty level : Medium
 */

package EPI.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Problem9_1_ImplementStackWithMaxApi {

    // Approach One
    // TC: O(1), SC: O(n)
    /*
    private static class Stack {

        Deque<ElementWithCachedMax> elementWithCachedMax;
        int max;

        Stack() {
            elementWithCachedMax = new LinkedList<>();
            max  = Integer.MIN_VALUE;
        }

        public boolean empty() {
            return elementWithCachedMax.isEmpty();
        }

        public Integer max() {
            return (!elementWithCachedMax.isEmpty())? elementWithCachedMax.peekFirst().max : -1;
        }

        public Integer pop() {
            Integer popped = elementWithCachedMax.removeFirst().element;
            max = (!elementWithCachedMax.isEmpty())? elementWithCachedMax.peekFirst().max : Integer.MIN_VALUE;
            return popped;
        }

        public void push(Integer x) {
            max = Math.max(x, max);
            elementWithCachedMax.addFirst(new ElementWithCachedMax(x, max));
        }
    }

    private static class ElementWithCachedMax {

        int element, max;

        ElementWithCachedMax(int element, int max) {
            this.element = element;
            this.max = max;
        }
    }
    */

    // Approach Two
    // TC: O(1), SC: O(1) in average case, O(n) in worst case
    static class Stack {

        Deque<MaxWithCount> cachedMaxWithCount;
        Deque<Integer> element;

        Stack() {
            cachedMaxWithCount = new LinkedList<>();
            element = new LinkedList<>();
        }

        public boolean empty() {
            return element.isEmpty();
        }

        public Integer max() {
            if(empty()) {
                throw new IllegalStateException("max(): stack empty!");
            }
            return cachedMaxWithCount.peekFirst().max;
        }

        public Integer pop() {
            if(empty()) {
                throw new IllegalStateException("pop() : stack empty!");
            }

            Integer popElement = element.removeFirst();
            if(popElement.equals(cachedMaxWithCount.peekFirst().max)) {
                if(cachedMaxWithCount.peekFirst().count == 1) {
                    cachedMaxWithCount.removeFirst();
                } else {
                    cachedMaxWithCount.peekFirst().count--;
                }
            }

            return popElement;
        }

        public void push(Integer x) {
            element.addFirst(x);
            if(cachedMaxWithCount.isEmpty()) {
                cachedMaxWithCount.addFirst(new MaxWithCount(x, 1));
            } else if(Integer.compare(x, cachedMaxWithCount.peekFirst().max) == 0) {
                cachedMaxWithCount.peekFirst().count++;
            } else if(Integer.compare(x, cachedMaxWithCount.peekFirst().max) > 0) {
                cachedMaxWithCount.addFirst(new MaxWithCount(x, 1));
            }
        }

    }

    private static class MaxWithCount {
        int max, count;

        MaxWithCount(int max, int count) {
            this.max = max;
            this.count = count;
        }
    }

}
