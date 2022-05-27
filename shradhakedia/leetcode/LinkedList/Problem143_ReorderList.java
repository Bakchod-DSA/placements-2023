/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/reorder-list/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

import java.util.Deque;
import java.util.LinkedList;

public class Problem143_ReorderList {
    public void reorderList(ListNode head) {
        // approachOne(head);
        // approachTwo(head);
        approachThree(head);
    }

    private void approachOne(ListNode head) {
        /*  Approach: Stack + Two pointer
            Time Complexity: O(n + n/2), n for finding middle and then pushing in stack from middle, n/2 for popping from stack
            Space Complexity: O(n/2), stack will hold atmax half of the elements of linked list.
        */
        // find middle of the list
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //push second half of the list into the stack
        ListNode secondHalf = slow.next;
        slow.next = null;
        Deque<ListNode> stack = new LinkedList<>();
        while(secondHalf != null) {
            stack.addFirst(secondHalf);
            secondHalf = secondHalf.next;
        }
        // insert the elements of stack in the first half of LL alternatively.
        while(!stack.isEmpty()) {
            ListNode temp = head.next;
            head.next = stack.removeFirst();
            head.next.next = temp;
            head = temp;
        }
    }

    private ListNode approachTwo(ListNode head) {
        /*  Approach: recursion
            Time Complexity: O(n * n/2) = O(n ^ 2), n for moving the last node and n/2 for every recursive call
            Space Complexity: O(n/2), stack size can be at max n/2.
        */
        if(head == null ||  head.next == null || head.next.next == null) {
            return head;
        }

        ListNode curr = head;
        while(curr.next.next != null) {
            curr = curr.next;
        }
        ListNode tail = curr.next;
        curr.next = null;
        ListNode recurList = approachTwo(head.next);
        head.next = tail;
        tail.next = recurList;
        return head;
    }

    private void approachThree(ListNode head) {
        /*  Discuss Link: https://leetcode.com/problems/reorder-list/discuss/1640806/Java-or-2-Approach-or-2-Pointer-Approach
            step0: given, l =  1 -> 2 -> 3 -> 4 -> 5 -> 6
            step1: l1 = 1 -> 2 -> 3
            step2: l2 = 4 -> 5 -> 6
            step3: l2rev = 6 -> 5 -> 4
            step4: now, merge l1 and l2rev
            -----------------------------------
            Approach: Two Pointers
            Time Complexity: O(n)
            Space Complexity: O(1)
        */
        ListNode mid = midNode(head);

        ListNode l2rev = revNode(mid.next);
        mid.next = null;

        merge(head, l2rev);
    }

    private ListNode midNode(ListNode head) {
        // find middle of the list
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode revNode(ListNode head) {
        ListNode curr = head, newHead = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = next;
        }
        return newHead;
    }

    private void merge(ListNode l1, ListNode l2) {
        while(l1 != null) {
            ListNode temp = l1.next;
            l1.next = l2;
            l2 = temp;
            l1 = l1.next;
        }
    }
}
