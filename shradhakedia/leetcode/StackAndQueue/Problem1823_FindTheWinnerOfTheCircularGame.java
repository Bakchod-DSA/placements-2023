/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-the-winner-of-the-circular-game/
 * Difficulty level: Medium
 */
package leetcode.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1823_FindTheWinnerOfTheCircularGame {
    public int findTheWinner(int n, int k) {
        // return approachOne(n, k);
        return approachTwo(n, k);
    }

    private int approachOne(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while(queue.size() > 1) {
            int count = k;
            while(count > 1) {
                count--;
                queue.offer(queue.poll());
            }
            queue.poll();
        }

        return queue.poll();
    }

    private int approachTwo(int n, int k) {
        // TODO
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            ans = (ans + k) % i;
        }
        return ans + 1;
    }
}
