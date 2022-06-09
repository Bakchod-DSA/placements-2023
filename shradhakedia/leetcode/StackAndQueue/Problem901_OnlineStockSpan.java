/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/daily-temperatures/
 * Difficulty level: Medium
 */
package leetcode.StackAndQueue;

import java.util.*;

public class Problem901_OnlineStockSpan {

    class StockSpanner {

        /*  Approach: Monotonic Stack
            Time Complexity: O(n)
            Space Complexity: O(n), n = stack.size
        */
        Deque<Pair> stack;
        public StockSpanner() {
            stack = new LinkedList<>();
        }

        public int next(int price) {
            int count = 1;
            while(!stack.isEmpty() && stack.peekFirst().price <= price) {
                Pair pair = stack.removeFirst();
                count += pair.count;
            }
            stack.addFirst(new Pair(price, count));
            return count;
        }
    }

    class Pair {
        int price;
        int count;
        Pair(int price, int count) {
            this.price = price;
            this.count = count;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
