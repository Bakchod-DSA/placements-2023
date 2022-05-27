/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

public class Problem19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // return approachOne(head, n);
        return approachTwo(head, n);
    }

    private ListNode approachOne(ListNode head, int n) {
        /*  Approach: Brute Force
            Time Complexity: O(2n)
            Space Complexity: O(1)
        */

        ListNode dummy = head;
        int len = getLength(head);
        int indexFromBeg = len - n;

        if(indexFromBeg == 0) return dummy.next;

        while(indexFromBeg > 1) {
            head = head.next;
            indexFromBeg--;
        }
        if(head.next != null) head.next = head.next.next;
        return dummy;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private ListNode approachTwo(ListNode head, int n) {
        /*  our goal is to find len - n, which we do in two pass in approach one, but using two pointers we can do this in a single
            pass. one pointer that moves n times before, now after it moved n times, start by taking another pointer that moves along
            with first till first reaches tail, by this first pointer moved len - n distance which is the same distance moved by second
            pointer and we reached at the (len - n)th node, we can delete the next node that is nth node from the end.
            Approach: Two Pointers
            Time Complexity: O(n)
            Space Complexity: O(1)
        */

        ListNode dummyHead = new ListNode(0,head);
        ListNode first = dummyHead.next, second = dummyHead;
        while(n-- > 0) {
            first = first.next;
        }
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyHead.next;
    }
}
