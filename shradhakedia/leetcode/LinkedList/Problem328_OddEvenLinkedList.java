/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/odd-even-linked-list/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

public class Problem328_OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        /*  Approach: Two Pointers (Intutive with additional pointers).
            Time Complexity: O(n)
            Space Complexity: O(1)
        */
        ListNode evenHead = new ListNode(0, null);
        ListNode oddHead = new ListNode(0, null);
        ListNode evenCurr = evenHead, oddCurr = oddHead;
        boolean evenIndicate = false;
        while(head != null) {
            if(evenIndicate) {
                evenCurr.next = head;
                evenCurr = evenCurr.next;
            } else {
                oddCurr.next = head;
                oddCurr = oddCurr.next;
            }
            evenIndicate = !evenIndicate;
            head = head.next;
        }

        oddCurr.next = evenHead.next;
        evenCurr.next = null;
        return oddHead.next;
    }
}
