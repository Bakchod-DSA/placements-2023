/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 * Difficulty level: Easy
 */
package leetcode.StackAndQueue;

import java.util.*;

public class Problem1475_FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = Arrays.copyOf(prices, n);
        Deque<Pair> incStack = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            while(!incStack.isEmpty() && incStack.peekFirst().val >= prices[i]) {
                Pair popEle = incStack.removeFirst();
                ans[popEle.index] = popEle.val - prices[i];
            }
            incStack.addFirst(new Pair(prices[i], i));
        }
        return ans;
    }

    class Pair {
        int val;
        int index;
        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
