/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

public class Problem1721_SwappingNodesInLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        // return approachOne(head, k);
        return approachTwo(head, k);
    }

    public ListNode approachOne(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode first, second;
        ListNode prevFirst = null, prevSecond = null;

        while(k > 1) {
            // k steps.
            k--;
            prevFirst = fast;
            fast = fast.next;
        }
        first = fast;

        while(fast.next != null) {
            // n - k steps.
            prevSecond = slow;
            slow = slow.next;
            fast = fast.next;
        }
        second = slow;

        if(prevFirst != null) prevFirst.next = second;
        if(prevSecond != null) prevSecond.next = first;
        ListNode temp = first.next;
        first.next = second.next;
        second.next = temp;

        return (prevFirst == null)? second: (prevSecond == null)? first: head;
    }

    public ListNode approachTwo(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode first, second;

        while(k > 1) {
            // k steps.
            k--;
            fast = fast.next;
        }
        first = fast;

        while(fast.next != null) {
            // n - k steps.
            slow = slow.next;
            fast = fast.next;
        }
        second = slow;

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}
