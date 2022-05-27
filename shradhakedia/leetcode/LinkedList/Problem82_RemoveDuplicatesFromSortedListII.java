/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

public class Problem82_RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        // return approachTwo(head);
        return approachOne(head);
    }

    private ListNode approachTwo(ListNode head) {
        /*  Approach: Recursion
            Time Complexity: O(n), calls for distinct rest are skiped but while loop is executed.
                                   so, in total we go through each node once.
            Space Complexity: O(no. of distinct nodes).
        */

        if(head == null || head.next == null) return head;

        if(head.val != head.next.val) {
            head.next = approachTwo(head.next);
            return head;
        }

        //skip till the duplicate values are found
        while(head != null && head.next != null && head.val == head.next.val) {
            head = head.next;
        }

        // return the distinct value to check further
        return approachTwo(head.next);
    }

    private ListNode approachOne(ListNode head) {
        /*  Approach: Iterative (sentinel head + predecessor)
            Time Complexity: O(n)
            Space Complexity: O(1)
        */
        ListNode sentinel = new ListNode(0, head);
        // predecessor = the last node
        // before the sublist of duplicates
        ListNode predecessor = sentinel;

        while(head != null) {
            // if it's a beginning of duplicates sublist
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // skip all duplicates
                predecessor.next = head.next;
            } else {
                // otherwise, move predecessor
                predecessor = predecessor.next;
            }
            // move forward
            head = head.next;
        }
        return sentinel.next;
    }
}
