/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/add-two-numbers/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

public class Problem2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return approachOne(l1, l2);
    }

    public ListNode approachOne(ListNode l1, ListNode l2) {
        /*  Approach: brute force, iterative
            Time Complexity: O(max(m, n))
            Space Complexity: O(max(m, n)) + 1
        */

        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while(l1 != null || l2 != null) {
            int x = (l1 != null)? l1.val : 0;
            int y = (l2 != null)? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry > 0) {
            current.next = new ListNode(carry, null);
        }

        return dummyHead.next;
    }

}
