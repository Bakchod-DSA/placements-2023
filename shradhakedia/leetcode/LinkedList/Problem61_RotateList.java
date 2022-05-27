/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/rotate-list/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

public class Problem61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        // return approachOne(head, k);
        return approachTwo(head, k);
    }

    private ListNode approachOne(ListNode head, int k) {
        /*  Approach: brute force
            Time Complexity: O(n + kn)
            Space complexity: O(k)
        */
        int len = getLength(head);
        ListNode dummyHead = new ListNode(0, head);
        // if len = 0 or 1 then the result will be same as head or else we need to rotate only k mod n times.
        return (len == 0 || len == 1)? head : rotateRecursive(dummyHead, k % len);
    }

    private int getLength(ListNode head) {
        /*  Approach: brute force
            Time Complexity: O(n)
            Space complexity: O(1)
        */
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private ListNode rotateRecursive(ListNode dummyHead, int k) {
        /*  Approach: brute force
            Time Complexity: O(kn)
            Space complexity: O(k)
        */

        if(k == 0) {
            return dummyHead.next;
        }

        ListNode head =  rotateRecursive(dummyHead, k - 1);
        ListNode curr = head, prev = dummyHead;
        while(curr != null && curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        curr.next = head;

        return curr;
    }

    private ListNode approachTwo(ListNode head, int k) {
        /*  Approach: intutive
            Time Complexity: O(2n), one n for finding len and tail, and one for finding stepsToNewHead which can be n - 1 in worst case
                             when k = 1.
            Space Complexity: O(1)
        */
        if(head == null) return null;

        // find len, tail
        int len = 1;
        ListNode tail = head;
        while(tail.next != null) {
            len++;
            tail = tail.next;
        }
        // k = k mod n, if k = 0 means no need to rotate as it will lead to same.
        k %= len;
        if(k == 0) return head;

        // create cycle
        tail.next = head;
        int stepsToNewHead = len - k;
        while(stepsToNewHead-- > 1) {
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }
}
