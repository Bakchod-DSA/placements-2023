/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/number-of-recent-calls/
 * Difficulty level: Easy
 */
package leetcode.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Problem933_NumberOfRecentCalls {

    class RecentCounter {

        Deque<Integer> queue;
        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.addLast(t);
            while(!queue.isEmpty()) {
                if(t - queue.peekFirst() > 3000) {
                    queue.removeFirst();
                } else {
                    break;
                }
            }
            return queue.size();
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
