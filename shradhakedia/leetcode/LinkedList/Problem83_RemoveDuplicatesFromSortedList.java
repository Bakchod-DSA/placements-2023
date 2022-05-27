/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Difficulty level: Easy
 */
package leetcode.LinkedList;

public class Problem83_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        // return approachOne(head);
        return approachTwo(head);
    }

    private ListNode approachOne(ListNode head) {
        /*  Approach: iterative
            Time Complexity: O(n)
            Space Complexity: O(1)
        */

        if(head == null) return null;

        ListNode curr = head;
        while(curr != null && curr.next != null) {
            if(curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    private ListNode approachTwo(ListNode head) {
        /*  Approach: recursive
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        if(head == null) return null;
        if(head.next == null) return head;

        ListNode next = approachTwo(head.next);
        if(head.val != next.val) {
            head.next = next;
            return head;
        } else {
            return next;
        }
    }
}
