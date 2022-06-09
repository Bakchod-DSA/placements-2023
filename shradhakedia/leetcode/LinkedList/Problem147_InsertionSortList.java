/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/insertion-sort-list/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

public class Problem147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode curr = head.next;
        while(curr != null) {
            ListNode prev = dummyHead, iter = dummyHead.next;
            while(iter.val <= curr.val && iter != curr) {
                prev = iter;
                iter = iter.next;
            }
            ListNode next = curr.next;
            curr.next = iter;
            prev.next = curr;
            while(iter.next != curr) {
                iter = iter.next;
            }
            iter.next = next;
            curr = next;
        }

        return dummyHead.next;
    }
}
