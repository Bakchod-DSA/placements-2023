/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/reverse-linked-list/
 * Difficulty level: Easy
 */
package leetcode.LinkedList;

public class Problem206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return (head == null)? null : approachFour(head);
    }

    private ListNode approachOne(ListNode head) {
        /*  Approach: Recursive
            Time Complexity: O(n ^ 2)
            Space Complexity: O(n), stack space.
        */
        if(head.next == null) {
            return head;
        }

        ListNode dummyReverseHead = approachOne(head.next);
        ListNode current = dummyReverseHead;
        while(current != null && current.next != null) {
            current = current.next;
        }
        current.next = head;
        head.next = null;

        return dummyReverseHead;
    }

    private ListNode approachTwo(ListNode head) {
        /*  Approach: Iterative + Intutive
            Time Complexity: O(n)
            Space Complexity: O(1)
        */
        ListNode node = head;
        ListNode dummy = head.next;
        // setting first node to point to null. since, we preserved it's next.
        head.next = null;

        while(node != null && dummy != null) {
            /*  for eg. 1 -> 2 -> 3 -> 4 -> 5; node = 1, dummy = 2; store 1 in prev and then preserve next of 2 i.e. 3 so that we can change
                next of 2, similarly continue, store 2 in prev now and change next of 3 to point to 2 but before that preserve next of 3 i.e.
                4. Also when we reach end to point 5 to 4, dummy(5's next) is null now but we don't need to iterate further.
            */
            ListNode prev = node;
            node = dummy;
            dummy = node.next;
            node.next = prev;
        }

        return node;
    }

    private ListNode approachThree(ListNode head) {
        /*  Approach: Improved Recursive
            Time Complexity: O(n)
            Space Complexity: O(n), stack space.
        */
        if(head.next == null) {
            return head;
        }

        // no need to loop to get next node as done in approch one, because we have it already and that is our "head.next".
        ListNode nextNode = head.next;
        ListNode newHead = approachOne(nextNode);
        nextNode.next = head;
        head.next = null;

        return newHead;
    }

    private ListNode approachFour(ListNode head) {
        /*  Approach: improve Iterative (**in terms of coding style**)
            Time Complexity: O(n)
            Space Complexity: O(1)
        */
        ListNode node = head;
        ListNode newHead = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = newHead;
            newHead = node;
            node = next;
        }

        return newHead;
    }
}
