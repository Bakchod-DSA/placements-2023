/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/partition-list/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

public class Problem86_PartitionList {

    public ListNode partition(ListNode head, int x) {
        /*  Approach: Two pointers (Intutive with additional pointers).
            Time Complexity: O(n)
            Space Complexity: O(1)
        */
        ListNode lessHead = new ListNode(0, null);
        ListNode greaterEqualHead = new ListNode(0, null);
        ListNode lessCurr = lessHead, greaterEqualCurr = greaterEqualHead;
        while(head != null) {
            if(head.val < x) {
                lessCurr.next = head;
                lessCurr = lessCurr.next;
            } else {
                greaterEqualCurr.next = head;
                greaterEqualCurr = greaterEqualCurr.next;
            }
            head = head.next;
            lessCurr.next = greaterEqualHead.next;
            greaterEqualCurr.next = null;
        }
        return lessHead.next;
    }
}
