/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/swap-nodes-in-pairs/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

public class Problem24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        /*  Approach: intutive (play with links)
            Time Complexity: O(n/2) i.e. total no. of pair times
            Space Complexity: O(1)
        */

        if(head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(0, head);
        ListNode curr = dummyHead;
        while(curr.next != null && curr.next.next != null) {
            ListNode temp1 = curr.next.next.next;
            ListNode temp2 = curr.next;
            curr.next = curr.next.next;
            curr.next.next = temp2;
            temp2.next = temp1;
            curr = temp2;
        }

        return dummyHead.next;
    }
}
