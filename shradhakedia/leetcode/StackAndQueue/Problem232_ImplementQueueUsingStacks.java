/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/implement-queue-using-stacks/
 * Difficulty level: Easy
 */
package leetcode.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Problem232_ImplementQueueUsingStacks {

    class MyQueue {

        Deque<Integer> stack1;
        Deque<Integer> stack2;

        public MyQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void push(int x) {
            // Time Complexity: O(1)
            stack1.addFirst(x);
        }

        public int pop() {
            // Time Complexity: O(n), Amortized TC: O(1)
            if(stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.addFirst(stack1.removeFirst());
                }
            }
            return stack2.removeFirst();
        }

        public int peek() {
            // Time Complexity: O(n), Amortized TC: O(1)
            if(stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.addFirst(stack1.removeFirst());
                }
            }
            return stack2.peekFirst();
        }

        public boolean empty() {
            // Time Complexity: O(1)
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
