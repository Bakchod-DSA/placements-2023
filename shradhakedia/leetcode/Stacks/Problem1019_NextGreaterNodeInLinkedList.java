/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/next-greater-node-in-linked-list/
 * Difficulty level: Medium
 */
package leetcode.Stacks;

import java.util.Deque;
import java.util.LinkedList;

public class Problem1019_NextGreaterNodeInLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[] nextLargerNodes(ListNode head) {
        int len = length(head);
        int[] ans = new int[len];
        Deque<Pair> stack = new LinkedList<>();
        int index = 0;
        while(head != null) {
            while(!stack.isEmpty() && head.val > stack.peekFirst().node.val) {
                ans[stack.peekFirst().index] = head.val;
                stack.removeFirst();
            }
            stack.addFirst(new Pair(head, index++));
            head = head.next;
        }

        return ans;
    }

    private int length(ListNode head) {
        int len = 0;
        while(head != null) {
            ++len;
            head = head.next;
        }
        return len;
    }

    class Pair {
        ListNode node;
        int index;
        Pair(ListNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
