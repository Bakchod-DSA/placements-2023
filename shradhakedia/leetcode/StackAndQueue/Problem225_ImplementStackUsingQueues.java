/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/implement-stack-using-queues/
 * Difficulty level: Easy
 */
package leetcode.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Problem225_ImplementStackUsingQueues {

    class MyStack {
        // using one queue
        Queue<Integer> queue;
        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            // Time Complexity: O(n)
            int temp;
            int iter = queue.size();
            queue.offer(x);
            while(iter > 0) {
                iter--;
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            // Time Complexity: O(1)
            return queue.poll();
        }

        public int top() {
            // Time Complexity: O(1)
            return queue.peek();
        }

        public boolean empty() {
            // Time Complexity: O(1)
            return queue.isEmpty();
        }
    }

/*
class MyStack {
    // using two queues
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        // Time Complexity: O(1)
        queue1.offer(x);
    }

    public int pop() {
        // Time Complexity: O(n)
        if(!queue1.isEmpty()) {
            while(queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else {
            while(queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }

    public int top() {
        // Time Complexity: O(n)
        if(!queue1.isEmpty()) {
            while(queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            int top = queue1.poll();
            queue2.offer(top);
            return top;
        } else {
            while(queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            int top = queue2.poll();
            queue1.offer(top);
            return top;
        }
    }

    public boolean empty() {
        // Time Complexity: O(1)
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
*/

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
